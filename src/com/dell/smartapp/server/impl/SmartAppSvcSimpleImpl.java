package com.dell.smartapp.server.impl;

import com.dell.smartapp.server.api.SmartAppSvc;

public class SmartAppSvcSimpleImpl implements SmartAppSvc {

	@Override
	public void helloWorld(String clientName) {
		System.out.println("Client " + clientName + " is requesting me to print HELLO WORLD!");

	}

}
