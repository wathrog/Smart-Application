package com.dell.smartapp.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.dell.smartapp.common.Config;

public class Sender {
	
	private String host;
	private String name;
	
	public Sender() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDestinationHost(String host) {
		this.host = host;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void communicate() throws UnknownHostException, IOException {
		Socket s = new Socket(host, Config.SERVICE_PORT);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		out.write(this.name + "\n");
		out.flush();
		if (in.readLine().equalsIgnoreCase("OK")) {
			System.out.println("Communication to server has succeeded");
		}
	}

}
