package com.techoral.lang;

import java.util.ArrayList;

/**
 * https://techoral.com
 * 
 */
public class ContextualKeywords {

	public static void main(String[] args) {
		String var = "MONDAY"; // var is a reserved keyword
		String result = switch (var)

		{
		case "MONDAY", "FRIDAY", "SUNDAY" -> "WeekEnd";
		case "TUESDAY" -> "Working Day";
		default -> {
			yield "Midweek";
		}
		};

		System.out.println(result);
		
		printhello();

	}

	private static void printhello() {
		var list = new ArrayList<String>();
		list.add("James");
		list.add("techoral");
		list.add("bond");
		
		System.out.println(list);
	
	}

}
