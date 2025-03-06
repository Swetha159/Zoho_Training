package com.zoho.training.threads.task;

import java.util.Scanner;

public class ClassD {

	public static void methodD() {
		
			System.out.println("The Thread "+Thread.currentThread().getName()+"has ThreadLocal Value : "+ClassA.getValue());
		
	}
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		int threadCount =3;
		ClassA[] threads = new ClassA[threadCount];
		String name = null;
		for (int i = 0; i < threadCount; i++) {
			System.out.println("Enter the ThreadLocal Value for thread - "+i+" :");
		 name = scan.next();
			threads[i] = new ClassA(name);
			
		}
		for (ClassA thread : threads) {
			thread.start();
			
		}
		
		
			 
		 
	}
}

