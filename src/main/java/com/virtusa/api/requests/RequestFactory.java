package com.virtusa.api.requests;

import com.virtusa.api.requestType.ServiceType;

public class RequestFactory {

	static RequestFactory instance =null;
	public static RequestFactory getInstace(){
		if(instance ==null){
			synchronized (RequestFactory.class) {
			if(instance==null){	
			instance = new RequestFactory();
			
			}
			}
		}
			return instance;
			}
	public Request createRequest(String type){
		if(type.equalsIgnoreCase(ServiceType.REST.getServiceType())){
			return new RESTRequest();
		}else{
			return null;
		}
	}
	
}
