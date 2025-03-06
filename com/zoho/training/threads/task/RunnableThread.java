package com.zoho.training.threads.task;

import java.io.IOException;
import java.util.logging.Logger;

import com.zoho.training.threads.runner.ThreadRunner;
import com.zoho.training.utility.Util;

public class RunnableThread implements Runnable {

	private static final Logger logger;

	static {
		try {
			logger = Util.getLogger(ThreadRunner.class);
		} catch (IOException e) {
			throw new RuntimeException("Failed to initialize logger", e);
		}
	}
	private int sleepTime;
	private volatile boolean running = true;

	public RunnableThread(String name) {
		Thread.currentThread().setName(name);
	}

	public RunnableThread() {

	}

	public void setSleepTime(int time) {

		this.sleepTime = time;
	}

	public void stopThread() {
		running = false;
	}

	@Override
	public void run() {
	    logger.info("Thread Name: " +Thread.currentThread().getName());
	    logger.info("Thread Priority: " +Thread.currentThread().getPriority());
	    logger.info("Thread State: " + Thread.currentThread().getName());
		while (running) {
			try {
				logger.info("Going to Sleep" + Thread.currentThread().getName());
				Thread.sleep(sleepTime);
				logger.info("After Sleeping" + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
