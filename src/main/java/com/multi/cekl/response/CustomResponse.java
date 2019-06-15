package com.multi.cekl.response;

import java.io.Serializable;

public class CustomResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String responseCode;
	private String responseMessage;

	public CustomResponse(String responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	@Override
	public String toString() {
		return "CustomResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + "]";
	}
}
