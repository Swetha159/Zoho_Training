package com.zoho.training.threads.runner;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.zoho.training.threads.task.ExtendedThread;
import com.zoho.training.threads.task.RunnableThread;

public class ThreadRunner {

	public static void main(String args[]) 
	{
		try(Scanner scan = new Scanner(System.in))
	    {
			ThreadRunner runner =new ThreadRunner();
			int choice =0;
			while(choice !=8)
			{
				System.out.println("Choose : \n1.Create Thread by Thread Class\n2.Create Thread by runnable interface ");
				choice = scan.nextInt();
				switch(choice) 
				{
					case 1:
						ExtendedThread threadOne = new ExtendedThread();
						runner.printNameStatePriority(threadOne);
						threadOne.start();
						runner.printNameStatePriority(threadOne);
						break;
						
					case 2:
						RunnableThread runnable = new RunnableThread();
						Thread threadTwo = new Thread(runnable);
						runner.printNameStatePriority(threadTwo);
						threadTwo.start();
						runner.printNameStatePriority(threadTwo);
						break;
						
					case 3:
						ExtendedThread threadThree = new ExtendedThread();
						System.out.println("Enter the Name for Thread:");
						String  name = scan.next();
						threadThree.setName(name);
						runner.printNameStatePriority(threadThree);
						threadThree.start();
						runner.printNameStatePriority(threadThree);
						break;
						
					case 4:
						RunnableThread runnableTwo = new RunnableThread();
						Thread threadFour = new Thread(runnableTwo);
						System.out.println("Enter the Name for Thread:");
					    name = scan.next();
						threadFour.setName(name);
						runner.printNameStatePriority(threadFour);
						threadFour.start();
						runner.printNameStatePriority(threadFour);
						break;	
					case 5:
						System.out.println("Enter the no. of threads to spawn :");
						int threadCount = scan.nextInt();
						String threadName ;
						int time;
						ExtendedThread[] extendedThreads = new ExtendedThread[threadCount] ;
						for(int i=0;i<threadCount;i++)
						{
							System.out.println("Enter the name for thread "+i+" :");
							threadName = scan.next();
							System.out.println("Enter the sleep time for thread "+i+" :");
							time = scan.nextInt();
							extendedThreads[i]= new ExtendedThread(threadName);	
							extendedThreads[i].setSleepTime(time);
						}
						for(ExtendedThread thread : extendedThreads)
						{
							thread.start();
						}
						takeThreadDump();
						for(ExtendedThread thread : extendedThreads)
						{
							thread.stopThread();
						}
						break;
					case 6:
						System.out.println("Enter the no. of threads to spawn :");
						threadCount = scan.nextInt();
						Thread[] threads = new Thread[threadCount];
						RunnableThread[] runnableThreads = new RunnableThread[threadCount] ;
						for(int i=0;i<threadCount;i++)
						{
							System.out.println("Enter the name for thread "+i+" :");
							threadName = scan.next();
							System.out.println("Enter the sleep time for thread "+i+" :");
							time = scan.nextInt();
							runnableThreads[i]=new RunnableThread();
							runnableThreads[i].setSleepTime(time);
							threads[i]= new Thread(new RunnableThread());	
							threads[i].setName(threadName);
							                                             
						}
						for(Thread thread : threads)
						{
							thread.start();
						}
						takeThreadDump();
						for(Thread thread : threads)
						{
							thread.stopThread();
						}
						break;
					case 7 :
						
				         
					
					case 8:
						System.out.println("Exiting");
						break;
					default:
						System.out.println("Invalid Choice");
				}
			}
	    }
		
		
	}
		public void printNameStatePriority(Thread thread)
		{
			System.out.println(thread.getName());
			System.out.println(thread.getPriority());
			System.out.println(thread.getState());
		}
		 public static void takeThreadDump() {
		      
		        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

		        
		        long[] threadIds = threadMXBean.getAllThreadIds();

		       
		        ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds, Integer.MAX_VALUE);

		        System.out.println("===== THREAD DUMP =====");
		        for (ThreadInfo threadInfo : threadInfos) {
		            if (threadInfo != null) {
		                System.out.println("Thread Name: " + threadInfo.getThreadName());
		                System.out.println("Thread State: " + threadInfo.getThreadState());

		               
		                for (StackTraceElement element : threadInfo.getStackTrace()) {
		                    System.out.println("\tat " + element);
		                }

		                System.out.println("---------------------------------");
		            }
		        }
		    }
    
}


