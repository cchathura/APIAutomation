package com.virtusa.api.requestType;

public enum ServiceType {
	REST("rest"), SOAP("soap");
	private String type;
	private ServiceType(String type){
		this.type=type;
	}
	public String getServiceType(){
		return this.type;
	}
}
