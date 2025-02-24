package com.zoho.training.string.runner;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zoho.training.exceptions.TaskException;
import com.zoho.training.hashmap.runner.HashMapRunner;
import com.zoho.training.string.task.StringTask;
import com.zoho.training.utility.Util;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
public class StringRunner
{
	private static final Logger logger = Logger.getLogger(StringRunner.class.getName());
	public  static void function() throws TaskException  {
	//Scanner scan = new Scanner(System.in);
	try{
		Scanner scan = new Scanner(System.in);
		StringTask task = new StringTask();
		String delimiterToConcatenate;
						
		System.out.print("Enter number of strings :");
		int numberOfStrings = scan.nextInt();
		//String[] stringArray = new String[numberOfStrings] ;
		String[] stringArray =null;
		//for(int i =0;i<numberOfStrings;i++)
		//{
		//	System.out.println("Enter String "+i+":");
		//	stringArray[i] = scan.next();
		//}
		System.out.println("Enter the delimiter for merging(for space as delimiter ,enter yes:" );
		delimiterToConcatenate = scan.next();
		if(delimiterToConcatenate.equals("yes"))
		{
			delimiterToConcatenate=" ";
		}
		System.out.println("The Merged String with \'"+delimiterToConcatenate+"\' is"+task.mergeWithDelimiter(stringArray ,delimiterToConcatenate));
	}
	catch (TaskException ex) {
                throw new TaskException("An error occurred while processing the task.", ex);
        }
	}


	public static void main(String args[])
	{
	   StringTask task = new StringTask();
	 Scanner scan = new Scanner(System.in);
	   String inputString,delimiterToSplit,delimiterToConcatenate,suffix,prefix,string1,string2;
	   int numberOfCharacters,choice=0;
	   char character;
	   while(choice!=21)
	   {
		
		System.out.print("++++++++++++++++++++++++++++++++\n"+"Choose the Operation :\n"+
				 "1.Find the length \n"+ 
				 "2. convert to char array \n"+
				 "3.Find Character using position from last\n"+
				 "4.Find Number Of Occurences \n"+
				 "5.Find greatest position \n"+
				 "6.Print Suffix\n"+
				 "7.print prefix \n"+
				 "8.Replace prefix \n"+
				 "9.Check starts with \n"+
 				 "10.Check ends with \n"+
				 "11.Convert to lowercase\n"+
				 "12.Convert to uppercase\n"+
				 "13.Reverse the string\n"+
				 "14.Process a line with multiple strings \n"+					 
				 "15.Concatenate multiple strings in a line \n"+ 					
				 "16.Enclose each string in array \n"+						 
				 "17.Merge strings \n"+							
				 "18.Check String Equality(case-sensitive)\n"+ 					
				 "19.Check String Equality(case-insensitive)\n"+				
			       	 "20.Accept String with no leading/trailing space \n"+				
				 "21.Exit \n"+
				 "Enter the choice :");
		try
	        {
			 //Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();
			FileHandler infoHandler = new FileHandler("info.log", true);
	        FileHandler severeHandler = new FileHandler("error.log", true);
	        FileHandler fineHandler = new FileHandler("fine.log", true);
	       
	        severeHandler.setFilter(record -> record.getLevel() == Level.SEVERE);

	        fineHandler.setFilter(record -> record.getLevel() == Level.FINE);
	        
	        infoHandler.setFilter(record -> record.getLevel() == Level.INFO);
	        logger.setLevel(Level.FINE);
	        logger.addHandler(infoHandler);
	        logger.addHandler(severeHandler);
	        logger.addHandler(fineHandler);
			logger.setUseParentHandlers(false);
			switch(choice)
			{
				case 1:
					int stringLength = Util.findLength(args[0]);
					logger.info("The length of the string \""+args[0]+"\" is " + stringLength);
					break;
		
				case 2 :// Char Array Conversion
					System.out.print("Enter a String to convert into char Array :");
					inputString = scan.next();
					char[] charArray = task.convertToCharArray(inputString);
					logger.info(Arrays.toString(charArray));
					break;
		
				case 3 : //penultimate
					System.out.print("Enter a String :");
					inputString = scan.next();
					System.out.print("Enter the position value form last  :");
					int positionFromLast = scan.nextInt();
					logger.info("The Character is " + task.findPositionValue(inputString,positionFromLast)); 
					break;
				case 4: // number of occurences
					System.out.print("Enter a String :");
					inputString = scan.next();
					System.out.print("Enter a character (to find the number of occurences):");
					character = scan.next().charAt(0); 
					int count = task.findNumberOfOccurences(inputString ,  character );
					logger.info("There are "+count+ " occurences of the character \'"+character+"\' in the string \""+inputString+"\"");
					break;

				case 5 ://greatest position
					System.out.print("Enter a String :");
					inputString = scan.next();
					//inputString =null;
					System.out.print("Enter a character (to find the greatest position):");
					character = scan.next().charAt(0);
					int index = task.findGreatestPosition(inputString,character);
					if(index==-1)
					{
						logger.info("The character is not found in the string ");
					}
					else
					{
						logger.info("The Greatest Position of the character \'"+character+"\' in the string\""+inputString+ "\"is "+index);
					}	
					break;

				case 6://suffix
					System.out.print("Enter a String :");
					inputString = scan.next();
					System.out.print("Enter the number of characters  :");
					numberOfCharacters = scan.nextInt();
					System.out.println("The Suffix of the string \""+inputString+"\" is "+ task.findSuffix(inputString,numberOfCharacters)); 
					break;

				case 7://findprefix
					System.out.print("Enter a String :");
					inputString = scan.next();
					System.out.print("Enter the number of characters  :");
					numberOfCharacters = scan.nextInt();
					logger.fine("The Prefix of the string \""+inputString+"\" is "+ task.findPrefix(inputString,numberOfCharacters));
					break;

				case 8: //replace prefix
					System.out.print("Enter a String :");
					inputString = scan.next();
					System.out.println("Enter the number of characters to be replaced :");
					numberOfCharacters = scan.nextInt();
					System.out.print("Enter a Substitute String :");
					String substitute = scan.next();
					String replacedString = task.replacePrefix(inputString,numberOfCharacters,substitute);
					logger.info("After the replacement of the first " + numberOfCharacters + " characters with \""+substitute+"\" , the string will be "+replacedString); 
					break;

				case 9:  //startswith
					System.out.print("Enter a String :");
					inputString = scan.next();
					System.out.print("Enter a prefix :");
					prefix = scan.next();
					if(task.checkStartsWith(inputString,prefix))
					{
						logger.info("The String starts with \""+prefix+"\"");
					}
					else
					{
						logger.info("The String doesn't start with \""+prefix+"\"");
					} 
			  		break;
			
				case 10: //endswith
					System.out.print("Enter a String :");
					inputString = scan.next();
					System.out.print("Enter a suffix :");
					suffix = scan.next();
					if(task.checkEndsWith(inputString,suffix))
					{
						logger.info("The String ends with \""+suffix+"\"");
					}
					else
					{
						logger.info("The String doesn't end with \""+suffix+"\"");
					} 
					break;

				case 11 :  //lowercaseconversion
					System.out.print("Enter a String :");
					inputString = scan.next(); 
					inputString = task.convertLowerCase(inputString);
					logger.info("Converted to lowercase:" + inputString);
					break;
				case 12 : //uppercaseconversion
					System.out.print("Enter a String :");
					inputString = scan.next();
					inputString = task.convertUpperCase(inputString);
					logger.info("Converted to uppercase:" + inputString); 
					break;
			
				case 13: //reverse
					System.out.print("Enter a String :");
					inputString = scan.nextLine();
					inputString = task.reverseString(inputString);
					logger.info("Reversed String is:" + inputString); 
					break;
		
				case 14:  //multiplestrings
					System.out.print("Enter a String :");
					inputString = scan.nextLine();
					logger.info("A Line with multiple strings :"+inputString); 
					break;
	
				case 15: //concatenate
 					System.out.print("Enter a String :");
					inputString = scan.nextLine();
					System.out.println("Enter the delimiter to split(for space as delimiter ,enter yes:" );
					delimiterToSplit = scan.next();
					if(delimiterToSplit.equals("yes"))
					{
						delimiterToSplit=" ";
					}
					System.out.println("Enter the delimiter to concatenate(for no delimiter ,enter yes:" );
					delimiterToConcatenate = scan.nextLine();
					if(delimiterToConcatenate.equals("yes"))
					{
						delimiterToConcatenate="";
					}
					logger.info("Concatenated String :"+task.concatenateStrings(inputString,delimiterToSplit,delimiterToConcatenate)); 
					break;
			
				case 16:  //string array
					System.out.print("Enter a String :");
					inputString = scan.nextLine();
					System.out.println("Enter the delimiter for splitting(for space as delimiter ,enter yes:" );
					delimiterToSplit = scan.next();
					if(delimiterToSplit.equals("yes"))
					{
				 		delimiterToSplit=" ";
					}

					String[] strings = task.encloseInStringArray(inputString , delimiterToSplit);
					logger.info(Arrays.toString(strings));
					break;
			
				case 17:  //merge
					try {
            					function();
        				} catch (TaskException ex) {
            					//System.out.println(ex.getMessage());
						//System.out.println(ex.getCause());
                				ex.printStackTrace();
            				}
					break;

				case 18: //equal(casesensitive)
					System.out.print("Enter a String1 :");
					string1 = scan.next();
					System.out.print("Enter a String2 :");
					string2 = scan.next();
					if(task.checkEqualityCaseSensitive(string1,string2))
					{
						logger.info("The Strings are Equal");
					}
					else
					{
						logger.info("The Strings are not Equal");
					}
					break;
				case 19:  //equal(case-insensitive)
					System.out.print("Enter a String1 :");
					string1 = scan.next();
					System.out.print("Enter a String2 :");
					string2 = scan.next();
					if(task.checkEqualityCaseInSensitive(string1,string2))
					{
						logger.info("The Strings are Equal");
					}
					else
					{
						logger.info("The Strings are not Equal");
					} 
					break;
                		case 20: //leading and trailing space
					System.out.print("Enter String :");
					inputString = scan.nextLine();
					logger.info("The string with no leading and trailing space :"+task.removeLeadingAndTrailingSpace(inputString)+".");
					break;
				default:
					System.out.println("Enter Valid Choice\n");
				
			}
		}
		 catch (InputMismatchException e) 
		{
			 logger.severe("Invalid input. Please enter an integer.");
                	scan.nextLine(); 
        }
      	catch(TaskException | IOException |SecurityException e)
      	{
      		logger.severe(e.getMessage());
      	}
		finally
		{
			scan.close();
		}

		
	   }
	 

		
      }
}
