package com.dell.smartapp.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.dell.smartapp.common.Component;
import com.dell.smartapp.common.Config;
import com.dell.smartapp.common.ThreadingService;
import com.dell.smartapp.server.api.SmartAppSvc;

public class Listener implements Component {
	
	private Thread server = null;
	
	private SmartAppSvc service;
	
	public Listener() {
	}
	
	public void setService(SmartAppSvc service) {
		this.service = service;
	}
	
	@Override
	public synchronized void start() {
		if (server == null) {
			server = new Thread(new Runnable() {
				
				@Override
				public void run() {
					ServerSocket serv = null;
					try {
						serv = new ServerSocket(Config.SERVICE_PORT);
						
						while (true) {
							Socket s = serv.accept();
							ThreadingService.getInstance().executeTaskOnMainThreadPool(new ConnectionServeTask(s, service));
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							serv.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			});
			
			server.start();
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public synchronized void stop() {
		server.interrupt();
		try {
			server.join(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			server.destroy();
			server = null;
		}
	}

}

class ConnectionServeTask implements Runnable {
	
	private Socket s;
	private SmartAppSvc svc;
	
	public ConnectionServeTask(Socket s, SmartAppSvc svc) {
		this.s = s;
		this.svc = svc;
		
	}

	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			
			String clientName = in.readLine();
			
			svc.helloWorld(clientName);
			
			out.write("OK\n");
			out.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}