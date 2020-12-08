package com.lfuentes.glogic.utils;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtils implements Serializable{

	private static Logger logger = LoggerFactory.getLogger(TokenUtils.class);
	
	private static final long serialVersionUID = 7450588564010985148L;

	private static String secret = "secreto";
	
	public static final long JWT_TOKEN_DURACION = 2 * 60 * 60 * 10000; //2H
	
	public static String getJWTToken(String nombreUsuario ) {
		logger.info("getJWTToken[INI] nombreUsuario: "+nombreUsuario);
		String token = Jwts
				.builder()
				.setId("lfv")
				.setSubject(nombreUsuario)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_DURACION))
				.signWith(SignatureAlgorithm.HS512,secret.getBytes()).compact();

		logger.info("getJWTToken[FIN] token: "+token);
		return token;
	}
	
}
