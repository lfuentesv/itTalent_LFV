package com.lfuentes.glogic.dto;

import java.util.List;

import javax.validation.constraints.Pattern;

public class RegistroRequest {

	private String name;
	@Pattern(regexp = "^[a-z]{1,7}@([\\w-]+\\.)+cl$" , message="El correo debe cumplir con el formato: aaaaaaa@dominio.cl")
	private String email;
	@Pattern(regexp = "^[A-Z]{1}[a-z]*[0-9]{2}$" , message="La contraseña debe cumplir con el formato: Una mayúscula, letras minúsculas y dos números")
	private String password;
	private List<Telefono> phones;
	
	public RegistroRequest() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Telefono> getPhones() {
		return phones;
	}

	public void setPhones(List<Telefono> phones) {
		this.phones = phones;
	}
	
	
	
}
