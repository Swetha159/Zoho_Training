package com.zoho.training.arraylist.task;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zoho.training.exceptions.TaskException;
import com.zoho.training.utility.Util;

//import java.util.ArrayList;


public class ArrayListTask
{
	public  <T> List<T> getList() throws TaskException
	{
        try {
        	String className = System.getProperty("list");
            Class<?> newClass = Class.forName(className);
			return (List<T>) newClass.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
		
			throw new TaskException("Error occured in Initialising",e);
		}
    }
	
	public <T> List<T> addObjects(T[] objectArray, List<T> list) throws TaskException
	{
		Util.validateInput(objectArray , "Object Array");
		Util.validateInput(list , "List");
        	for (T object : objectArray) 
		{
            		list.add(object);
        	}
        	return list;
   	}
	public <T> int findIndex(T object, List<T> list) throws TaskException
	{
		Util.validateInput(object , "Object");
		Util.validateInput(list , "List");
    		return list.indexOf(object);
	}
	public <T> T findElement(int index,int count,List<T> list) throws TaskException
	{
		Util.validateInput(list , "List");		
		Util.checkBoundary(index,count);
		return list.get(index);
	}
	public <T> int findLastIndex(T object , List<T> list)throws TaskException
	{
		Util.validateInput(object , "Object");
		Util.validateInput(list , "List");
		return list.lastIndexOf(object);
	}
	public <T> void insertElement(int index , T object , List<T> list) throws TaskException
	{
		Util.validateInput(index , "Index Value");
		Util.validateInput(object , "Object");
		Util.validateInput(list , "List");
		list.add(index,object);
	}
	public <T> void createListUsingSubList(List<T> firstList,List<T> secondList, int fromIndex , int toIndex) throws TaskException
	{
		Util.validateInput(firstList , "List");
		Util.validateInput(fromIndex , "From Index Value");
		Util.validateInput(toIndex , "To Index Value");
		createListUsingList(firstList,secondList.subList(fromIndex,toIndex));					
	}
	public <T> void createListUsingList(List<T> firstList,List<T> secondList ) throws TaskException
	{	
		Util.validateInput(firstList , "First List");
		Util.validateInput( secondList , "Second List");
		firstList.addAll(secondList);
	}
	public <T> void insertList(List<T> firstList,List<T> secondList,int index) throws TaskException
	{
		Util.validateInput(firstList , "First List");
		Util.validateInput( secondList , "Second List");
		Util.validateInput(index , "Index Value");
		firstList.addAll(index,secondList);
	}
	public <T> void removeElement(int index ,List<T> list) throws TaskException
	{
		Util.validateInput(list , "List");
		Util.validateInput(index , "Index Value");
		list.remove(index);
	}
	public <T> void removeList(List<T> firstList,List<T> secondList ) throws TaskException
	{
		Util.validateInput(firstList , "First List");
		Util.validateInput( secondList , "Second List");
		firstList.removeAll(secondList);
	}
	public <T> void retainList(List<T> firstList,List<T> secondList ) throws TaskException
	{
		Util.validateInput(firstList , "First List");
		Util.validateInput( secondList , "Second List");
		firstList.retainAll(secondList);
	}
	public <T> void clearList(List<T> list) throws TaskException
	{
		Util.validateInput(list , "List");
		list.clear();
	}
	public <T> boolean checkPresenceOfElement(List<T> list,T object) throws TaskException
	{
		Util.validateInput(object , "Object");
		Util.validateInput(list , "List");
		return list.contains(object);
	}




}