package com.dell.smartapp.server;

import java.io.IOException;

import javax.jmdns.JmDNS;

import com.dell.smartapp.common.Component;
import com.dell.smartapp.common.Config;

public class ServiceAnnouncer implements Component {
	
	private JmDNS jmdns;
	
	public ServiceAnnouncer() {
		// TODO Auto-generated constructor stub
	}
	
	public void setJmDNS(JmDNS jmdns) {
		this.jmdns = jmdns;
	}
	
	@Override
	public synchronized void start() {
		try {
			jmdns.registerService(Config.SERVICE_INFO);
		} catch (IOException e) {
			System.err.println("UNABLE TO REGISTER THE SERVICE, KILLING MYSELF");
			System.exit(1);
		}
	}
	
	@Override
	public synchronized void stop() {
		jmdns.unregisterAllServices();
	}

}
