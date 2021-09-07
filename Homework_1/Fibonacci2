/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date: 9/6/2021
    Instructor: Professor Silveyra
    Description: 
 */
import java.util.Scanner;
import java.time.format.*;
public class Fibonacci2 {

	public static void main(String[] args) {
		int num = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Fibonacci Numbers, input a number:");
		num = scan.nextInt();
		
		System.out.println("Fibonacci of " + num + " is " + fib(num));	
	}
	
	public static int fib(int num) {
		if (num == 0 || num == 1) {
			return num;
		}
		else if (num < 0) {
			System.out.println("Only use positive whole numbers!");
			return 0;
		}
		else {
			return fib(num-2) + fib(num-1);
		}
	}
}
