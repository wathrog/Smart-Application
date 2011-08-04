package com.dell.smartapp.common;

import javax.jmdns.ServiceInfo;

public class Config {
	
	public static String SERVICE_NAME = "SmartApp.Server";
	public static int SERVICE_PORT = 6667;
	
	public static ServiceInfo SERVICE_INFO = ServiceInfo.create("_socket._tcp.local.", SERVICE_NAME, SERVICE_PORT, "Smart app service");

}
