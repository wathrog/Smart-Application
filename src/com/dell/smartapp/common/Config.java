package com.dell.smartapp.common;

import javax.jmdns.ServiceInfo;

public class Config {
	
	public static String SERVICE_NAME = "SmartAppServer";
	public static String SERVICE_TYPE = "_smart._tcp.local.";
	public static int SERVICE_PORT = 6667;
	
	public static ServiceInfo SERVICE_INFO = ServiceInfo.create(SERVICE_TYPE, SERVICE_NAME, SERVICE_PORT, "Smart app service");

}
