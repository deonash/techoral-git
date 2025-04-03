package com.techoral.java24;

record Person(String name, int Age) {}

public class ScopedValues {
	
	private static final ScopedValue<String> USER = ScopedValue.newInstance();
	
	public static void main(String[] args)
	{
		Person person = new Person("Techoral",10);
		if(person instanceof Person(String name,int Age))
		{
			System.out.println("Record desconstruct");
		}
		ScopedValue.where(USER, "Techoral").run(() -> System.out.println(USER.get()));
	}

}
