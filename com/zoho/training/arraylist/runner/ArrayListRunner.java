package com.zoho.training.arraylist.runner;
import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.zoho.training.arraylist.task.ArrayListTask;
import com.zoho.training.birds.ALBird;
import com.zoho.training.exceptions.TaskException;
import com.zoho.training.utility.Util;

public class ArrayListRunner
{
	public static void main(String args[])
	{
        	Scanner scan = new Scanner(System.in);
		try{
		ArrayListTask task = new ArrayListTask();
		ArrayListRunner runner = new ArrayListRunner();
	
		int choice=0;
		while(choice!=19)
		{
		try
		{
			
			
				System.out.println("1.Create ArrayList  \n2.Create  String ArrayList\n3.Create Integer ArrayList\n4.Create Object ArrayList\n5.Create Arraylist with string,integer,objects \n6.Find Index \n7.Print Elements using Iterator and For Loop \n8.Find Element using index \n9.Find first and last position of the element \n10.Insert Element at specified index \n11.Create ArrayList using sublist \n12.Create ArrayList using ArrayLists \n13.InsertArrayList \n14.Remove Element using index \n15.Remove Collection \n16.Retain Collection \n17.Remove all elements from the ArrayList \n18.Check presence of a element \nEnter your choice:");
				choice=scan.nextInt();
				int count;
				switch(choice)
				{
					case 1 :
						List<Integer> arrayList = task.getList();
						System.out.println("The length of the ArrayList is "+Util.findLength(arrayList));
						break;
					case 2 :
						List<String> stringList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					String[] stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
        					task.addObjects(stringArray, stringList);
        					runner.PrintArrayListAndSize(stringList);
						break;
					case 3 :
						List<Integer> intList =  task.getList();
       						System.out.println("Enter no. of integers:");
        					count = scan.nextInt();        
						Integer[] intArray = new Integer[count];
        					for (int i = 0; i < count; i++) 
						{
            						intArray[i] = scan.nextInt();          
	    					}
        					task.addObjects(intArray, intList);
        					runner.PrintArrayListAndSize(intList);
						break;	

					case 4 :
						List<ALBird> customObjectList = task.getList();
       						System.out.println("Enter no. of objects :");
        					count = scan.nextInt();        
						ALBird[] CustomObjectArray = new ALBird[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.println("Enter the Bird Name:");
            						CustomObjectArray[i] = new ALBird(scan.next());          
	    					}
        					task.addObjects(CustomObjectArray, customObjectList);
        					runner.PrintArrayListAndSize(customObjectList);
						break;
							
					case 5 :
						List<Object> objectList = task.getList();
       						System.out.println("Enter no. of strings to add :");
        					int stringCount = scan.nextInt();
						System.out.println("Enter no. of integers to add :");
        					int integerCount = scan.nextInt();
						System.out.println("Enter no. of custom objects to add :");
        					int objectCount = scan.nextInt();  
						count = stringCount+ integerCount+objectCount;        
						Object[] objectArray = new Object[count];
						int j=0;
        					for (int i = 0; i < stringCount; i++) 
						{
							System.out.print("Enter the String:");
            						objectArray[j++] = scan.next();    
        					}
						for (int  i=0 ; i < integerCount; i++) 
						{
							System.out.print("Enter the number:");
            						objectArray[j++] = scan.nextInt();          
	    					}
						for (int i = 0; i <objectCount; i++) 
						{
							System.out.println("Enter the Bird Name:");
            						objectArray[j++] = new ALBird(scan.next());          
	    					}
        					task.addObjects(objectArray, objectList);
        					runner.PrintArrayListAndSize(objectList);
						break;

					case 6 : 
						stringList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, stringList);
						System.out.println("Enter the string to find index");
						String string = scan.next();
						System.out.println("The index of the string is "+task.findIndex(string,stringList));
						runner.PrintArrayListAndSize(stringList);
						break;
					case 7 : 
						stringList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, stringList);
						System.out.println("Using Iterator to print elements:");
        					Iterator<String> iterator = stringList.iterator();
        					while (iterator.hasNext()) {
            						System.out.println(iterator.next());
        					}
        					System.out.println("\nUsing for loop to print elements:");
        					for (String str : stringList) {
            						System.out.println(str);
        					}
						break;

					case 8 :
						stringList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, stringList);
					        System.out.println("Enter the index to find the element:");
						int index= scan.nextInt();
						System.out.println("The element in the Arraylist at the index "+index +" is "+ 																task.findElement(index,count,stringList));
						runner.PrintArrayListAndSize(stringList);
						break;

					case 9:
						stringList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, stringList);
						System.out.println("Enter the string to find its first and last index");
						string = scan.next();
						System.out.println("The first index of the element is at "+task.findIndex(string,stringList));
						System.out.println("The last index of the element is at "					+task.findLastIndex(string,stringList));
						break;
					case 10 : 
						stringList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, stringList);
						System.out.println("Enter the position insert the string:");
						index = scan.nextInt();
						System.out.println("Enter the string to insert :");
						string = scan.next();
						task.insertElement(index,string,stringList);
						runner.PrintArrayListAndSize(stringList);
						break;						
					
					case 11 :
						List<String> firstList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, firstList);
						System.out.println("Enter the from index for new Array :");
						int fromIndex = scan.nextInt();
						System.out.println("Enter the to index for new Array :");
						int toIndex = scan.nextInt();
						List<String> secondList = task.getList();
						task.createListUsingSubList(secondList,firstList, fromIndex ,toIndex);
						runner.PrintArrayListAndSize(secondList);
						break;

					case 12 :
						firstList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, firstList);
						secondList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, secondList);
						List<String> thirdList =task.getList();
						task.createListUsingList(thirdList, firstList);
						task.createListUsingList(thirdList, secondList);
						runner.PrintArrayListAndSize(thirdList);
						break;
					case 13 :
						firstList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, firstList);
						secondList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, secondList);
						thirdList =task.getList();
						System.out.println("Enter the index to insert :");
						index = scan.nextInt();
						//index = Util.findLength(firstList);
						task.insertList(thirdList,firstList,0);
						task.insertList(thirdList,secondList,index);
						runner.PrintArrayListAndSize(thirdList);
						break;
					
					case 14 : 
						List<Double> doubleList = task.getList();
       						System.out.println("Enter no. of decimal values:");
        					count = scan.nextInt();        
						Double[] doubleArray = new Double[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the Decimal values:");
            						doubleArray[i] = scan.nextDouble();          
	    					}
        					task.addObjects(doubleArray, doubleList);
						System.out.println("Enter the index to delete :");
						index = scan.nextInt();
						task.removeElement(index, doubleList);
        					runner.PrintArrayListAndSize(doubleList);
						break;	

					case 15 :
						firstList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, firstList);
						secondList = task.getList();
						System.out.println("Enter no. of strings:");
						count = scan.nextInt();
						System.out.println("Enter the from index for new Array :");
						fromIndex = scan.nextInt();
						System.out.println("Enter the to index for new Array :");
						toIndex = scan.nextInt();
						Util.checkBoundary(count ,Util.findLength(firstList));
						secondList =task.getList();
						task.createListUsingSubList(secondList,firstList, fromIndex ,toIndex);
						runner.PrintArrayListAndSize(secondList);
						task.removeList(firstList,secondList);
						runner.PrintArrayListAndSize(firstList);
						break;
					case 16 :
						firstList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, firstList);
						secondList = task.getList();
						System.out.println("Enter no. of strings:");
						count = scan.nextInt();
						System.out.println("Enter the from index for new Array :");
						fromIndex = scan.nextInt();
						System.out.println("Enter the to index for new Array :");
						toIndex = scan.nextInt();
						Util.checkBoundary(count ,Util.findLength(firstList));
						secondList = task.getList();
						task.createListUsingSubList(secondList,firstList, fromIndex ,toIndex);
						runner.PrintArrayListAndSize(secondList);
						task.retainList(firstList,secondList);
						runner.PrintArrayListAndSize(firstList);
						break; 
					case 17 : 
						List<Long> longList = task.getList();
						System.out.println("Enter no. of Long Values :");
        					count = scan.nextInt();
        					Long[] longArray = new Long[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the Long Value:");
            						longArray[i] = scan.nextLong();    
        					}
						task.addObjects(longArray, longList);
						System.out.println("Before Deletion");
						runner.PrintArrayListAndSize(longList);
						task.clearList(longList);
						System.out.println("After Deletion");
						runner.PrintArrayListAndSize(longList);
						break;
					case 18 : 
						stringList = task.getList();
						System.out.println("Enter no. of strings:");
        					count = scan.nextInt();
        					stringArray = new String[count];
        					for (int i = 0; i < count; i++) 
						{
							System.out.print("Enter the String:");
            						stringArray[i] = scan.next();    
        					}
						task.addObjects(stringArray, stringList);
						System.out.println("Enter the string to check :");
						string = scan.next();
						if(task.checkPresenceOfElement(stringList , string))
						{
							System.out.println("The string is present in the ArrayList");
						}
						else
						{
							System.out.println("The string is not present in the ArrayList");
						}
						runner.PrintArrayListAndSize(stringList);
						break;

					default :
						System.out.println("Enter Valid Choice");
						
				}
			
		}
		catch (InputMismatchException e) 
		{
                	System.out.println("Invalid input");
                	scan.nextLine();
                	
        }
		catch(TaskException e)
		{
			System.out.println(e.getMessage());
			scan.nextLine();
		}
	}
	}
	finally
	{
		scan.nextLine(); 
		scan.close();
	}
	}
	
	public void PrintArrayListAndSize(List arrayList) throws TaskException
	{
		System.out.println(arrayList.toString());
		System.out.println("The length of the ArrayList is "+Util.findLength(arrayList));
	}
	





}