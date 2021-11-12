import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date:
    Instructor: Professor Silveyra
    Description: Develop and Implement a Program in Java for converting an Infix Expression to a Postfix Expression
    and vice versa.
 */
public class Menu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BTS<Integer> treeInt = new BTS<Integer>();
        BTS<Double> treeDouble = new BTS<Double>();
        BTS<Character> treeChar = new BTS<Character>();
        Random rand = new Random();


        System.out.println("Welcome to Infix & Postfix converter: \n----------------\n");

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("1.\tInsert an element");
            System.out.println("2.\tInsert ten elements");
            System.out.println("3.\tDelete an element");
            System.out.println("4.\tFind an element");
            System.out.println("5.\tPrint preorder, inorder, and postorder visualization of the Tree");
            System.out.println("6.\tExit");

            String choice = scan.next();

            Scanner userExpression = new Scanner(System.in);
            Scanner keyboard = new Scanner(System.in);

            switch (choice) {
                case "1":
                    System.out.println("Are you inserting an 1) Int, 2)Double or 3) Character values?");
                    String typeOfInput = keyboard.next();
                    switch (typeOfInput) {
                        case "1":
                            System.out.println("Insert int:");
                            int userInput = userExpression.nextInt();
                            treeInt.insert_One(userInput);
                            break;
                        case "2":
                            System.out.println("Insert double:");
                            break;
                        case "3":
                            System.out.println("Insert character:");
                            char userInputChar = userExpression.next().toUpperCase(Locale.ROOT).charAt(0);
                            treeChar.insert_One(userInputChar);

                            break;
                        default:
                            System.out.println("Not an answer");
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Inserting 10 random element. Are you inserting 1) Integers or 2)Doubles or 3) Character values?");
                    String typeOfInput2 = keyboard.next();
                    switch (typeOfInput2) {
                        case "1":
//                            treeInt.insert_ten(typeOfInput2);
                            for (int i = 0; i < 10; i++) {
                                int randInt = rand.nextInt(101);
                                treeInt.insert_One(randInt);
                            }
                            break;
                        case "2":
                            for (int i = 0; i < 10; i++) {
                                double randDouble = 100 * rand.nextDouble();
                                treeDouble.insert_One(randDouble);
                            }
                            break;
                        case "3":
                            for (int i = 0; i < 10; i++) {
                                char c = (char) ( 65 + rand.nextInt(26));
                                treeChar.insert_One(c);
                            }

                            break;
                        default:
                            System.out.println("Not an answer");
                            break;
                    }
                    break;
                case "3":
                    System.out.println("What element to delete?");
                    int userInput = userExpression.nextInt();
//                    treeInt.delete(userInput);
                    break;
                case "4":
//                    treeInt.findNode(20);
                    break;
                case "5":
                    System.out.println("Integer Tree:");
                    treeInt.printAllOrders();
                    System.out.println("Double Tree:");
                    treeDouble.printAllOrders();
                    System.out.println("Character Tree:");
                    treeChar.printAllOrders();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Use a number from 1-5 to selection an option or exit");
            }
        }
    }
}
