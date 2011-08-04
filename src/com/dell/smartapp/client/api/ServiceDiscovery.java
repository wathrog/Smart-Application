package com.dell.smartapp.client.api;

import java.util.Vector;

public interface ServiceDiscovery {
	
	public void subscribeToSD(ServiceListener callback);
	public void unSubscribeFromSD(ServiceListener callback);
	public Vector<String> getHostList();

}
