package com.zoho.training.threads.task;

public class ClassA extends Thread{

	static ThreadLocal<String> pass = ThreadLocal.withInitial(() -> "I am at ClassA");
  String name ;  
  

	public ClassA(String name) {
		this.name = name;
	}

	@Override
	public void run()
	{
		pass.set(name);
		
		
    new ClassB().methodB();
	    	
	}

	public static String getValue() {
		
		return pass.get();
	}
	
}