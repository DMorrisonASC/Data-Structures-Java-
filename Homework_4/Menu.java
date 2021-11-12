/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date:
    Instructor: Professor Silveyra
    Description: Develop and Implement a Program in Java for converting an Infix Expression to a Postfix Expression
    and vice versa.
 */
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
public class Menu {
    /*
    * When run, it creates 3 binary trees of type Integer, Double or Character. It shows a menu that allows user to pick a tree they want
    * to modify: Delete, insert, find or print reorder, inorder, and postorder visualization of the Tree. They can also choose to exit.
    * */
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
                            double doubleInput = userExpression.nextDouble();
                            treeDouble.insert_One(doubleInput);
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
                    System.out.println("What element to delete?: 1) Integers or 2)Doubles or 3) Character values?");
                    String typeOfInput4 = keyboard.next();
                    switch (typeOfInput4) {
                        case "1":
                            System.out.println("Enter integer: ");
                            int intToFind = userExpression.nextInt();
                            treeInt.delete(intToFind);
                            break;
                        case "2":
                            System.out.println("Enter double: ");
                            double doubleToFind = userExpression.nextDouble();
                            treeDouble.delete(doubleToFind);
                            break;
                        case "3":
                            System.out.println("Enter character: ");
                            char charToFind = userExpression.next().toUpperCase(Locale.ROOT).trim().charAt(0);
                            treeChar.delete(charToFind);
                            break;
                        default:
                            System.out.println("That's not an answer");
                    }
                    break;
                case "4":
                    System.out.println("What element to find?: 1) Integers or 2)Doubles or 3) Character values?");
                    String typeOfInput3 = keyboard.next();
                    switch (typeOfInput3) {
                        case "1" -> {
                            System.out.println("Enter integer: ");
                            int intToFind = userExpression.nextInt();
                            treeInt.findNode(intToFind);
                        }
                        case "2" -> {
                            System.out.println("Enter double: ");
                            double doubleToFind = userExpression.nextDouble();
                            treeDouble.findNode(doubleToFind);
                        }
                        case "3" -> {
                            System.out.println("Enter character: ");
                            char charToFind = userExpression.next().toUpperCase(Locale.ROOT).trim().charAt(0);
                            treeChar.findNode(charToFind);
                        }
                    }

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
