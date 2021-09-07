/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date: 9/6/2021
    Instructor: Professor Silveyra
    Description: 
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci1 {

	public static void main(String[] args) {
		int number = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Fibonacci Numbers, input a number:");
		number = scan.nextInt();
		
		System.out.println("Fibonacci of " + number + " is " + fib(number));	
	}
	
	public static int fib(int num) {
		ArrayList<Integer> fibList = new ArrayList<Integer>(Arrays.asList(0,1));

		if (num == 0 || num == 1) {
			return num;
		}
		else if (num < 0) {
			System.out.println("Only use positive whole numbers!");
			return 0;
		}
		else { 
			for (int i = 2; i < num + 1; i++) {
				int finalFibNum = ((fibList.get(i-2) + fibList.get(i-1)));
				fibList.add(finalFibNum);
			}
		}
		return fibList.get(fibList.size() - 1);
	}
}
	
