package com.docplexus.Tokendemo.service;

import java.util.List;

import com.docplexus.Tokendemo.bean.Customer;
import com.docplexus.Tokendemo.bean.Token;

public interface TokenService {
	public Token createToken(long userId);
//	public List<Token> getToken();
	public Token findById(long id);
//	public Token update(Token token, long id);
//	public void deleteUserById(int id);
	public Token nextByPriority(int counter);
	public void updateTokenClose(long id);
}
