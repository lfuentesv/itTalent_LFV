package com.lfuentes.glogic.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Usuario {
	
	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_USUARIO", nullable = false, updatable = false)
	private List<Telefono> phones;
	
	private Date created;
	private Date modified;
	private Date last_login;
	private String token;
	private Boolean isactive;
	
	public List<Telefono> getPhones() {
		return phones;
	}

	public void setPhones(List<Telefono> phones) {
		this.phones = phones;
	}

	public Usuario() {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	
	@PreUpdate
	void modifiedAt() {
	    this.modified = new Date();
	}
	
	@PrePersist
	void createdAt() {
		this.id = UUID.randomUUID().toString();
	    this.created = new Date();
	    this.last_login = new Date();
	    this.isactive = true;
	}
	
}
