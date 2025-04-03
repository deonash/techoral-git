package com.techoral.java24;

sealed interface Shape permits Circle, Rectangle {
}

record Circle(double radius) implements Shape {
}

record Rectangle(double width, double height) implements Shape {
}

public class PatternMatchingSwitch {

	public static void main(String[] args) {
		Shape shape = new Circle(5);
		String description = switch(shape)
				{
					case Circle(double r) -> "circle with radius "+r;
					case Rectangle(double w, double h) -> "Rectangle with width "+ w + " and height "+h;
				};
				System.out.println(description);
	}
}
