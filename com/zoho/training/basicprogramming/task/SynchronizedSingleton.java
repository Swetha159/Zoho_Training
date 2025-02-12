package com.zoho.training.basicprogramming.task;

public class SynchronizedSingleton {


	private static volatile SynchronizedSingleton INSTANCE ;
	private SynchronizedSingleton()
	{
		
	}
	public static synchronized SynchronizedSingleton getInstance()
	{
		if(INSTANCE== null)
		{
			INSTANCE = new SynchronizedSingleton();
		}
		return INSTANCE;
	}
}
