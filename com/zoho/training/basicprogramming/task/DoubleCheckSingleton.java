package com.zoho.training.basicprogramming.task;

public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton oneInstance;
    private static final String string ="Double Check";
    private DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        if (oneInstance == null) {
	        	synchronized(DoubleCheckSingleton.class)
	        	{
	        		if (oneInstance == null) {
	        		 oneInstance = new DoubleCheckSingleton();
	            }
        	}
        }
           
        return oneInstance;
    }
    @Override
    public String toString()
    {
		return string;
    }
}