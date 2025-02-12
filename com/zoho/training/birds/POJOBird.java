package com.zoho.training.birds;

public  class POJOBird 
{

	String name;
	public void speak()
	{
		System.out.println("I am speaking");
	}
	public POJOBird(String name)
	{
		this.name = name;
	}
	@Override
	public String toString()	{
		return this.name;
	}
	
}