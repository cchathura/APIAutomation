package com.virtusa.api.serviceCallerFactory;

import java.net.Authenticator.RequestorType;

import com.virtusa.api.requestType.ServiceType;
import com.virtusa.api.serviceCaller.RESTServiceCaller;
import com.virtusa.api.serviceCaller.ServiceCaller;
import com.virtusa.api.serviceCaller.ServiceRequestProperties;

public class ServiceCallerFactory {
public static ServiceCaller createServiceCaller(String serviceType){
	if(serviceType.equalsIgnoreCase(ServiceType.REST.getServiceType())){
		return new RESTServiceCaller();
	}else{
		return null;
	}
}
}
