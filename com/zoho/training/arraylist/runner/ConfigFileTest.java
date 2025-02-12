package com.zoho.training.arraylist.runner;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import com.zoho.training.exceptions.TaskException;
import com.zoho.training.property.PropertiesHelper;


public class ConfigFileTest {
	public static void main(String args[]) throws TaskException,IOException
	
	{
		File file = new File("config.text");
		PropertiesHelper handler = new PropertiesHelper();
		Properties property = handler.getProperty();
		handler.addProperty(property,"list", "java.util.ArrayList");
		handler.storePropertyInFile(property,"ARRAYLIST",file);
		Properties configProperty = handler.getProperty();
		handler.loadProperty(configProperty, file);
    	String className = configProperty.getProperty("list");
       System.out.println(className);
	}
}
