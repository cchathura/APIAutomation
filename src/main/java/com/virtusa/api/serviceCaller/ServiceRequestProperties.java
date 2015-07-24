package com.virtusa.api.serviceCaller;

import java.net.URL;
import java.util.Map;

public class ServiceRequestProperties {

	/**
	 * 
	 */
	private String requestMethod;
	
	/**
	 * 
	 */
	private Map<String,String> requestProperties;
	
	/**
	 * 
	 */
	private URL url;

	/**
	 * @return
	 */
	public String getRequestMethod() {
		return requestMethod;
	}

	/**
	 * @param requestMethod
	 */
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	/**
	 * @return
	 */
	public Map<String, String> getRequestProperties() {
		return requestProperties;
	}

	/**
	 * @param requestProperties
	 */
	public void setRequestProperties(Map<String, String> requestProperties) {
		this.requestProperties = requestProperties;
	}

	/**
	 * @return
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * @param url
	 */
	public void setUrl(URL url) {
		this.url = url;
	}
	
}
