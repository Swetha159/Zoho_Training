package com.zoho.training.utility;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zoho.training.exceptions.TaskException;

public class Util
{
	public static Logger getLogger(Class<?> className)  throws IOException{
        Logger logger = Logger.getLogger(className.getName());

        
            FileHandler infoHandler = new FileHandler(className.getSimpleName() + "_info.log", true);
            FileHandler severeHandler = new FileHandler(className.getSimpleName() + "_error.log", true);

            severeHandler.setFilter(record -> record.getLevel() == Level.SEVERE);
            infoHandler.setFilter(record -> record.getLevel() == Level.INFO);


            logger.setLevel(Level.ALL);
            logger.addHandler(infoHandler);
            logger.addHandler(severeHandler);
            logger.setUseParentHandlers(false);
       

        return logger;
    }
	public static void validateInput(Object input ,String inputName) throws TaskException
	{
		if(input==null)
		{
			throw new TaskException(inputName +" is empty ");
		}
	}
	public static void checkBoundary(int inputValue , int boundaryValue) throws TaskException
	{
		validateInput(inputValue , "Input Value");
		validateInput(boundaryValue , "Boundary Value");
		if(0>=inputValue || inputValue>boundaryValue)
		{
			throw new TaskException("The input value is out of range");
		}
	} 
	
	public static int findLength(Object input) throws TaskException 
	{
    		validateInput(input, "string or stringBuilder");
    
    		if (input instanceof String) 
		{
       			return ((String) input).length();
   		} 
		else if (input instanceof StringBuilder) 
		{
        		return ((StringBuilder) input).length();
    	} 
		else if(input instanceof List)
		{
			return ((List)input).size();
		}
		else if(input instanceof Map)
		{
			return ((Map)input).size();
		}
		else 
		{
       		throw new TaskException("Unsupported input type ");
   		}
	}


}

