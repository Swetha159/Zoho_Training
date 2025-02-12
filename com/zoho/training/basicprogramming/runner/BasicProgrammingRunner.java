package com.zoho.training.basicprogramming.runner;
import java.util.InputMismatchException;
import java.lang.ClassNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zoho.training.arraylist.task.ArrayListTask;
import com.zoho.training.basicprogramming.task.BillPughSingleton;
import com.zoho.training.basicprogramming.task.FileTask;
import com.zoho.training.birds.POJOBird;
import com.zoho.training.exceptions.TaskException;
import com.zoho.training.property.PropertiesHelper;
import com.zoho.training.vehicle.Bus;
import com.zoho.training.basicprogramming.task.RainbowColors;
import com.zoho.training.basicprogramming.task.DoubleCheckSingleton;
import com.zoho.training.basicprogramming.task.Time;

import java.util.List;
import java.io.File;
import java.io.Writer;
import java.io.IOException;
import java.util.Properties;
import java.io.Reader;

public class BasicProgrammingRunner  
{
 	
	private static final Logger logger = Logger.getLogger(BasicProgrammingRunner.class.getName());
	
	public static void main(String args[]) 
	{
		
       
		Scanner scan = new Scanner(System.in);
		FileTask task = new FileTask();
		ArrayListTask list = new ArrayListTask();
		PropertiesHelper properties = new PropertiesHelper();
		Time timeObject = new Time();
		String filePath;
		
		try
		{
			    FileHandler infoHandler = new FileHandler("info.log", true);
		        FileHandler severeHandler = new FileHandler("error.log", true);
		        FileHandler fineHandler = new FileHandler("fine.log", true);
		       
		        severeHandler.setFilter(record -> record.getLevel() == Level.SEVERE);

		        fineHandler.setFilter(record -> record.getLevel() == Level.FINE);
		        
		        infoHandler.setFilter(record -> record.getLevel() == Level.INFO);
		        logger.setLevel(Level.FINE);
		        logger.addHandler(infoHandler);
		        logger.addHandler(severeHandler);
		        logger.addHandler(fineHandler);
				logger.setUseParentHandlers(false);
			int choice=0;
			while(choice!=21)
			{
				try
				{
			        
					System.out.println("\n1.Add lines to the file"
							+ "\n2.Store properties in File	"
							+ "\n3.Store Properties to Object from file"
							+ "\n4.Print Object"
							+ "\n5.Create instance using constructor "
							+ "\n6.Invoke Getter Setter "
							+ "\n7.Reflection(Invoke Default Constructor)"
							+ "\n8.Reflection(Invoke Overloaded Constructor)"
							+ "\n9.Reflection(Invoke Getter)"
							+ "\n10.Reflection(Invoke Setter)"
							+ "\n11.Print Enum (Rainbow Color)"
							+ "	\n12.Invoke values() of Enum"
							+ "	\n13.Implement Singleton Class"
							+ "	\n14.Get the Current Time of  a zone"
							+ "	\n15.Get Current time in milliseconds"
							+ "	\n16.Get Current time of a Zone							"
							+ "\n17.Get the Day using time in milliseconds	"
							+ "\n18.Get the Month using time in milliseconds "
							+ "\19.Get the Year using time in milliseconds "
							+"\n20.Get Offset"
							+ "\n21.Exit"
							+ "\nEnter your choice:");
				 
					choice = scan.nextInt();
					switch(choice)
					{
						case 1 :
							System.out.println("Enter the File Name :");
							String fileName = scan.next();
							System.out.println("Create File in Current Directory(Enter yes or no):");
							String current =scan.next();
							if(current.equals("yes"))
							{
								filePath =System.getProperty("user.dir");
								
							}
							else 
							{
								System.out.println("Enter the File Path :");
								filePath = scan.next();
							}
							File file = task.createFile(filePath,fileName);
							System.out.println("Enter the no. of lines :");
							int count = scan.nextInt();
							scan.nextLine();
							String[] stringArray = new String[count];
							for(int i=0;i<count;i++)
							{
								System.out.println("Enter the line :");
								stringArray[i] = scan.nextLine();
							}
							task.writeFile(stringArray, file);
							logger.info("File Created ");
						    break;
						case 2:
							System.out.println("Enter the File Name :");
							fileName = scan.next();
							Properties property =properties.getProperty();
							System.out.println("Enter the no. of keys and values pairs:");
							count = scan.nextInt();
							String key,value;
							for(int i=0;i<count;i++)
							{
								System.out.println("Enter the key :");
								key  = scan.next();
								System.out.println("Enter the value :");
								value  = scan.next();
								properties.addProperty(property,key,value);	
							}
							System.out.println("Check File in Current Directory(Enter yes or no):");
							current =scan.next();
							if(current.equals("yes"))
							{
								filePath = System.getProperty("user.dir");
							}
							else {
								System.out.println("Enter the File Path :");
								filePath = scan.next();
							}
							file = task.createFile(filePath,fileName);
							System.out.println("Enter comments :");
							String comment  = scan.nextLine();
							properties.storePropertyInFile(property,comment,file);
							logger.info( "Properties stored in the file");
							break;
						case 3:	
							System.out.println("Enter the File Name :");
							fileName = scan.next();
						    property =properties.getProperty();
							System.out.println("Check File in Current Directory(Enter yes or no):");
							current =scan.next();
							if(current.equals("yes"))
							{
								filePath =System.getProperty("user.dir");
							}
							else {
								System.out.println("Enter the File Path :");
								filePath = scan.next();
							}
							file = task.createFile(filePath,fileName);
							properties.loadProperty(property,file);
							logger.info("Property Object : "+property.toString()); 
							break;
						case 4 : 
							System.out.println("Enter the name :");
							POJOBird bird = new POJOBird(scan.next());
							logger.info(bird.toString());
							break;
						case 5:
							System.out.println("Enter the Bus Color:");
							String color = scan.next();
							System.out.println("Enter the Bus Seats Count :");
							int seats = scan.nextInt();
							Bus bus = new Bus(color,seats);
						    logger.info(bus.toString());
							break;
						case 6: 
							bus = new Bus();
							System.out.println("Enter the Bus Model:");
							bus.setModel(scan.next());
							System.out.println("Enter the Bus Seats Count :");
							bus.setSeats(scan.nextInt());
							logger.info("The Model of the Bus is "+bus.getModel());					
							logger.fine("There are "+bus.getSeats()+" seats in the bus ");
							break;
						case 7 :
							Class<?> newClass = Class.forName("zoho.training.vehicle.Bus");
							Object objectOne = newClass.getDeclaredConstructor().newInstance();
							logger.info("Object created by default constructor");
							break;
						case 8:
							newClass = Class.forName("zoho.training.vehicle.Bus");
							System.out.println("Enter the Model:");
							String model = scan.next();
							System.out.println("Enter the Bus Seats Count :");
							seats = scan.nextInt();						
							Object objectTwo = newClass.getDeclaredConstructor(String.class,int.class).newInstance(model,seats);
							logger.info("Object Created by overloaded constructor");
							break;
						case 9:
							newClass = Class.forName("zoho.training.vehicle.Bus");
						    objectOne = newClass.getDeclaredConstructor().newInstance();
						    System.out.println("Enter the Model:");
							model = scan.next();
							System.out.println("Enter the Bus Seats Count :");
							seats = scan.nextInt();	
							Method setModel = newClass.getDeclaredMethod("setModel", String.class);
							setModel.invoke(objectOne, model);
							Method setSeats = newClass.getDeclaredMethod("setSeats", int.class);
							setSeats.invoke(objectOne, seats);
							logger.info("Setters were called");
							break;
						case 10 :
							newClass = Class.forName("zoho.training.vehicle.Bus");
							System.out.println("Enter the Model:");
							model = scan.next();
							System.out.println("Enter the Bus Seats Count :");
							seats = scan.nextInt();						
							objectTwo = newClass.getDeclaredConstructor(String.class,int.class).newInstance(model,seats);
							Method getModel = newClass.getDeclaredMethod("getModel");
							String modelValue = (String)getModel.invoke(objectTwo);
							Method getSeats = newClass.getDeclaredMethod("getSeats");
							int seatsValue = (int)getSeats.invoke(objectTwo);
							logger.info("The model is "+modelValue);
							logger.info("The seat count is "+seatsValue);
							break;
						case 11:
							logger.info("Rainbow Colors and its code:");
							for(RainbowColors colour : RainbowColors.values())
							{
								logger.info("The Color code of "+colour+" is "+colour.getCode());
							}
							break;
						case 12 :
							for(RainbowColors colour : RainbowColors.values())
							{
								logger.info("Ordinal of "+colour +" is "+colour.ordinal() );
							}
							break;
						case 13: 
							BillPughSingleton instanceOne = BillPughSingleton.getInstance();
							System.out.println("Enter the string:");
							logger.info(String.valueOf(instanceOne.hashCode()));
							BillPughSingleton instanceTwo = BillPughSingleton.getInstance();
							System.out.println("Enter the string:");
							logger.info(String.valueOf(instanceTwo.hashCode()));
							break;
						case 14 :
							ZonedDateTime dateTime ;
							ZoneId zoneId;
							System.out.println("Enter the Time Zone Id(enter yes if time zone is system default):");
							String zoneString = scan.next();
							timeObject.validTimeZone(zoneString);
							if(zoneString.equals("yes"))
							{
								zoneId = timeObject.getDefaultSystemZoneId();
							}
							else
							{
								zoneId = timeObject.getZoneId(zoneString);
							}
							logger.info(timeObject.getZonedDateTime(zoneId).toString());
							break;
						case 15:
							logger.info("Using SystemDefault "+timeObject.getTimeInMilliUsingSystem());
							Instant instant = timeObject.getInstant();
							logger.info("Using Instant "+timeObject.getTimeInMilli(instant));
							break;
						case 16:
							System.out.println("Do you want to find for current time(yes or no)");
							String option = scan.next();
							long milliSeconds;
							if(option.equals("yes"))
							{
								instant = timeObject.getInstant();
								zoneId = timeObject.getDefaultSystemZoneId();
							}
							else {
								System.out.println("Enter the Time in milliseconds:");
								milliSeconds = scan.nextLong();
								System.out.println("Enter the  Zone Id:");
								zoneString = scan.next();
								timeObject.validTimeZone(zoneString);
								zoneId = timeObject.getZoneId(zoneString);
								instant = timeObject.getInstantFromMilli(milliSeconds);
							}
							ZonedDateTime zonedDateTime = timeObject.getDateTimeFromInstant(instant, zoneId);
							Month month =timeObject.getMonthFromDatetIme(zonedDateTime);
							logger.info("The month is "+month);
							break;
						case 17:
							System.out.println("Do you want to find for current time(yes or no)");
							option = scan.next();
							if(option.equals("yes"))
							{
								instant = timeObject.getInstant();
								zoneId = timeObject.getDefaultSystemZoneId();
							}
							else {
								System.out.println("Enter the Time in milliseconds:");
								milliSeconds = scan.nextLong();
								System.out.println("Enter the  Zone Id:");
								zoneString = scan.next();
								timeObject.validTimeZone(zoneString);
								zoneId = timeObject.getZoneId(zoneString);
								instant = timeObject.getInstantFromMilli(milliSeconds);
							}
							zonedDateTime = timeObject.getDateTimeFromInstant(instant, zoneId);
							DayOfWeek day =timeObject.getDayFromDatetIme(zonedDateTime);
							logger.info("The day is "+day);
							break;
						case 18 :
							System.out.println("Do you want to find for current time(yes or no)");
							 option = scan.next();
							if(option.equals("yes"))
							{
								instant = timeObject.getInstant();
								zoneId = timeObject.getDefaultSystemZoneId();
							}
							else {
								System.out.println("Enter the Time in milliseconds:");
								milliSeconds = scan.nextLong();
								System.out.println("Enter the  Zone Id:");
								zoneString = scan.next();
								timeObject.validTimeZone(zoneString);
								zoneId = timeObject.getZoneId(zoneString);
								instant = timeObject.getInstantFromMilli(milliSeconds);
							}
							zonedDateTime = timeObject.getDateTimeFromInstant(instant, zoneId);
							int year =timeObject.getYearFromDatetIme(zonedDateTime);
							logger.info("The year is "+year);
							break;
						case 19 : 
							System.out.println("Enter the date:");
							String input = scan.next();
							LocalDate date = LocalDate.parse(input);
							logger.info("Enter the  Zone Id:");
							zoneString = scan.next();
							timeObject.validTimeZone(zoneString);
							zoneId = timeObject.getZoneId(zoneString);
					        zonedDateTime = date.atStartOfDay(zoneId);
					        ZoneOffset offset = zonedDateTime.getOffset();
					        logger.info("The Offset is "+offset);
						case 20 :
							logger.info("Exiting");
							break;
						default:
							logger.info("Invalid Choice");
								
					}	
				}
				catch(InputMismatchException e)
				{
					logger.severe("Invalid input");
                    scan.nextLine(); 
				}
				catch(TaskException | ClassNotFoundException | InstantiationException | NoSuchMethodException  |IllegalAccessException | InvocationTargetException |IOException e)
				{
					logger.severe(e.getMessage());
					logger.log(Level.SEVERE,"StackTrace" , e);
				}
				
			}
		}
		catch(IOException |SecurityException e)
		{
			logger.severe(e.getMessage());
		}
		finally
		{
			scan.close();
		}
	
	}

}	