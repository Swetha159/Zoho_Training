package com.zoho.training.basicprogramming.task;

import java.io.Serializable;

public class BillPughSingleton implements Serializable,Cloneable
{
 
	private static final long serialVersionUID = 1826229122101129199L;
	private static final String string ="Billpugh";
    private BillPughSingleton() {
        if (SingletonHelper.INSTANCE != null) {
            throw new IllegalStateException("Singleton instance already created");
        }
    }

   
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    @Override
    public String toString()
    {
		return string;
    }
    
    private Object readResolve()
    {
    	return SingletonHelper.INSTANCE;
    }
    @Override
    public Object clone()
        throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
    
}

