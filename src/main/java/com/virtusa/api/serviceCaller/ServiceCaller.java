package com.virtusa.api.serviceCaller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.virtusa.api.requestmanager.RequestObserver;
import com.virtusa.api.requests.Request;

public interface ServiceCaller extends Runnable {



	int responceCode=200;
	
	/**
	 * @return
	 * @throws IOException
	 */
	public String[] getHttpResponse() throws IOException;
	
	
	/**
	 * @return
	 * @throws IOException
	 */
	public int getResponceCode()throws IOException ;

/**
 * @return
 */
public String callService() throws IOException;
/**
 * @param request
 */
public void setRequest(Request request);
public void addObserver(RequestObserver observerObj);
	


	


	
	
	
	
	
}
