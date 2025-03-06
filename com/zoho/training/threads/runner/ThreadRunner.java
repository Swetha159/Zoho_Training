package com.zoho.training.threads.runner;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.zoho.training.threads.task.ExtendedThread;
import com.zoho.training.threads.task.RunnableThread;
import com.zoho.training.utility.Util;

public class ThreadRunner {

	private static final Logger logger;

	static {
		try {
			logger = Util.getLogger(ThreadRunner.class);
		} catch (IOException e) {
			throw new RuntimeException("Failed to initialize logger", e);
		}
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		try {
			FileHandler infoHandler = new FileHandler("ThreadInfo.log", true);
			FileHandler severeHandler = new FileHandler("ThreadError.log", true);

			severeHandler.setFilter(record -> record.getLevel() == Level.SEVERE);

			infoHandler.setFilter(record -> record.getLevel() == Level.INFO);
			logger.setLevel(Level.FINE);
			logger.addHandler(infoHandler);
			logger.addHandler(severeHandler);

			logger.setUseParentHandlers(false);

			ThreadRunner runner = new ThreadRunner();
			int choice = 0;
			
			
			while (choice != 7) {
				
				try  {
                    
					System.out.println("Choose : \n1.Create Thread by Thread Class\n"
							+ "2.Create Thread by runnable interface \n" + "3.Assisgn Name(Extended)\n"
							+ "4.Assign Name(Runnable)\n" + "5.Threads Spawn (Extended)\n" + "6.Threads Spawn(Runnable)"
							+ "\n7.Exit\nEnter your choice:\n");
					choice = scan.nextInt();
					switch (choice) {
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
						String name = scan.next();
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
						String threadName;
						int time;
						ExtendedThread[] extendedThreads = new ExtendedThread[threadCount];
						for (int i = 0; i < threadCount; i++) {
							System.out.println("Enter the name for thread " + i + " :");
							threadName = scan.next();
							System.out.println("Enter the sleep time for thread " + i + " :");
							time = scan.nextInt();
							extendedThreads[i] = new ExtendedThread(threadName);
							extendedThreads[i].setSleepTime(time);
						}
						for (ExtendedThread thread : extendedThreads) {
							thread.start();
						}
						

						runner.sleepForSeconds(12);
						/*
						 * sleepForSeconds(2); takeThreadDump("ThreadDump_1.txt"); sleepForSeconds(3);
						 * takeThreadDump("ThreadDump_2.txt"); sleepForSeconds(3);
						 * takeThreadDump("ThreadDump_3.txt");
						 */
						for (int i = 1; i <= 10; i++) {
							runner.takeThreadDump("ThreadDump_" + i + ".txt");
							runner.sleepForSeconds(4);
						}
						for (ExtendedThread thread : extendedThreads) {

							thread.stopThread();
							runner.sleepForSeconds(6);
						}
						for (ExtendedThread thread : extendedThreads) {
							thread.join();
						}
						runner.takeThreadDump("Final_ThreadDump.txt");
						scan.nextLine();
						break;
					case 6:
						System.out.println("Enter the no. of threads to spawn :");
						threadCount = scan.nextInt();
						Thread[] threads = new Thread[threadCount];
						RunnableThread[] runnableThreads = new RunnableThread[threadCount];
						for (int i = 0; i < threadCount; i++) {
							System.out.println("Enter the name for thread " + i + " :");
							threadName = scan.next();
							System.out.println("Enter the sleep time for thread " + i + " :");
							time = scan.nextInt();
							runnableThreads[i] = new RunnableThread();
							runnableThreads[i].setSleepTime(time);
							threads[i] = new Thread(runnableThreads[i]);
							threads[i].setName(threadName);

						}

						for (Thread thread : threads) {
							thread.start();
						}

						runner.sleepForSeconds(120);
						/*
						 * sleepForSeconds(2); takeThreadDump("ThreadDump_1.txt"); sleepForSeconds(3);
						 * takeThreadDump("ThreadDump_2.txt"); sleepForSeconds(3);
						 * takeThreadDump("ThreadDump_3.txt");
						 */
						for (int i = 1; i <= 10; i++) {
							runner.takeThreadDump("ThreadDump_" + i + ".txt");
							runner.sleepForSeconds(45);
						}
						for (RunnableThread thread : runnableThreads) {

							((RunnableThread) thread).stopThread();
							runner.sleepForSeconds(60);
						}

						for (Thread thread : threads) {
							thread.join();
						}

						runner.takeThreadDump("Final_ThreadDump.txt");
						break;

					case 7:
						logger.info("Exiting");
						break;
					default:
						logger.info("Invalid Choice");
					}
					
				} catch (InputMismatchException e) {
					logger.severe("Invalid input");

				} catch (InterruptedException | IOException e) {
					logger.severe(e.getMessage());
					logger.log(Level.SEVERE, "StackTrace", e);
				}

			}
		} catch (IOException | SecurityException e) {
			logger.severe(e.getMessage());
			logger.log(Level.SEVERE, "StackTrace", e);
		}finally {
			scan.close();
		}
	}

		public void printNameStatePriority(Thread thread) {
		    logger.info("Thread Name: " + thread.getName());
		    logger.info("Thread Priority: " + thread.getPriority());
		    logger.info("Thread State: " + thread.getState());
		}

	

	private void takeThreadDump(String filename) throws IOException {
		try (FileWriter writer = new FileWriter(filename)) {

			ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

			ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
			for (ThreadInfo threadInfo : threadInfos) {
				writer.write(threadInfo.toString() + "\n");
			}

			System.out.println("Thread dump saved to: " + filename);
		}
		/*
		 * for (Thread t : Thread.getAllStackTraces().keySet()) {
		 * System.out.println("Thread Name: " + t.getName() + ", ID: " + t.getId()); }
		 */
	}

	private void sleepForSeconds(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000L);

	}
}
