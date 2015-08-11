package com.virtusa.api.requests;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Respond {
private String respond;
private int statusCode;
/**
 * @return
 */
public String getRespond() {
	return respond;
}
/**
 * @param respond
 */
public void setRespond(String respond) {
	this.respond = respond;
}
/**
 * @return
 */
public int getStatusCode() {
	return statusCode;
}
/**
 * @param statusCode
 */
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}

public String toString(){
	 JSONObject obj=new JSONObject();
     obj.put("Respond",this.getRespond());
     obj.put("StatusCode",this.getStatusCode());
    // obj.put("requestMethod",this.requestComponents.requestMethod);
     
        return JSONValue.toJSONString(obj).toString();
}

}
