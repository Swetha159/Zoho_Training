package com.zoho.training.hashmap.runner;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.zoho.training.birds.HMBird;
import com.zoho.training.exceptions.TaskException;
import com.zoho.training.hashmap.task.HashMapTask;
import com.zoho.training.utility.Util;

public class HashMapRunner
{
 	public static void main(String args[]) 
	{
		Scanner scan = new Scanner(System.in);
		try
		{
			HashMapTask task = new HashMapTask();
			HashMapRunner runner = new HashMapRunner(); 
			int choice=0;
			while(choice!=20)
			{
				try
				{
				 System.out.println("1.Create HashMap \n2.Create String-String HashMap \n3.Create Integer-Integer hashMap \n4.Create String-Integer hashMap \n5.Create String-CustomClass hashMap  \n6.Create hashMap with null as value \n7.Create hashMap with null as key \n8.Check if key exists \n9.Check if value exists \n10.Change Entire keys \n11.Get value using key \n12.Get value or default value using key \n13.Remove Key \n14.Remove Key if value matches \n15.Replace value \n16.Replace value if previous value matches \n17.Add Map to another Map \n18.Print keys and values \n19.Remove All Entries\n20.Exit\nEnter your choice : ");
				 choice = scan.nextInt();
				 switch(choice)
				{
					case 1 : 
						Map<String,String> stringStringMap = task.getMap();
						runner.printMapAndSize(stringStringMap);
						break;
					case 2	:
						stringStringMap = task.getMap();
						System.out.println("Enter no. of pairs");
						int count = scan.nextInt();
						String stringKey; 
						String stringValue;
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter yes if null):");
							stringValue=scan.next();
							stringValue = (stringValue.equals("yes")) ? null : stringValue;
							task.addKeyAndValue(stringStringMap,stringKey,stringValue);

						}
						runner.printMapAndSize(stringStringMap);
						break;
					case 3: 
						Map<Integer,Integer> intIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						Integer intKey;
						Integer intValue;
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter -1 if null):");
							intKey=scan.nextInt();
							intKey = (intKey == -1 ) ? null : intKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(intIntMap,intKey,intValue);
						}
						runner.printMapAndSize(intIntMap);
						break;
					case 4	:
						Map<String,Integer> stringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(stringIntMap,stringKey,intValue);
						}
						runner.printMapAndSize(stringIntMap);
						break;
					case 5:
						Map<String,HMBird> stringBirdMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						HMBird birdValue;
						String name ;
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter yes if null):");
							name =scan.next();
							birdValue = (name.equals("yes")) ? null: new HMBird(name);
							task.addKeyAndValue(stringBirdMap,stringKey,birdValue);
						}
						runner.printMapAndSize(stringBirdMap);
						break;
					case 6 : 
						stringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key:");
							stringKey=scan.next();
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(stringIntMap,stringKey,intValue);
						}
						runner.printMapAndSize(stringIntMap);
						break;
					case 7 : 
						stringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(stringIntMap,stringKey,intValue);
						}
						runner.printMapAndSize(stringIntMap);
						break;
					case 8 : 
						stringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(stringIntMap,stringKey,intValue);
						}
						System.out.println("Enter the key to check :");
						stringKey = scan.next();
						if(task.keyExists(stringIntMap,stringKey))
						{
							System.out.println("The key "+stringKey + " is present");
						}
						else
						{
							System.out.println("The key "+stringKey + " is  not present");
						}
						break;
					case 9 : 
						stringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(stringIntMap,stringKey,intValue);
						}
						System.out.println("Enter the key to check :");
						Integer integerKey = scan.nextInt();
						if(task.valueExists(stringIntMap,integerKey))
						{
							System.out.println("The value "+ integerKey + " is present");
						}
						else
						{
							System.out.println("The value "+ integerKey + " is  not present");
						}
						break;
					case 10 : 
						stringStringMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter yes if null):");
							stringValue=scan.next();
							stringValue = (stringValue.equals("yes")) ? null : stringValue;
							task.addKeyAndValue(stringStringMap,stringKey,stringValue);
						}
						System.out.println("Before Changing Value");
						runner.printMapAndSize(stringStringMap);
						for(String string : task.getKeySet(stringStringMap))
						{
							System.out.println("Enter the new value for the key " + string + " (enter yes if null) :");
							stringValue=scan.next();
							stringValue = (stringValue.equals("yes")) ? null : stringValue;
							task.addKeyAndValue(stringStringMap,string,stringValue);
						}
						System.out.println("After Changing Value");
						runner.printMapAndSize(stringStringMap);
						break;
					case 11 : 
						stringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(stringIntMap,stringKey,intValue);
						}
						System.out.println("Enter the key to find value :");
						stringKey = scan.next();
						System.out.println("The Value for the key is "+task.getValue(stringIntMap,stringKey));
						break;
					case 12 :
						stringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(stringIntMap,stringKey,intValue);
						}
						System.out.println("Before returning value from non - existing key ");
						runner.printMapAndSize(stringIntMap);
						System.out.println("Enter the key to find value :");
						stringKey = scan.next();
						System.out.println("Enter the default value :");
						Integer  defaultValue = scan.nextInt();
						System.out.println("The Value for the key is "+task.getValueOrDefaultValue(stringIntMap,stringKey,defaultValue));
						System.out.println("After returning value from non - existing key ");
						runner.printMapAndSize(stringIntMap);
						break;
					case 13 : 
						stringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(stringIntMap,stringKey,intValue);
						}
						System.out.println("Before removing key ");
						runner.printMapAndSize(stringIntMap);
						System.out.println("Enter the key to remove :");
						stringKey = scan.next();
						task.removeKey(stringIntMap,stringKey);
						System.out.println("After removing key ");
						runner.printMapAndSize(stringIntMap);
						break;
					case 14 :
						stringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(stringIntMap,stringKey,intValue);
						}
						System.out.println("Before removing key ");
						runner.printMapAndSize(stringIntMap);
						System.out.println("Enter the key to remove :");
						stringKey = scan.next();
						System.out.println("Enter the value to check :");
						intValue = scan.nextInt();
						task.removeKeyIfValueMatches(stringIntMap,stringKey,intValue);
						System.out.println("After removing key ");
						runner.printMapAndSize(stringIntMap);
						break;
					case 15 :
						stringStringMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter yes if null):");
							stringValue=scan.next();
							stringValue = (stringValue.equals("yes")) ? null : stringValue;
							task.addKeyAndValue(stringStringMap,stringKey,stringValue);
						}
						System.out.println("Before Replacing Value");
						runner.printMapAndSize(stringStringMap);
						System.out.println("Enter the key:");
						stringKey = scan.next();
						System.out.println("Enter the new value:");
						stringValue = scan.next();
						task.replaceValue(stringStringMap,stringKey,stringValue);
						System.out.println("After Replacing Value");
						runner.printMapAndSize(stringStringMap);
						break;
					case 16 : 
						stringStringMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter yes if null):");
							stringValue=scan.next();
							stringValue = (stringValue.equals("yes")) ? null : stringValue;
							task.addKeyAndValue(stringStringMap,stringKey,stringValue);
						}
						System.out.println("Before Replacing Value");
						runner.printMapAndSize(stringStringMap);
						System.out.println("Enter the key:");
						stringKey = scan.next();
						System.out.println("Enter the value:");
						stringValue = scan.next();
						System.out.println("Enter the  new value:");
						String newValue = scan.next();
						task.replaceValueIfValueMatches(stringStringMap,stringKey,stringValue,newValue);
						System.out.println("After Replacing Value");
						runner.printMapAndSize(stringStringMap);
						break;
					case 17 : 
						Map<String,Integer> firstStringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(firstStringIntMap,stringKey,intValue);
						}
						Map<String,Integer> secondStringIntMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{	
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter -1 if null):");
							intValue=scan.nextInt();
							intValue = (intValue == -1) ? null : intValue;
							task.addKeyAndValue(secondStringIntMap,stringKey,intValue);
						}
						System.out.println("Before Change ");
						runner.printMapAndSize(firstStringIntMap);
						runner.printMapAndSize(secondStringIntMap);
						task.addMap(firstStringIntMap,secondStringIntMap);
						System.out.println("After Change ");
						runner.printMapAndSize(firstStringIntMap);
						runner.printMapAndSize(secondStringIntMap);
						break;
					case 18 : 
						stringStringMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter yes if null):");
							stringValue=scan.next();
							stringValue = (stringValue.equals("yes")) ? null : stringValue;
							task.addKeyAndValue(stringStringMap,stringKey,stringValue);
						}
						for (Map.Entry<String, String> entry : task.getEntrySet(stringStringMap))
						{
							System.out.println("Key :"+task.getKeyFromEntry(entry)+ " Value :"+task.getValueFromEntry(entry));
						}
						break;
					case 19 :
						stringStringMap = task.getMap();
						System.out.println("Enter no. of pairs");
						count = scan.nextInt();
						for(int i=0;i<count;i++)
						{	
							System.out.println("Enter the Key(enter yes if null):");
							stringKey=scan.next();
							stringKey = (stringKey.equals("yes")) ? null : stringKey;
							System.out.println("Enter the Value(enter yes if null):");
							stringValue=scan.next();
							stringValue = (stringValue.equals("yes")) ? null : stringValue;
							task.addKeyAndValue(stringStringMap,stringKey,stringValue);
						}
						System.out.println("Before removing all entries");
						runner.printMapAndSize(stringStringMap);
						task.removeAllEntries(stringStringMap);
						System.out.println("After removing all entries");
						runner.printMapAndSize(stringStringMap);
						break;
					case 20 :
						System.out.println("Exiting");
						break;
					default:
						System.out.println("Invalid Choice");
						
						
						
				}	
				}
				catch(InputMismatchException e)
				{
					System.out.println("Invalid input");
                			scan.nextLine(); 
				}
				catch(TaskException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		finally
		{
			scan.close();
		}
	}
	public void printMapAndSize(Map map) throws TaskException
	{
		System.out.println(map); 
		System.out.println("The size of the hashmap is "+Util.findLength(map));
	}
	
	
}