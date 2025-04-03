package com.techoral.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * www.techoral.com
 */
public class UnmodifiableList {

	public static void main(String[] args) {
		List<String> names = new ArrayList();
		names.add("techoral");
		names.add("com");
		names.add("http");

		System.out.println(names);

//		names = Collections.unmodifiableList(names);
//
//		System.out.println(names);

		// names.add("modify");

		names = List.of("tech", "oral", "com");
		System.out.println(names);

		// names.add("modify");

		Set<String> values = Set.of("tch", "mch", "th");
		System.out.println(values);
		// values.add("me");

		Map<Integer, String> mapme = Map.of(1, "one", 2, "two", 3, "three");
		System.out.println(mapme);

	}

}
