package com.dell.smartapp.client.impl;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Vector;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.dell.smartapp.client.api.ServiceDiscovery;
import com.dell.smartapp.client.api.ServiceListener;
import com.dell.smartapp.common.Component;
import com.dell.smartapp.common.Config;

public class ServiceDiscoveryJmDNSImpl implements Component, ServiceDiscovery {
	
	private JmDNS jmdns;
	
	public ServiceDiscoveryJmDNSImpl() {
		//TODO
	}
	
	public void setJmDNS(JmDNS jmdns) {
		this.jmdns = jmdns;
	}
	
	@Override
	public synchronized void start() {
		// TODO
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeToSD(ServiceListener callback) {
		// TODO
		
	}

	@Override
	public void unSubscribeFromSD(ServiceListener callback) {
		// TODO
	}

	@Override
	public Vector<String> getHostList() {
		Vector<String> result = new Vector<String>();
		
		ServiceInfo[] services = jmdns.list(Config.SERVICE_TYPE);
		
		for (ServiceInfo service : services) {
			for (InetAddress host : service.getInetAddresses()) {
				result.add(host.getHostAddress());
			}
		}
		
		return result;
	}


}
