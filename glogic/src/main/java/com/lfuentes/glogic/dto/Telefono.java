package com.lfuentes.glogic.dto;

public class Telefono {

	private Long number;
	private Integer citycode;
	private Integer contrycode;
	
	public Telefono() {
	}
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Integer getCitycode() {
		return citycode;
	}
	public void setCitycode(Integer citycode) {
		this.citycode = citycode;
	}
	public Integer getContrycode() {
		return contrycode;
	}
	public void setContrycode(Integer contrycode) {
		this.contrycode = contrycode;
	}
	
	
	
}
