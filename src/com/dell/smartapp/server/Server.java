package com.dell.smartapp.server;

import java.io.IOException;

import javax.jmdns.JmDNS;

import com.dell.smartapp.server.impl.SmartAppSvcSimpleImpl;

public class Server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Starting main server...");
		
		Listener listener = new Listener();
		
		listener.setService(new SmartAppSvcSimpleImpl());
		listener.start();
		
		ServiceAnnouncer announce = new ServiceAnnouncer();
		
		announce.setJmDNS(JmDNS.create());
		announce.start();
		
		System.in.read();
		
		announce.stop();
		listener.stop();

	}

}
