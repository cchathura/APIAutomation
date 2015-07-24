package com.virtusa.api.requestmanager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import com.virtusa.api.requestType.ServiceType;
import com.virtusa.api.requests.Request;
import com.virtusa.api.requests.Respond;
import com.virtusa.api.serviceCaller.ServiceCaller;
import com.virtusa.api.serviceCallerFactory.ServiceCallerFactory;

public class RequestManager implements Observer {
	static int lastServiceCallNum=0;
	static List<Respond> respondList = new ArrayList<Respond>();
	static Map<Request, Respond> resultMap = new HashMap<Request, Respond>();
	
public String send(Request request){
	//check request method
	ServiceCaller serviceCaller = ServiceCallerFactory.createServiceCaller(ServiceType.REST);
	serviceCaller.setRequest(request);
	resultMap.put(request,null);
	return "";
}

public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
}

public Request createRequest(){
	//create request by readig the property files.
	return null;
}
}
