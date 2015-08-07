package com.virtusa.api.serviceCaller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.apache.log4j.Logger;

import com.virtusa.api.requestmanager.RequestObserver;
import com.virtusa.api.requests.Request;
import com.virtusa.api.requests.Respond;

public class RESTServiceCaller extends Observable implements ServiceCaller {
	private ServiceRequestProperties requestProperties;
	private HttpURLConnection httpUrlConnection;
	private List<RequestObserver> observersList = new ArrayList<RequestObserver>(); 
	private Respond respond;
	private Request request;
	
	final static Logger logger = Logger.getLogger(RESTServiceCaller.class);
	
	/**
	 * @param request
	 */
	public RESTServiceCaller() {
		
		
		
	}

	/**
	 * @param request
	 */
	public void setRequest(Request request) {
		this.request = request;
	}


	/**
	 * 
	 */
	private void setRequestProperties(){
	try {
		httpUrlConnection.setRequestMethod(request.getRequestComponents().getRequestMethod());
		logger.info("Set request Method to "+ request.getRequestComponents().getRequestMethod());
		for (Map.Entry<String, String> entry : request.getRequestComponents().getRequestProperties().entrySet())
		{
			String[] requestProArr = entry.getValue().split(":");
			if(requestProArr.length>1){
			
		   httpUrlConnection.setRequestProperty(requestProArr[0].trim(), requestProArr[1].trim());
		   logger.info("set request Property "+requestProArr[0]+" "+requestProArr[1]);
			}
		} 
		
		
	} catch (ProtocolException e) {
		// TODO Auto-generated catch block
		logger.error("Protocal exeption "+ e.getMessage());
	}
	}
	
	public void addObserver(RequestObserver observerObj){
		observersList.add(observerObj);
		logger.info("add Observer to observerList");
	}
	
	/* (non-Javadoc)
	 * @see com.virtusa.api.serviceCaller.ServiceCaller#getHttpResponse()
	 */
	public String[] getHttpResponse() throws IOException{
		String responseBody="";
		int resCode=200;
		createConnection();
		setRequestProperties();
		resCode=httpUrlConnection.getResponseCode();
		if(resCode!=200){
			String respondArray[] = {String.valueOf(resCode),""}; 
			return respondArray;
		}
		String[] respondArray = new String[2];
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(httpUrlConnection.getInputStream())));
	 
			String output="";
			
			while ((output = br.readLine()) != null) {
				responseBody +=output;
			}
			closeConnection();
			respondArray[0]=String.valueOf(resCode);
			respondArray[1]= responseBody;
			return respondArray;
	 
	}
	
	/**
	 * @throws IOException
	 */
	private void createConnection() throws IOException{
 httpUrlConnection = (HttpURLConnection) request.getRequestComponents().getURL().openConnection();
 logger.info("create connection on "+request.getRequestComponents().getURL().toString());
	}
	
	/**
	 * 
	 */
	private void closeConnection(){
		httpUrlConnection.disconnect();
		logger.info("connection cosed" + httpUrlConnection.toString());
	}

	/* (non-Javadoc)
	 * @see com.virtusa.api.serviceCaller.ServiceCaller#getResponceCode()
	 */
	public int getResponceCode() throws IOException {
		createConnection();
		setRequestProperties();
		
		int responseCode = httpUrlConnection.getResponseCode();
		closeConnection();
		return responseCode;
		
	}

	public void run() {
		try {
			createRespond();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		notifyObservers();
		
	}

	public String callService() throws IOException {
		String responseBody="";
		createConnection();
		setRequestProperties();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(httpUrlConnection.getInputStream())));
	 
			String output="";
			
			while ((output = br.readLine()) != null) {
				responseBody +=output;
			}
			closeConnection();
			return responseBody;
	}

	public void notifyObservers(){
		//notify the managers
		for (RequestObserver observerObj : observersList) {
			observerObj.update(this.request,respond);
		}
	}
	
	/**
	 * @throws IOException
	 */
	public void createRespond() throws IOException{
		respond = new Respond();
		String[] resArray =getHttpResponse();
		respond.setStatusCode(Integer.valueOf(resArray[0]));
		respond.setRespond(resArray[1]);
		
		
	}
}
