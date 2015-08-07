package com.virtusa.api.propertyReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.virtusa.api.requestLoader.RequestFileLoader;
import com.virtusa.api.requests.Request;
import com.virtusa.api.requests.RequestComponents;
import com.virtusa.api.requests.RequestFactory;
import com.virtusa.api.serviceCaller.ServiceRequestProperties;

public class PropertyReader {
	static Configuration config;
	public void loadPropertyFile() throws ConfigurationException{
	ConfigurationFactory factory = new ConfigurationFactory("config.xml");
	 config = factory.getConfiguration();
	}

	public Configuration getConfig(String propertyFileName) throws ConfigurationException{
		CompositeConfiguration config = new CompositeConfiguration();
		config.addConfiguration(new PropertiesConfiguration(propertyFileName));
		return config;
	}
	
	
	public RequestComponents createRequestComponents(Configuration config){
		RequestComponents requestComponents = new RequestComponents();
		requestComponents.setUrl(config.getString("url"));
		requestComponents.setServiceType(config.getString("serviceType"));
		requestComponents.setRequestMethod(config.getString("requestMethod"));
		return requestComponents;
	}
	/**
	 * @param config
	 * @return
	 */
	public Map<String,String> createRequestPropertiesMap(Configuration config){
		Map<String,String> requestProp = new HashMap<String, String>();
		Iterator<String> keys = config.getKeys();
	    	List<String> keyList = new ArrayList<String>();
	    	    while(keys.hasNext()){
	    	    	String keyName=keys.next();
	    	    	if(keyName.contains("requestProperties")){
	    	    keyList.add(keyName);
	    	    	}
	    	}
	    	 
	    	    for (String kName : keyList) {
	    	    	System.out.println(config.getString(kName)); 	
	    	    	requestProp.put(kName, config.getString(kName));
			}
		return requestProp;
		
		
	}
	public Request createRequestObj(String propertyFileName) throws ConfigurationException{
		Configuration config=getConfig(propertyFileName);
		RequestComponents requestComponents = createRequestComponents(config);
		requestComponents.setRequestProperties(createRequestPropertiesMap(config));
		
		Request request = RequestFactory.getInstace().createRequest(requestComponents.getServiceType());
		request.setRequestComponents(requestComponents);
		
	
		return request;
	}
}
 