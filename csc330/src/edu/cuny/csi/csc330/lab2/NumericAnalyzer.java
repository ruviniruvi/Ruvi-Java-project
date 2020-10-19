package edu.cuny.csi.csc330.lab2;

import java.util.Arrays;

public class NumericAnalyzer {
	private int[] arr;
	private int count;
	private int min;
	private int max;
	private int range;
	private int sum;
	private int mean;
	private int median;
	private int variance;
	private int stand_div;

	public NumericAnalyzer(int[] arr) {
		this.arr = arr;
		Arrays.sort(this.arr);

	}

	public int Calculate_Size() {

		return count = arr.length;

	}

	public int Calculate_Min() {
		Arrays.sort(arr);

		return min = arr[0];

	}

	public int Calculate_Max() {
		Arrays.sort(arr);
		return max = arr[arr.length - 1];

	}

	public int Calculate_Range() {
		Arrays.sort(arr);
		return range = max - min;

	}

	public int Calculate_Sum() {
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		return sum;
	}

	public int Calculate_Mean() {

		return mean = sum / count;
	}

	public int Calculate_Median() {
		if (count % 2 != 0) {
			return median = arr[count / 2];
		} else
			return median = (arr[count / 2] + arr[(count / 2) + 1]) / 2;

	}

	public int Calculate_Variance() {
	
		int sum = 0;

		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		int mean = (int) sum / (int) arr.length;

		// Compute sum squared
		// differences with mean.
		int sqDiff = 0;
		for (int i = 0; i < arr.length; i++)
			sqDiff += (arr[i] - mean) * (arr[i] - mean);

		return variance = sqDiff / arr.length;

	}

	public int Calculate_Standarddiv() {
		stand_div = (int) Math.sqrt(variance);
		return stand_div;
	}

	public static boolean isNumeric(final String str) {

		// null or empty
		if (str == null || str.length() == 0) {
			return false;
		}

		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		return true;

	}

	public void analyze() {

		count = Calculate_Size();
		min = Calculate_Min();
		max = Calculate_Max();
		range = Calculate_Range();
		sum = Calculate_Sum();
		mean = Calculate_Mean();
		median = Calculate_Median();
		variance = Calculate_Variance();
		stand_div = Calculate_Standarddiv();
	}

	void display() {

		System.out.printf("%n%n%-20s%,10d %n", "Count:   ", count);
		System.out.printf("%-20s%,10d %n", "Min :  ", min);
		System.out.printf("%-20s%,10d %n", "Max :  ", max);
		System.out.printf("%-20s%,10d %n", "Range :  ", range);
		System.out.printf("%-20s%,10d %n", "Sum :  ", sum);
		System.out.printf("%-20s%,10d %n", "Mean : ", sum / count);
		System.out.printf("%-20s%,10d %n", "Median :  ", median);
		System.out.printf("%-20s%,10d %n", "Variance : ", variance);
		System.out.printf("%-20s%,10d %n", "Standard Deviation :", stand_div);

	}

	public static void main(String[] args) {
		
		if (args.length == 0) {
			// Display some error message … (System.err. )
			System.err.println("System Error.Pass in 1 or more positive integer number values.!");
			System.exit(1);
		}

		int[] arr = new int[args.length];
		for (int i = 0; i < args.length; i++) {

			// convert a string into a char array and check it with charactor is numeric
			if (!NumericAnalyzer.isNumeric(args[i])) {

				System.err.println("Expecting Numeric Data: " + args[i]);
				System.exit(2); // exit code for invalid data
			} else
				arr[i] = Integer.parseInt(args[i]);
		}

		NumericAnalyzer analyzer = new NumericAnalyzer(arr);

		for (int i = 0; i < args.length; i++) {
			System.out.printf("%-5d", arr[i]);
		}

		analyzer.analyze();
		analyzer.display();
		System.exit(0);

	}

}
