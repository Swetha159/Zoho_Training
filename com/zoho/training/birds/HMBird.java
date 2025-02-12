package com.zoho.training.birds;

public  class HMBird 
{

	String name;
	public void speak()
	{
		System.out.println("I am speaking");
	}
	public HMBird(String name)
	{
		this.name = name;
	}
	@Override
	public String toString()
	{
		return this.name;
	}
	
}