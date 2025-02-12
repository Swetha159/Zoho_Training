package com.zoho.training.vehicle;

public class Bus
{
	String model;
	int seats;
     
	public void setModel(String string)
	{
		this.model = string;
	}
	public void setSeats(int count)
	{
		this.seats = count;
	}
	public String getModel()
	{
		return model;
	}
	public int getSeats()
	{
		return seats;
	}
	public Bus(String color,int seats)
	{
		setModel(color);
		setSeats(seats);
	}
	public Bus()
	{
	}
	@Override
	public String toString()
	{
		return "Model : "+this.model+"\nSeats : "+this.seats;
	}	
  

}