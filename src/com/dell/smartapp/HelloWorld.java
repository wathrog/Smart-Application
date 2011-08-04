package com.dell.smartapp;

import java.io.IOException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.dell.smartapp.common.Config;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JmDNS jmdns = null;
		try {
			jmdns = JmDNS.create();
			ServiceInfo[] services = jmdns.list(Config.SERVICE_TYPE);
			System.out.println("Discovered " + services.length + " services");
			for(ServiceInfo service : services) {
				int i = 1;
				System.out.println("Service '" + service.getNiceTextString() + "': ");
				for (String URL : service.getURLs()) {
					System.out.println("URL " + i++ + " -- " + URL);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				jmdns.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
