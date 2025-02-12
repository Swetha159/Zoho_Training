package com.zoho.training.rpc;

import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Hello obj = (Hello) Naming.lookup("rmi://localhost/HelloService");
            System.out.println(obj.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
