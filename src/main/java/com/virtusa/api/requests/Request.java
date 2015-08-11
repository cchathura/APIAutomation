package com.virtusa.api.requests;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.virtusa.api.serviceCaller.ServiceRequestProperties;

public class Request {

	private String url;
	private int requestNumber;
	private String requestMethod;
	private String body;
	private RequestComponents requestComponents;
	private ServiceRequestProperties serviceRequestProp;
	
	
	
	public RequestComponents getRequestComponents() {
		return requestComponents;
	}

	public void setRequestComponents(RequestComponents requestComponents) {
		this.requestComponents = requestComponents;
	}

	public ServiceRequestProperties getServiceRequestProp() {
		return serviceRequestProp;
	}

	public void setServiceRequestProp(ServiceRequestProperties serviceRequestProp) {
		this.serviceRequestProp = serviceRequestProp;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	public int getRequestnumber() {
		return requestNumber;
	}

	public void setRequestnumber(int requestnumber) {
		this.requestNumber = requestnumber;
	}
	
	 public int hashCode() {
	        return requestNumber;
	    }
	 
	 public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Request other = (Request) obj;
	        if (requestNumber != other.getRequestnumber())
	            return false;
	        return true;
	    }
		
	 public String toString() //what is  this function doing
     {
		 JSONObject obj=new JSONObject();
     obj.put("RequestComponents",this.getRequestComponents());
     obj.put("requestNumber",this.getRequestnumber());
    // obj.put("requestMethod",this.requestComponents.requestMethod);
     
        return JSONValue.toJSONString(obj).toString();
     } 
}
