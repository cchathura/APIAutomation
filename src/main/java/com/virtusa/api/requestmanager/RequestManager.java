package com.virtusa.api.requestmanager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;

import com.virtusa.api.propertyReader.PropertyReader;
import com.virtusa.api.requestLoader.RequestFileLoader;
import com.virtusa.api.requestType.ServiceType;
import com.virtusa.api.requests.Request;
import com.virtusa.api.requests.Respond;
import com.virtusa.api.serviceCaller.ServiceCaller;
import com.virtusa.api.serviceCallerFactory.ServiceCallerFactory;

public class RequestManager implements RequestObserver {
	final static Logger logger = Logger.getLogger(RequestManager.class);
	static int lastRequestNum=0;
	static List<Request> requestList = new ArrayList<Request>();
	static Map<Request, Respond> resultMap = new HashMap<Request, Respond>();
	
public String send(Request request){
	//check request method
	
	ServiceCaller serviceCaller = ServiceCallerFactory.createServiceCaller(request.getRequestComponents().getServiceType());
	serviceCaller.addObserver(this);
	serviceCaller.setRequest(request);
	//resultMap.put(request,null);
	requestList.add(request);
	Thread thread = new Thread(serviceCaller);
	thread.start();
	return "";
}

/*public void update(Observable o, Object arg) {
	// update respon map 
//	resultMap.put(o, arg);
}*/

public void update(Request request, Respond respond){
	resultMap.put(request, respond);
	requestList.remove(request);
	if(requestList.isEmpty()){
	System.out.println(resultMap.size());
	}
}
public Request createRequest(String PropertyFileName){
	//create request by readig the property files.
	PropertyReader propReader = new PropertyReader();
	Request request = null;
	try {
		request = propReader.createRequestObj(PropertyFileName);
		request.setRequestnumber(getLastRequestNum());
		logger.info("create object" + request);
	} catch (ConfigurationException e) {
		// TODO Auto-generated catch block
		logger.error("error on creating requst object " + e.getMessage());
	}

	return request;
}

public synchronized int getLastRequestNum(){
	lastRequestNum++;
	logger.info("request Naumber " + lastRequestNum);
	return lastRequestNum;
}
}
