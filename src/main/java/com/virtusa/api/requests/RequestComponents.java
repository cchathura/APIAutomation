package com.virtusa.api.requests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.log4j.Logger;

import com.virtusa.api.serviceCaller.RESTServiceCaller;


public class RequestComponents {
URL url;
String serviceType;
String requestMethod;
private Map<String,String> requestProperties;
final static Logger logger = Logger.getLogger(RequestComponents.class);
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

public URL getURL(){
	return url;
}
public String getUrl() {
	return url.toString();
}
public void setUrl(String url) {
	try {
		this.url = new URL(url);
	} catch (MalformedURLException e) {
		logger.error("Error on setting URL " + e.getMessage());
	}
}
public String getServiceType() {
	return serviceType;
}
public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
}


}
