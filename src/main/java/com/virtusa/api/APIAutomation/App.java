package com.virtusa.api.APIAutomation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import PropertyLoader.PropertyLoader;
import PropertyLoader.ReadPropertyFile;
import PropertyLoader.ServicePropertyLoader;

import com.virtusa.api.requestLoader.RequestFileLoader;
import com.virtusa.api.requestLoader.RequestLoader;
import com.virtusa.api.serviceCaller.ServiceCaller;
import com.virtusa.api.serviceCaller.RESTServiceCaller;
import com.virtusa.api.serviceCaller.ServiceRequestProperties;
import com.virtusa.api.serviceCallerFactory.ServiceCallerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	final static Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	
		
    /*  
     ServiceRequestProperties serviceRequestProp = new ServiceRequestProperties();
     Map<String,String> requestProperties = new HashMap<String,String>();
     requestProperties.put("Authorization", "Bearer 5qmtPksX3fh5XB8p9Vwj7ag7NHoa");
     requestProperties.put("Accept", "application/json");
     serviceRequestProp.setRequestMethod("GET");
     serviceRequestProp.setRequestProperties(requestProperties);
     ServicePropertyLoader servicePropertyLoader = ServicePropertyLoader.getInstanse();
     try {
		serviceRequestProp.setUrl(new URL(servicePropertyLoader.getUrl()));
	} catch (MalformedURLException e) {
		
	}
     ServiceCaller restServiceCaller = ServiceCallerFactory.createServiceCaller("rest",serviceRequestProp);
     try {
		System.out.println("status code "+ restServiceCaller.getResponceCode());
		System.out.println("respponse" + restServiceCaller.getHttpResponse());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
    	RequestFileLoader rfl = new RequestFileLoader();
    	Map<String,String> propertyFiles=rfl.getAllPropertyFiles("C:/Users/camarathunga/Desktop/temp/apiautomation");
    	for (Object obj : propertyFiles.keySet()) {
			System.out.println("a: "+ propertyFiles.get((String)obj));
			ReadPropertyFile rpf = new ReadPropertyFile();
			Map<String,String> propertyValues = rpf.getAllPropertyValues(propertyFiles.get((String)obj));
			if(propertyValues==null || propertyValues.size()==0){
				continue;
			}
			for (Object keyObj : propertyValues.keySet()) {
				System.out.println("b: "+(String)keyObj+" "+propertyValues.get((String)keyObj) );
			}
			
		}
    }
    
}
