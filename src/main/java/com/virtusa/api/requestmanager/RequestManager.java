package com.virtusa.api.requestmanager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.virtusa.api.propertyReader.PropertyReader;
import com.virtusa.api.requests.Request;
import com.virtusa.api.requests.Respond;
import com.virtusa.api.serviceCaller.ServiceCaller;
import com.virtusa.api.serviceCallerFactory.ServiceCallerFactory;

public class RequestManager implements RequestObserver {
	final static Logger logger = Logger.getLogger(RequestManager.class);
	static int lastRequestNum=0;
	static List<Request> requestList = new ArrayList<Request>();
	static Map<Request, Respond> resultMap = new HashMap<Request, Respond>();
	private static Boolean isComplete = false;
	
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




/**
 * @param propertyFileMap
 * @return
 * for accept property files as a map
 */
public Map<Request, Respond> send(Map<String,String> propertyFileMap){
	//check request method
	
	for (Map.Entry<String, String> entry : propertyFileMap.entrySet())
	{
	    Request request = new Request();
	    request=createRequest(entry.getValue());
	    ServiceCaller serviceCaller = ServiceCallerFactory.createServiceCaller(request.getRequestComponents().getServiceType());
		serviceCaller.addObserver(this);
		serviceCaller.setRequest(request);
		//resultMap.put(request,null);
		requestList.add(request);
		Thread thread = new Thread(serviceCaller);
		thread.start();
	    
	}
	while(!isComplete){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	return resultMap;
}



/*public void update(Observable o, Object arg) {
	// update respon map 
//	resultMap.put(o, arg);
}*/

public void update(Request request, Respond respond){
	resultMap.put(request, respond);
	requestList.remove(request);
	if(requestList.isEmpty()){
		isComplete=true;
	/*System.out.println(resultMap.size());
	String jsonText = JSONObject.toJSONString(resultMap);

	
	String jsonFormattedString = jsonText.replace("", "");
	JSONParser parser = new JSONParser();
	try {
		JSONObject json = (JSONObject) parser.parse(jsonText);
		System.out.println("hhhhhhhhhhh"+json.keySet());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
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
