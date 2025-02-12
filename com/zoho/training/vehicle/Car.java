package com.zoho.training.vehicle;

public class Car
{
	private int yearOfMake;
	private String engineNumber;
	private String type;

	public  Car()
	{
		
	}
	public  Car(String string)
	{
		System.out.println(string);

	}
	public int getYearOfMake()
	{
		return yearOfMake;
	}
	public String getEngineNumber()
	{
		return engineNumber;
	}
	public String getType()
	{
		return type;
	}

	public void setYearOfMake(int value)
	{
		this.yearOfMake = value;
	} 
	public void setEngineNumber(String string)
	{
		this.engineNumber = string;
	} 
	public void setType(String string)
	{
		this.type = string;
	} 
	public void maintenance() 
	{
        	System.out.println("Car under maintenance");
	}
	@Override
	public String toString()
	{
		return "Year Of Make :"+this.getYearOfMake() + "\nEngine Number :" + this.getEngineNumber() + "\nType :" + this.getType();  
	}
	
}