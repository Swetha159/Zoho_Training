package com.zoho.training.singletontest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.zoho.training.basicprogramming.task.BillPughSingleton;

public class ReflectionTest {
    public static void main(String[] args) {
        try {
           
            Constructor<BillPughSingleton> constructor = BillPughSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true); 
            
          
            BillPughSingleton newInstance;
		
				newInstance = constructor.newInstance();
				System.out.println(newInstance);
			} 
        	catch (IllegalStateException|InstantiationException | IllegalAccessException | IllegalArgumentException
					|NoSuchMethodException| SecurityException | InvocationTargetException e) 
            {
				System.out.println("Error Occured");
			}
            
        
    }
}

