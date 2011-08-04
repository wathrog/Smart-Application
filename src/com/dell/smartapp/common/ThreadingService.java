package com.dell.smartapp.common;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadingService {
	
	private static ThreadingService _instance = null;
	
	private ScheduledExecutorService mainPool;
	
	private ThreadingService() {
		mainPool = Executors.newScheduledThreadPool(5);
	}
	
	public void executeTaskOnMainThreadPool(Runnable task) {
		mainPool.execute(task);
	}
	
	public static ThreadingService getInstance() {
		if (_instance == null) {
			_instance = new ThreadingService();
		}
		return _instance;
	}

}
