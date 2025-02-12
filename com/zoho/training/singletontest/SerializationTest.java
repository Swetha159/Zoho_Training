package com.zoho.training.singletontest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.zoho.training.basicprogramming.task.BillPughSingleton;

public class SerializationTest {
	public static void main(String[] args)
    {   
        BillPughSingleton object = BillPughSingleton.getInstance();
        String filename = "file.text";
        
        try
        {   
         
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            
   
            out.writeObject(object);
            
            out.close();
            file.close();
            
            System.out.println("Object has been serialized");



            BillPughSingleton objectTwo = null;

        	FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            
            objectTwo = (BillPughSingleton)in.readObject();
            
            in.close();
            fileIn.close();
            
            System.out.println("Object has been deserialized ");
            System.out.println(object);
            System.out.println(object.hashCode());
            System.out.println(objectTwo.hashCode());
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

    }
}

