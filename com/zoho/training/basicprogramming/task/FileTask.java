package com.zoho.training.basicprogramming.task;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.zoho.training.exceptions.TaskException;
import com.zoho.training.utility.Util;

public class FileTask
{

	public File createFile(String path,String name) throws TaskException,IOException
	{
			Util.validateInput(path,"Path");
			Util.validateInput(name,"Name");
			File file = new File(path);
			file.mkdirs();	
			file = new File(path,name);
			file.createNewFile();
			return file;
	}
	public void writeFile(String[] stringArray,File file)  throws IOException,TaskException
	{
		try(Writer writer = new BufferedWriter(new FileWriter(file)))
		{
			Util.validateInput(file,"File");
			Util.validateInput(stringArray,"String Array");
			
			for(String string : stringArray)
			{
				writer.write(string);
				writer.write("\n");
			}
			writer.flush(); 
		}
		
	}
	public boolean checkExistence(File file) throws TaskException
	{
		Util.validateInput(file,"File");
		return file.exists();
	}

}
