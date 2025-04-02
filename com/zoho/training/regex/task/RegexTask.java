package com.zoho.training.regex.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.zoho.training.exceptions.TaskException;
import com.zoho.training.utility.Util;

public class RegexTask {

	public boolean validatePhoneNumber(String phoneNumber) throws TaskException {
		Util.validateInput(phoneNumber, "Phone Number");
		String regex = "^[789]\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);

		return matcher.matches();
	}

	public boolean validateString(String string) throws TaskException {
		Util.validateInput(string, "String");
		String regex = "[A-Za-z0-9]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);

		return matcher.matches();
	}

	public boolean validateEmail(String email) throws TaskException {
		Util.validateInput(email, "Email");
		String regex = "^[A-Za-z0-9]+(?:\\.[A-Za-z0-9]+)*@[a-z0-9\\-]+\\.[a-z]+$\n";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}

	public boolean checkStartsWith(String string, String matchingString) throws TaskException {
		Util.validateInput(string, "String");
		Util.validateInput(matchingString, "Matching String");
		String regex = "^" + matchingString + ".*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);

		return matcher.matches();

	}

	public boolean checkExactMatch(String string, String matchingString) throws TaskException {
		Util.validateInput(string, "String");
		Util.validateInput(matchingString, "Matching String");
		String regex = matchingString;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);

		return matcher.matches();

	}

	public boolean checkContains(String string, String matchingString) throws TaskException {
		Util.validateInput(string, "String");
		Util.validateInput(matchingString, "Matching String");
		String regex = ".*" + matchingString + ".*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);

		return matcher.matches();

	}

	public boolean checkEndsWith(String string, String matchingString) throws TaskException {
		Util.validateInput(string, "String");
		Util.validateInput(matchingString, "Matching String");
		String regex = ".*" + matchingString + "$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);

		return matcher.matches();

	}

	public boolean checkMatch(String matchingString, String string) throws TaskException {
		Util.validateInput(string, "String");
		Util.validateInput(matchingString, "Matching String");
		String regex = "(?i)" + matchingString;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);

		return matcher.matches();

	}

	public boolean checkRange(String string, int start, int end) throws TaskException {
		Util.validateInput(string, "String");
		Util.validateInput(start, "Start Value");
		Util.validateInput(end, "End Value");
		String regex = "^.{" + start + "," + end + "}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);

		return matcher.matches();
	}

	public Map<String, Integer> getMatchingStringWithIndex(List<String> stringList, List<String> matchingStringList)
			throws TaskException {
		Util.validateInput(matchingStringList, "MatchingStringList");
		Util.validateInput(stringList, "String List");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String string : stringList) {
			for (String match : matchingStringList) {
				if (string.matches(match)) {
					map.put(match, stringList.indexOf(string));
					break;
				}
			}
		}
		return map;
	}

	public List<String> extractHtmlTags(String html) throws TaskException {
		Util.validateInput(html, "Html Code");
		String regex = "</?[a-z]+>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(html);

		List<String> tagList = new ArrayList<>();
		while (matcher.find()) {
			tagList.add(matcher.group());
		}

		return tagList;
	}

}
