package ds.algos;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLIstExampale {
	
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);

		list.add(30);
		list.add(40);
		System.out.println(list);
		list.remove(0);
		System.out.println(Arrays.toString(list.toArray()));
	}

}
