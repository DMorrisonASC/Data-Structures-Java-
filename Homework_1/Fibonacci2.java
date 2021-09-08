/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date: 9/6/2021
    Instructor: Professor Silveyra
    Description: 
 */
import java.util.Scanner;
//import java.time.format.*;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
public class Fibonacci2 {

	public static void main(String[] args) throws ParseException {
		int num = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Fibonacci Numbers, input a number:");
		num = scan.nextInt();
	    long startTime = System.nanoTime();
		
		System.out.println("Fibonacci of " + num + " is " + fib(num));	
	 
	    long endTime = System.nanoTime();
	 
	    long lengthInNano = (endTime - startTime); 
	     
	    long lengthInMillis = TimeUnit.NANOSECONDS.toMillis(lengthInNano);  //Total execution time in mills seconds
	    System.out.println("Length in nano-seconds " + lengthInNano);
	    System.out.println("Length in milli-seconds " + lengthInMillis);
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
