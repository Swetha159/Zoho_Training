package com.zoho.training.serializationnetwork;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is waiting for a client...");
            Socket socket = serverSocket.accept();
          
            Student student = new Student("Alice", 20);

         
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(student);
            oos.flush();
            System.out.println("Student object sent to client.");

            oos.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

