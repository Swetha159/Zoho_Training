package com.zoho.training.stringbuilder.runner;
import java.util.Scanner;

import com.zoho.training.exceptions.TaskException;
import com.zoho.training.stringbuilder.task.StringBuilderTask;
import com.zoho.training.utility.Util;

public class StringBuilderRunner
{
	public static void main(String args[]) 
	{
		Scanner scan = new Scanner(System.in);
		StringBuilderTask task = new StringBuilderTask();
		int choice=0;
		StringBuilder stringBuilder;
		String inputString ,substring,delimiter;
		String[] stringArray;
    		try
		{
			while(choice!=11)
			{
				System.out.println("Choose from the options below:\n1.Create StringBuilder with and without string \n2.Add strings in stringbuilder\n3.Insert string \n 4.delete first string \n5.Replace delimiter\n6.reverse the string\n7.delete substring with specified index\n8.replace substring with specified index\n9.find first index of substring\n10.find last index of substring\n11.Exit ");
				System.out.println("Enter your option :");
				choice = scan.nextInt();
					switch(choice)
					{
						case 1:
							stringBuilder = task.getStringBuilder();
							System.out.println("StringBuilder is created without string");
							printLengthAndString(stringBuilder);
							System.out.println("Enter the string to add:");
							scan.nextLine();
							inputString = scan.nextLine(); 
							task.appendString(stringBuilder,inputString);
							printLengthAndString(stringBuilder);
							break;
						case 2:
							stringBuilder = task.getStringBuilder() ;
							System.out.println("Enter the string to add:");
							scan.nextLine();
							inputString = scan.nextLine(); 
							task.appendString(stringBuilder,inputString);
							printLengthAndString(stringBuilder);
							System.out.print("Enter the no. of strings to append:");
							int count = scan.nextInt();
							scan.nextLine();
							System.out.print("Enter the delimiter to concatenate:");
							delimiter = scan.nextLine();
							for(int i=0;i<count;i++)
							{
								System.out.println("Enter the string to add:");
								inputString = scan.nextLine(); 
								task.appendString(stringBuilder,delimiter);
								task.appendString(stringBuilder,inputString);
							}
							printLengthAndString(stringBuilder);
							break;
							
						case 3 : 
							System.out.print("Enter the no. of strings to append:");
							count = scan.nextInt();
							scan.nextLine();
							System.out.print("Enter the delimiter to concatenate (for space as delimiter ,enter yes):");
							delimiter = scan.nextLine();
							if(delimiter.equals("yes"))
							{
									delimiter=" ";
							}
							stringArray = new String[count];
							for(int i=0;i<count;i++)
							{
								System.out.println("Enter the string to add:");
								stringArray[i] = scan.nextLine(); 
							}
							stringBuilder = task.getStringBuilder() ;
							task.appendStringsWithDelimiter(stringBuilder ,stringArray , delimiter);
							printLengthAndString(stringBuilder);
							System.out.print("Enter the string to be inserted:");
							inputString = scan.nextLine();
							task.insertStringAfterDelimiter(stringBuilder ,inputString+delimiter,delimiter);
							printLengthAndString(stringBuilder);
							break;
						
						case 4 :
							System.out.print("Enter the no. of strings to append:");
							count = scan.nextInt();
							scan.nextLine();
							System.out.print("Enter the delimiter to concatenate (for space as delimiter ,enter yes):");
							delimiter = scan.nextLine();
							if(delimiter.equals("yes"))
							{
									delimiter=" ";
							}
							stringArray = new String[count];
							for(int i=0;i<count;i++)
							{
								System.out.println("Enter the string to add:");
								stringArray[i] = scan.nextLine(); 
							} 
							stringBuilder = task.getStringBuilder() ;
							task.appendStringsWithDelimiter(stringBuilder ,stringArray , delimiter);
							printLengthAndString(stringBuilder);
							task.deleteString(stringBuilder,delimiter);
							printLengthAndString(stringBuilder);
							break;	

						case 5:
							System.out.print("Enter the no. of strings to append:");
							count = scan.nextInt();
							scan.nextLine();
							System.out.print("Enter the delimiter to concatenate (for space as delimiter ,enter yes):");
							delimiter = scan.nextLine();
							if(delimiter.equals("yes"))
							{
									delimiter=" ";
							}
							stringArray = new String[count];
							for(int i=0;i<count;i++)
							{
								System.out.println("Enter the string to add:");
								stringArray[i] = scan.nextLine(); 
							} 
							stringBuilder = task.getStringBuilder() ;
							task.appendStringsWithDelimiter(stringBuilder ,stringArray , delimiter);
							printLengthAndString(stringBuilder);
							System.out.println("Enter the delimiter to replace:");
							//char replacingDelimiter = scan.next().charAt(0);
							String replacingDelimiter = scan.nextLine();
							task.replaceDelimiter(stringBuilder,delimiter,replacingDelimiter);
							printLengthAndString(stringBuilder);
								break;

						
						case 6:
							System.out.print("Enter the no. of strings to append:");
							count = scan.nextInt();
							scan.nextLine();
							System.out.print("Enter the delimiter to concatenate (for space as delimiter ,enter yes):");
							delimiter = scan.nextLine();
							if(delimiter.equals("yes"))
							{
									delimiter=" ";
							}
							stringArray = new String[count];
							for(int i=0;i<count;i++)
							{
								System.out.println("Enter the string to add:");
								stringArray[i] = scan.nextLine(); 
							} 
							stringBuilder = task.getStringBuilder() ;
							task.appendStringsWithDelimiter(stringBuilder ,stringArray , delimiter);
							printLengthAndString(stringBuilder);
							task.reverseStringBuilder(stringBuilder);
							printLengthAndString(stringBuilder);
								break;

						case 7 :
							scan.nextLine(); 
							System.out.println("Enter the StringBuilder: ");
							inputString = scan.nextLine();
							stringBuilder = task.getStringBuilder();
							task.appendString(stringBuilder,inputString);
							printLengthAndString(stringBuilder);
							System.out.println("Enter the starting index of the substring to delete ");
							int startIndex = scan.nextInt();
							System.out.println("Enter the ending index of the substring to delete ");
							int endIndex = scan.nextInt();
							task.deleteSubstring(stringBuilder, startIndex, endIndex);
							printLengthAndString(stringBuilder);
							break;

						case 8 :
							scan.nextLine();
							System.out.println("Enter the StringBuilder: ");
							inputString = scan.nextLine();
							stringBuilder = task.getStringBuilder();
							task.appendString(stringBuilder,inputString);
							printLengthAndString(stringBuilder);
							System.out.println("Enter the starting index of the substring to replace ");
							startIndex = scan.nextInt();
							System.out.println("Enter the ending index of the substring to replace ");
							endIndex = scan.nextInt();
							scan.nextLine();
							System.out.println("Enter the substring to be replaced:");
							String substitute = scan.nextLine();
							task.replaceSubstring(stringBuilder, startIndex, endIndex,substitute);
							printLengthAndString(stringBuilder);
							break;
							

						case 9 :
							System.out.print("Enter the no. of strings to append:");
							count = scan.nextInt();
							scan.nextLine();
							System.out.print("Enter the delimiter to concatenate (for space as delimiter ,enter yes):");
							delimiter = scan.nextLine();
							if(delimiter.equals("yes"))
							{
									delimiter=" ";
							}
							stringArray = new String[count];
							for(int i=0;i<count;i++)
							{
								System.out.println("Enter the string to add:");
								stringArray[i] = scan.nextLine(); 
							} 
							stringBuilder = task.getStringBuilder() ;
							task.appendStringsWithDelimiter(stringBuilder ,stringArray , delimiter);
							printLengthAndString(stringBuilder);
							System.out.println("Enter the character to search");
							substring= scan.next();
							System.out.println("The first index of "+substring+"is"+task.findIndex(stringBuilder , substring ));
							break;
						case 10 :
							System.out.print("Enter the no. of strings to append:");
							count = scan.nextInt();
							scan.nextLine();
							System.out.print("Enter the delimiter to concatenate (for space as delimiter ,enter yes):");
							delimiter = scan.nextLine();
							if(delimiter.equals("yes"))
							{
									delimiter=" ";
							}
							stringArray = new String[count];
							for(int i=0;i<count;i++)
							{
								System.out.println("Enter the string to add:");
								stringArray[i] = scan.nextLine(); 
							} 
							stringBuilder = task.getStringBuilder() ;
							task.appendStringsWithDelimiter(stringBuilder ,stringArray , delimiter);
							printLengthAndString(stringBuilder);
							System.out.println("Enter the substring to search :");
							substring  = scan.next();
							
							System.out.println("The last index of "+substring+" is"+task.findIndex(stringBuilder , substring ));
							break;

						default:
							System.out.println("Invalid Choice");
							
					}
			
			
		}
		}
		catch(TaskException e)
		{
				System.out.println(e.getMessage());
		}
		finally
		{
			scan.close();
		}
	}
	public static void printLengthAndString( StringBuilder stringBuilder) throws TaskException
	{
		System.out.println("The length of the StringBuilder is "+Util.findLength(stringBuilder));
		System.out.println("The string is "+stringBuilder.toString());	
	}


}