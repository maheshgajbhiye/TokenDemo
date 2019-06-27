package com.docplexus.Tokendemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docplexus.Tokendemo.bean.Token;
import com.docplexus.Tokendemo.service.TokenService;

@RestController
@RequestMapping(value = { "/token" })
public class TokenController {

	@Autowired
	TokenService tokenService;

	@GetMapping(value = "/generate/{accountNumber}", produces = "application/json")
	public ResponseEntity<Token> generateToken(@PathVariable("accountNumber") long accountNumber) {
		Token token = tokenService.createToken(accountNumber);
		if (token == null) {
			return new ResponseEntity<Token>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Token>(token, HttpStatus.CREATED);
	}

	@GetMapping(value = "/next/{counterId}", produces = "application/json")
	public ResponseEntity<Token> nextByPriority(@PathVariable("counterId") int counterId) {
		System.out.println("Assigning Token for counter- " + counterId);
		Token token = tokenService.nextByPriority(counterId);
		// display token with counter no by socket programming.
		return new ResponseEntity<Token>(token, HttpStatus.OK);
	}
	
	@PutMapping(value="/close/{tokenId}", headers="Accept=application/json")
    public ResponseEntity<String> updateUser(@PathVariable("tokenId") long tokenId)
    {
         Token token = tokenService.findById(tokenId);
        if (token==null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        tokenService.updateTokenClose(token.getId());
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
