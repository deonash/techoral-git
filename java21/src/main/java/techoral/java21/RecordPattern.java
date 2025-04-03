package techoral.java21;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

record Point(int x, int y) {}

public class RecordPattern {

	public static void main(String[] args)
	{
		Point obj = new Point(5,6);
		String description = switch(obj) {
		case Point(int x,int y) when x==y -> "Point on diagonal";
		case Point(int x,int y) -> "point at "+x + " and "+y;
		default -> "not a point";
		};
		RandomGenerator rg = RandomGeneratorFactory.of("L64X256MixRandom").create();
		for(int i =0;i<3;i++)
		System.out.println(i + description);
	}
}
