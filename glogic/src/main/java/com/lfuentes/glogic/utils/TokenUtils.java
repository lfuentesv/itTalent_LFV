package com.lfuentes.glogic.utils;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtils implements Serializable{

	private static final long serialVersionUID = 7450588564010985148L;

	private static String secret = "secreto";
	
	public static final long JWT_TOKEN_DURACION = 2 * 60 * 60 * 10000; //2H
	
	public static String getJWTToken(String nombreUsuario ) {
	
		String token = Jwts
				.builder()
				.setId("lfv")
				.setSubject(nombreUsuario)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_DURACION))
				.signWith(SignatureAlgorithm.HS512,secret.getBytes()).compact();

		return token;
	}
	
}
