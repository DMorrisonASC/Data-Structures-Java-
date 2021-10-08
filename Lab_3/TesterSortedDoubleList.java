import java.io.*;
import java.util.Scanner;
public class TesterSortedDoubleList {
/*
    The tester method should first display a menu that displays the types of lists that you can use:
1.	String
2.	Integer

Read that information (make sure that the user picks a valid option) and then display a different menu. Make sure that the user enters the proper value.
1.	Insert element
2.	Print list size
3.	Is the list empty?
4.	Print first element
5.	Print last element
6.	Count elements with a particular value
7.	Remove first
8.	Remove last
9.	Remove all elements with a particular value
 */
    public static void main(String args[]) throws Exception {
        SortedDoubleList<Integer> IntergerList = new SortedDoubleList<Integer>();

        String input;
        Scanner one = new Scanner(System.in);
//        input = one.nextLine();
//        String val2 = test2(input);

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("""
                    1.\tInsert element
                    2.\tPrint list size
                    3.\tIs the list empty?
                    4.\tPrint first element
                    5.\tPrint last element
                    6.\tCount elements with a particular value
                    7.\tRemove first
                    8.\tRemove last
                    9.\tRemove all elements with a particular value9
                    10.\tOutput all node values
                    -1.\tExit the program.
                    """);
            input = one.nextLine();
            int val2 = test2(input);
            if (val2 == 1) {
                switch (input) {
                    case "1":
                        break;
                    case "2":
                        System.out.println("Print list size");
                        System.out.println(IntergerList.size());
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
//                        int eraseThisInput;
//                        Scanner scan = new Scanner(System.in);
//                        eraseThisInput = scan.nextInt();
                        break;
                    case "9":
//                        int eraseThisInput;
//                        Scanner scan = new Scanner(System.in);
//                        eraseThisInput = scan.nextInt();
                        IntergerList.erase(input);
                        break;
                    case "10":
                        IntergerList.checkLinkedList();
                        break;
                    case "-1":
                        System.out.println("Exiting...");
                        keepGoing = false;
                        break;
                    default:
                        System.out.println("That's Not a number from 1-9!");
                }
            } else {
                System.out.println("Use a number from 1-9 or -1 to quit!:");
            }
        }
    }

    public static int test2(String input){ //Good way to do things
        if(input.matches("-?(0|[1-9]\\d*)")){
            return 1;
        }
        else{
            return 2;
        }
    }
}
