package com.zoho.training.stringbuilder.task;
import com.zoho.training.exceptions.TaskException;
import com.zoho.training.utility.Util;

public class StringBuilderTask
{
	public StringBuilder getStringBuilder() 
	{
		return new StringBuilder();
	}
	public StringBuilder appendString(StringBuilder stringBuilder , String inputString) throws TaskException
	{
		Util.validateInput(stringBuilder,"StringBuilder");
		return stringBuilder.append(inputString);
	}
	public StringBuilder appendStringsWithDelimiter(StringBuilder stringBuilder,String[] stringArray ,String delimiter ) throws TaskException
	{
		Util.validateInput(stringArray,"String Array");
		Util.validateInput(delimiter,"delimiter");
		for(int i=0;i<stringArray.length; i++)
		{
			appendString(stringBuilder,stringArray[i]);
			if(i!=stringArray.length-1)
			{
				appendString(stringBuilder,delimiter);
			}	
		}
		return stringBuilder;
		
	}
	public StringBuilder insertStringAfterDelimiter(StringBuilder stringBuilder , String inputString,String delimiter) throws TaskException
	{
		Util.validateInput(inputString,"input string");
		stringBuilder.insert(findIndex(stringBuilder , delimiter)+1,inputString);
		return stringBuilder;
	}
	public StringBuilder deleteString(StringBuilder stringBuilder,String delimiter) throws TaskException
	{
		return stringBuilder.delete(0,findIndex(stringBuilder , delimiter));
	} 
	// public StringBuilder replaceDelimiter(StringBuilder stringBuilder,String delimiter , char replacingDelimiter)throws TaskException
	// {
	// 	Util.validateInput(delimiter,"delimiter");
    	//      Util.validateInput(replacingDelimiter,"Replacing delimiter");
        //      int length =  findLength(stringBuilder);
	// 	for (int i = 0; i < length; i++) 
	// 	{
        //      if (stringBuilder.charAt(i) == delimiter) 
	// 	{
        //             		stringBuilder.setCharAt(i, replacingDelimiter);
        //      }
        //      }
	// 	return stringBuilder;
	// }
	public StringBuilder replaceDelimiter(StringBuilder stringBuilder, String delimiter, String replacingDelimiter) throws TaskException 
	{
    
    		Util.validateInput(replacingDelimiter, "Replacing delimiter");
    
    		int index = findIndex(stringBuilder, delimiter); 
        	while (index != -1) 
		{
        		stringBuilder.replace(index, index + Util.findLength(delimiter), replacingDelimiter);
        		index = findIndex(stringBuilder, delimiter); 
    		}
		return stringBuilder;
	}


	public StringBuilder reverseStringBuilder(StringBuilder stringBuilder)throws TaskException
	{
		Util.validateInput(stringBuilder,"StringBuilder");
		return stringBuilder.reverse();
	}
	public int findIndex(StringBuilder stringBuilder , String delimiter )throws TaskException
	{
		Util.validateInput(stringBuilder,"StringBuilder");
		Util.validateInput(stringBuilder,"delimiter");
		return stringBuilder.indexOf(delimiter);
	}
	public int findLastIndex(StringBuilder stringBuilder , String substring)throws TaskException
	{
		Util.validateInput(stringBuilder,"StringBuilder");
		Util.validateInput(substring,"substring");
		return stringBuilder.lastIndexOf(substring);
	}
	public StringBuilder deleteSubstring(StringBuilder stringBuilder ,int startIndex , int endIndex)throws TaskException
	{
		 Util.validateInput(stringBuilder,"StringBuilder");
		 return stringBuilder.delete(startIndex,endIndex);
	}
	public StringBuilder replaceSubstring(StringBuilder stringBuilder , int startIndex , int endIndex , String substitute )throws TaskException
	{
		Util.validateInput(stringBuilder,"StringBuilder");
		Util.validateInput(substitute,"substitute");
		return stringBuilder.replace(startIndex, endIndex , substitute);
	}
	
	
}