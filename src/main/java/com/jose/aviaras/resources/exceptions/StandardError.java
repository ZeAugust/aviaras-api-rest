package com.jose.aviaras.resources.exceptions;

public class StandardError {
	
	private Long timeStanp;
	private Integer status;
	private String error;
	
	public void StandarError() {
		
	}

	public StandardError(Long timeStanp, Integer status, String error) {
		super();
		this.timeStanp = timeStanp;
		this.status = status;
		this.error = error;
	}

	public Long getTimeStanp() {
		return timeStanp;
	}

	public void setTimeStanp(Long timeStanp) {
		this.timeStanp = timeStanp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
