package com.docplexus.Tokendemo.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.docplexus.Tokendemo.bean.Customer;
import com.docplexus.Tokendemo.bean.Token;
import com.docplexus.Tokendemo.dao.CustomerRepository;
import com.docplexus.Tokendemo.dao.TokenRepository;
import com.docplexus.common.enums.StatusEnum;

@Service
@Transactional
public class TokenServiceImp implements TokenService {

	@Autowired
	TokenRepository tokenRepository;

	@Autowired
	CustomerRepository customerRepository;

	public Token createToken(long accountNumber) {
		Date date = new Date();
		Token token = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		List<Customer> customers = customerRepository.findByAccountNumber(accountNumber);
		for (Customer customer : customers) {
			if (customer != null) {
				token = new Token();
				token.setStatus(StatusEnum.ACTIVE.getStatus()); // Status as Active
				token.setCreationDate(date);
				token.setCustomerid(customer.getId());

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				List<Token> tokens = tokenRepository.findAllByCreationDate(sdf.format(new Date()));
				if (null == tokens) {
					token.setTokenNumber(1);
				} else {
					token.setTokenNumber(tokens.size() + 1);
				}
				return tokenRepository.saveAndFlush(token);
			} else {
				System.out.println("Customer Not exists with Account Number :: " + accountNumber);
			}
		}
		return token;
	}

	public Token nextByPriority(int counter) {
		Token nextToken = null;
		List<Token> tokens = tokenRepository.findByStatusAndPriority();
		System.out.println("tokens :: " + tokens);
		for (Token token : tokens) {
			System.out.println("token :: " + token);
			token.setCounterNumber(counter);
			token.setStatus(StatusEnum.PROCESSING.getStatus()); // status as processing
			token.setCounterNumber(counter);
			tokenRepository.save(token);
			nextToken = token;
			break;
		}
		System.out.println("nextToken :: " + nextToken);
		return nextToken;
	}

	public Token findById(long id) {
		return tokenRepository.findById(id);
	}

	public void updateToken(Token token, String status) {
		token.setStatus(status);
	}

}
