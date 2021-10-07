import java.io.*;
import java.util.Scanner;
public class TesterSortedDoubleList {
    public static void main(String args[]) throws Exception {

        String input;
        Scanner one = new Scanner(System.in);

        input = one.nextLine();
//        if(val == 1){
//            System.out.println("Integer");
//        }
//        else if(val == 2){
//            System.out.println("String");
//        }
//        else{System.out.println("error");}
//
//        int val2 = test2(input);
//        String solution = (val2==1) ? "Integer 2" : "String 2";
        int val2 = test2(input);

        if (val2 == 1) {
            switch (input) {
                case "1":
                    System.out.println("Insert element");
                    break;
                case "2":
                    System.out.println("Print list size");
                    break;
                case "3":
                    System.out.println("Is the list empty?");
                    break;
                case "4":
                    System.out.println("Print first element");
                    break;
                case "5":
                    System.out.println("5");
                    break;
                case "6":
                    System.out.println("6");
                    break;
                case "7":
                    System.out.println("7");
                    break;
                case "8":
                    System.out.println("8");
                    break;
                case "9":
                    System.out.println("9");
                    break;
                default:
                    System.out.println("That's Not a number from 1-9!");
            }
        }

        else {
            System.out.println("Use a number from 1-9 or -1 to quit!:");
        }
    }
/*
    public static int test(String input){  //Not a good way to do things!!!
        int ch1;
        String ch2;
        try {
            ch1 = Integer.parseInt(input);
            return 1;
        }
        catch (NumberFormatException e) {
        }

        try {
            ch2 = String.valueOf(input);
            return 2;
        } catch (NumberFormatException e) {
        }
        return 0;

    }
 */

    public static int test2(String input){ //Good way to do things
        if(input.matches("-?(0|[1-9]\\d*)")){
            return 1;
        }
        else{
            return 2;
        }
    }
}
