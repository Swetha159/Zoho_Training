package com.zoho.training.threads.task;

public class ExtendedThread extends Thread {

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
	public void run()
	{
		System.out.println(this.getName());
		System.out.println(this.getPriority());
		System.out.println(this.getState());
		while (running) {
		try {
			System.out.println("Going to Sleep"+this.getName());
			Thread.sleep(sleepTime);
			System.out.println("After Sleeping"+this.getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}
		
		System.out.println(this.getName() + " has stopped.");

	
	}
}
