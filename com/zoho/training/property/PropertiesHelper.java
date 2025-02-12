package com.zoho.training.property;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.Reader;

import com.zoho.training.exceptions.TaskException;
import com.zoho.training.utility.Util;


public class PropertiesHelper
{
	public Properties getProperty()
	{
		return new Properties();
	}
	public void addProperty(Properties property,String key , String value) throws TaskException
	{
		Util.validateInput(property,"Property");
		Util.validateInput(key, "Key");
		Util.validateInput(value, "Value");
		property.setProperty(key,value);
	}
	public void storePropertyInFile(Properties property , String comment,File file) throws IOException,TaskException
	{
		try(Writer writer = new BufferedWriter(new FileWriter(file)))
		{
			Util.validateInput(comment,"Comment");
			Util.validateInput(property,"Property");
			Util.validateInput(file,"File");	
			property.store(writer,comment);
			writer.flush();
		}
	}
	public void loadProperty(Properties property ,File file) throws IOException,TaskException
	{
		try(Reader reader =new BufferedReader(new FileReader(file)))
		{
			Util.validateInput(property,"Property");
			Util.validateInput(file,"File");
			property.load(reader);
		}
	}
	
} 
