package com.rif.juntadas.api;

import com.google.gson.Gson;

public class ApiResponse {
	
	public enum Status {
		ERROR, OK, WARNING
	}
	
	private Status status;
	private Object message;
	
	public ApiResponse(Status status, Object message) {
	    this.status = status;
	    this.message = message;
	}
	
	public String toJson() {
    	Gson gson = new Gson();
    	String json = gson.toJson(this);
    	return json;
    }

    public static ApiResponse constructFromJson(String json) {
    	Gson gson = new Gson();
    	return gson.fromJson(json, ApiResponse.class);
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}
    
}
