package com.dell.smartapp.client;

import java.io.IOException;
import java.util.UUID;
import java.util.Vector;

import javax.jmdns.JmDNS;

import com.dell.smartapp.client.impl.ServiceDiscoveryJmDNSImpl;

public class Client {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		UUID clientId = UUID.randomUUID();
		
		System.out.println("Starting client id " + clientId + "...");
		
		JmDNS jmdns = JmDNS.create();
		
		ServiceDiscoveryJmDNSImpl disc = new ServiceDiscoveryJmDNSImpl();
		disc.setJmDNS(jmdns);
		
		Vector<String> hosts = disc.getHostList();
		
		System.out.println("Discovered " + hosts.size() + " hosts");
		
		for (String host : hosts) {
			Sender s = new Sender();
			s.setDestinationHost(host);
			s.setName(clientId.toString());
			s.communicate();
			
		}
		
		jmdns.close();

	}
	
}
