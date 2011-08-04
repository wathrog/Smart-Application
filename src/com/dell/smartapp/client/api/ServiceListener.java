package com.dell.smartapp.client.api;

public interface ServiceListener {
	
	public void addNewService(String host);
	public void removeService(String host);
	public void setServiceList(String[] services);

}
