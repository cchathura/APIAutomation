package com.virtusa.api.requestType;

public enum RequestMethod {
GET("GET"), POST("POST");
private String type;
private RequestMethod(String type){
	this.type=type;
}
public String getRequestMethod(){
	return this.type;
}
}
