package com.virtusa.api.requests;

import java.util.Map;


public class RequestComponents {
String url;
String serviceType;
String requestMethod;
private Map<String,String> requestProperties;

/**
 * This may not be usefull
 * @param key
 * @param value
 */
public void addRequestProperties(String key, String value){
	requestProperties.put(key, value);
}



public String getRequestMethod() {
	return requestMethod;
}



public void setRequestMethod(String requestMethod) {
	this.requestMethod = requestMethod;
}



public Map<String, String> getRequestProperties() {
	return requestProperties;
}

public void setRequestProperties(Map<String, String> requestProperties) {
	this.requestProperties = requestProperties;
}

public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getServiceType() {
	return serviceType;
}
public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
}


}
