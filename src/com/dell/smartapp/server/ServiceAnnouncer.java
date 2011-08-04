package com.dell.smartapp.server;

import java.io.IOException;

import javax.jmdns.JmDNS;

import com.dell.smartapp.common.Config;

public class ServiceAnnouncer {
	
	private JmDNS jmdns;
	
	public ServiceAnnouncer() {
		// TODO Auto-generated constructor stub
	}
	
	public void setJmDNS(JmDNS jmdns) {
		this.jmdns = jmdns;
	}
	
	public void start() {
		try {
			jmdns.registerService(Config.SERVICE_INFO);
		} catch (IOException e) {
			System.err.println("UNABLE TO REGISTER THE SERVICE, KILLING MYSELF");
			System.exit(1);
		}
	}
	
	public void stop() {
		jmdns.unregisterAllServices();
	}

}
