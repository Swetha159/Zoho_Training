package com.zoho.training.threads.task;

import java.io.IOException;
import java.util.logging.Logger;

import com.zoho.training.threads.runner.ThreadRunner;
import com.zoho.training.utility.Util;

public class ExtendedThread extends Thread {

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

	public void setSleepTime(int time) {
		this.sleepTime = time;
	}

	public ExtendedThread(String name) {
		this.setName(name);
	}

	public ExtendedThread() {

	}

	public void stopThread() {
		running = false;
	}

	@Override
	public void run() {
	    logger.info("Thread Name: " + this.getName());
	    logger.info("Thread Priority: " + this.getPriority());
	    logger.info("Thread State: " + this.getState());
		while (running) {
			try {
				logger.info("Going to Sleep " + this.getName());
				Thread.sleep(sleepTime);
				logger.info("After Sleeping " + this.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
