package com.virtusa.api.APIAutomation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.virtusa.api.requestLoader.RequestFileLoader;
import com.virtusa.api.requestmanager.RequestManager;
import com.virtusa.api.requests.Request;
import com.virtusa.api.requests.Respond;

/**
 * Hello world!
 *
 */
public class App 
{
	final static Logger logger = Logger.getLogger(App.class);
    /**
     * @param args
     */
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
    	/*RequestFileLoader rfl = new RequestFileLoader();
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
    	
    	ConfigurationFactory factory = new ConfigurationFactory("config.xml");
    	 		try {
    	 			Configuration config = factory.getConfiguration();
    	 			Iterator<String> keys = config.getKeys();
    	 	    	List<String> keyList = new ArrayList<String>();
    	 	    	    while(keys.hasNext()){
    	 	    	    	String keyName=keys.next();
    	 	    	    	if(keyName.contains("requestProperties")){
    	 	    	    keyList.add(keyName);
    	 	    	    	}
    	 	    	}
    	 	    	    System.out.println("chathura testing======");
    	 	    	    
    	 	    	    System.out.println(keyList);
    	 	    	    for (String kName : keyList) {
							System.out.println(config.getString(kName)); 
						}
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	PropertyReader propReader = new PropertyReader();
    	
    	try {
    		request=propReader.createRequestObj("propertyFile.properties");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	/*Request request = new Request();
    	System.out.println("start");
    	RequestManager requestManager = new RequestManager();
    	request =  requestManager.createRequest("propertyFile.properties");
    	requestManager.send(request);
    	request =  requestManager.createRequest("propertyFile2.properties");
       	//requestManager.send(request);
       	request =  requestManager.createRequest("propertyFile3.properties");
    	//requestManager.send(request);
    	System.out.println("finish");*/
    	Map<String,String> files = new HashMap<String,String>();
    	RequestFileLoader requestFileLoader = new RequestFileLoader();
    	files=requestFileLoader.getAllPropertyFiles("C:\\Users\\camarathunga\\Desktop\\a");
    	RequestManager requestManager = new RequestManager();
    	Map<Request, Respond> results = new HashMap<Request, Respond>();
    	results=requestManager.send(files);
    	for (Entry<Request, Respond> result : results.entrySet()) {
			System.out.println(result.getValue());
		}
    	
    	
    }
    
}
