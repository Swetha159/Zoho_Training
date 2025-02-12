package com.zoho.training.birds;

public  class ALBird 
{

	String name;
	public void speak()
	{
		System.out.println("I am speaking");
	}
	public ALBird(String name)
	{
		this.name = name;
	}
	@Override
	public String toString()
	{
		return this.name;
	}
	
}