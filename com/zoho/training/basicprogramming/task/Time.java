package com.zoho.training.basicprogramming.task;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

import com.zoho.training.exceptions.TaskException;
import com.zoho.training.utility.Util;

public class Time {
	
	public static final Set<String> availableIds = ZoneId.getAvailableZoneIds();
	
	public ZonedDateTime getZonedDateTime(ZoneId zone)throws TaskException
	{
		Util.validateInput(zone,"ZoneId");
		return ZonedDateTime.now(zone);
	}
	
	public long getTimeInMilliUsingSystem() {
		return System.currentTimeMillis();
	}
	
	public Instant getInstant()
	{
	     return Instant.now();
	}
	
	public long getTimeInMilli(Instant instant)throws TaskException
	{
		 Util.validateInput(instant,"Instant");
		return instant.toEpochMilli();
	}
	
   public ZoneId getZoneId(String string)throws TaskException
   {
		Util.validateInput(string,"String");
	   return ZoneId.of(string);
   }
   
   public ZoneId getDefaultSystemZoneId() 
   {
	   return ZoneId.systemDefault();
   }
	
   public Instant getInstantFromMilli(long milliSeconds) throws TaskException
   {
	   Util.validateInput(milliSeconds,"milli seconds");
	   return Instant.ofEpochMilli(milliSeconds);
   }
   
   public ZonedDateTime getDateTimeFromInstant(Instant instant ,ZoneId zoneId)throws TaskException
   {
	   Util.validateInput(zoneId,"ZoneId");
	   Util.validateInput(instant,"Instant");
	   return ZonedDateTime.ofInstant(instant,zoneId);
   }
   
   
   public Month getMonthFromDatetIme(ZonedDateTime dateTime)throws TaskException
   {
	   Util.validateInput(dateTime,"Date Time");
	   return dateTime.getMonth();
   }
	
	public DayOfWeek getDayFromDatetIme(ZonedDateTime dateTime)throws TaskException 
	{
		Util.validateInput(dateTime,"Date Time");
		return dateTime.getDayOfWeek();
	}
	public int getYearFromDatetIme(ZonedDateTime dateTime) throws TaskException
	{
		Util.validateInput(dateTime,"Date Time");
		return dateTime.getYear();
	}
	public void validTimeZone(String zoneString) throws TaskException {
		
	    if(!availableIds.contains(zoneString))
	    {
	    	throw new TaskException("Invalid ZoneID :Choose from the list \n "+ availableIds.toString());
	    }
	    
	}
	
}
