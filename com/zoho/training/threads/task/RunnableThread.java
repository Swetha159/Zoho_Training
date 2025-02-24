package com.zoho.training.threads.task;

public class RunnableThread implements Runnable{

	private int sleepTime;
	
	public RunnableThread(String name)
	{
		Thread.currentThread().setName(name);
	}
	public  RunnableThread()
	{
	
	}
	

	public void stopThread() {
		running = false;
	}
	@Override
	public void run()
	{
		 System.out.println(Thread.currentThread().getName());
	        System.out.println(Thread.currentThread().getPriority());
	        System.out.println(Thread.currentThread().getState());
	        
	        try {
				System.out.println("Going to Sleep"+Thread.currentThread().getName());
				Thread.sleep(sleepTime);
				System.out.println("After Sleeping"+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	public void setSleepTime(int time) {
		
		this.sleepTime=time;
	}
}
