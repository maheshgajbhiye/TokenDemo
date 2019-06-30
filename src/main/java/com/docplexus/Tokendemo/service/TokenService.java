package com.docplexus.Tokendemo.service;

import com.docplexus.Tokendemo.bean.Token;

public interface TokenService {
	public Token createToken(long userId);

	public Token findById(long id);

	public Token nextByPriority(int counter);

	public void updateToken(Token token, String status);
}
