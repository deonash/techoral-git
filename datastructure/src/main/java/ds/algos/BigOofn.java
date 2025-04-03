package ds.algos;

public class BigOofn {

	public void log(int[] numbers) {
		// o(2)
		System.out.println(numbers[0]);
		System.out.println(numbers[0]);

		// O(n)
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

		// O(n2)
		for (int first : numbers) {
			System.out.println(numbers[first]);
			for (int second : numbers) {
				System.out.println(numbers[second]);
			}
		}
		
		// O(n3)
		for (int first : numbers) {
			System.out.println(numbers[first]);
			for (int second : numbers) {
				System.out.println(numbers[second]);
				for (int third : numbers) {
					System.out.println(numbers[third]);
				}
			}
		}
	}
	
	// Space complexity
	
	public void greeting(String[] names)
	{
		// O(n) space
		String[] copy = new String[names.length];
		
		// O(1)
		for(int i = 0;i<names.length;i++)
		{
			System.out.println(names[i]);
		}
	}
	
}
