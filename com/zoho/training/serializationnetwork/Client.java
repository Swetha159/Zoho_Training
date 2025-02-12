package com.zoho.training.serializationnetwork;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            
            Student student = (Student) ois.readObject();
            System.out.println("Received Student: " + student.getName() + ", Age: " + student.getAge());

            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
