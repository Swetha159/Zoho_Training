package com.zoho.training.regex.runner;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import com.zoho.training.arraylist.task.ArrayListTask;
import com.zoho.training.exceptions.TaskException;
import com.zoho.training.regex.task.RegexTask;
import com.zoho.training.utility.Util;

public class RegexRunner {

	private static final Logger logger;

	static {
		try {
			logger = Util.getLogger(RegexRunner.class);
		} catch (IOException e) {
			throw new RuntimeException("Failed to initialize logger", e);
		}
	}

	public static void main(String args[]) {

		RegexTask task = new RegexTask();
		ArrayListTask list = new ArrayListTask();
		int choice = 0;
		try (Scanner scan = new Scanner(System.in)) {
			while (choice != 12) {
				try {
					System.out.println("\n1.Validate Phone Number" + "\n2.Validate String" + "\n3.Check Starts With"
							+ "\n4.Check Ends With" + "\n5.Check Contains " + "\n6.Check Exact match"
							+ "\n7.Case Insensitive Match" + "\n8.Validate Email" + "\n9.Check Range "
							+ "\n10.Get Matching String with index of string list" + "\n11.Extract Html Tags"
							+ "\n12.Exit" + "\nEnter your choice:");

					choice = scan.nextInt();
					scan.nextLine();
					switch (choice) {
					case 1:
						System.out.println("Enter the Phonenumber :");
						String phoneNumber = scan.next();
						if (task.validatePhoneNumber(phoneNumber)) {
							logger.info("PhoneNumber Pattern matched");
						} else {
							logger.info("PhoneNumber Pattern not matched");
						}
						break;
					case 2:
						System.out.println("Enter a string:");
						String string = scan.nextLine();
						if (task.validateString(string)) {
							logger.info("AlphaNumeric Pattern matched");
						} else {
							logger.info("AlphaNumeric Pattern not matched");
						}
						break;
					case 3:
						System.out.println("Enter the input string:");
						string = scan.nextLine();
						System.out.println("Enter the matching string:");
						String matchingString = scan.nextLine();
						if (task.checkStartsWith(string, matchingString)) {
							logger.info(string + " starts with " + matchingString);
						} else {
							logger.info(string + " doesn't start with " + matchingString);
						}
						break;
					case 4:
						System.out.println("Enter the input string:");
						string = scan.nextLine();
						System.out.println("Enter the matching string:");
						matchingString = scan.nextLine();
						if (task.checkEndsWith(string, matchingString)) {
							logger.info(string + " ends with " + matchingString);
						} else {
							logger.info(string + " doesn't end with " + matchingString);
						}
						break;
					case 5:
						System.out.println("Enter the input string:");
						string = scan.nextLine();
						System.out.println("Enter the matching string:");
						matchingString = scan.nextLine();
						if (task.checkContains(string, matchingString)) {
							logger.info(string + " contains " + matchingString);
						} else {
							logger.info(string + " doesn't contain " + matchingString);
						}
						break;
					case 6:
						System.out.println("Enter the input string:");
						string = scan.nextLine();
						System.out.println("Enter the matching string:");
						matchingString = scan.nextLine();
						if (task.checkExactMatch(string, matchingString)) {
							logger.info(string + " exactly matches " + matchingString);
						} else {
							logger.info(string + " doesn't exactly match with " + matchingString);
						}
						break;
					case 7:

						List<String> stringList = list.getList();
						System.out.println("Enter no. of strings:");
						int count = scan.nextInt();
						scan.nextLine();
						String[] stringArray = new String[count];
						for (int i = 0; i < count; i++) {
							System.out.print("Enter the String:");
							stringArray[i] = scan.next();
						}
						list.addObjects(stringArray, stringList);
						scan.nextLine();
						System.out.println("Enter the matching string:");
						matchingString = scan.nextLine();
						for (String item : stringList) {
							if (task.checkMatch(matchingString, item)) {
								logger.info(item + " matches " + matchingString);
							} else {
								logger.info(item + " matches " + matchingString);
							}
						}
						break;
					case 8:

						System.out.println("Enter the email:");
						String email = scan.nextLine();
						if (task.validateEmail(email)) {
							logger.info("Email Pattern matched");
						} else {
							logger.info("Email Pattern not matched");
						}
						break;

					case 9:
						stringList = list.getList();
						System.out.println("Enter no. of strings:");
						count = scan.nextInt();
						stringArray = new String[count];
						for (int i = 0; i < count; i++) {
							System.out.print("Enter the String:");
							stringArray[i] = scan.next();
						}
						list.addObjects(stringArray, stringList);
						System.out.println("Enter starting range:");
						int start = scan.nextInt();
						System.out.println("Enter ending range:");
						int end = scan.nextInt();
						for (String item : stringList) {
							if (task.checkRange(item, start, end)) {
								logger.info(item + " is in the specified range");
							} else {
								logger.info(item + " is not in the specified range ");
							}
						}
						break;
					case 10:
						stringList = list.getList();
						System.out.println("Enter no. of strings:");
						count = scan.nextInt();
						stringArray = new String[count];
						for (int i = 0; i < count; i++) {
							System.out.print("Enter the String:");
							stringArray[i] = scan.next();
						}
						list.addObjects(stringArray, stringList);
						List<String> matchingStringList = list.getList();
						System.out.println("Enter no. of strings:");
						count = scan.nextInt();
						stringArray = new String[count];
						for (int i = 0; i < count; i++) {
							System.out.print("Enter the String:");
							stringArray[i] = scan.next();
						}
						list.addObjects(stringArray, matchingStringList);
						Map<String, Integer> map = task.getMatchingStringWithIndex(stringList, matchingStringList);
						logger.info(map.toString());
						break;
					case 11:
						System.out.println("Enter the Html tags :");
						String html = scan.nextLine();
						List<String> tags = task.extractHtmlTags(html);
						logger.info("The Html Tags are :");
						for (String tag : tags) {
							logger.info(tag);
						}
						break;
					case 12:
						logger.info("Exiting");
						
						break;
					default:
						logger.info("Invalid Choice");
						

					}

				} catch (InputMismatchException e) {
					logger.severe("Invalid input");

				} catch (TaskException e) {
					logger.severe(e.getMessage());
					scan.nextLine();
				}

			}
		}
	}
}
