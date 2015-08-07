package com.virtusa.api.requestmanager;

import com.virtusa.api.requests.Request;
import com.virtusa.api.requests.Respond;

public interface RequestObserver {

	public void update(Request request, Respond respond);
	
}
