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
        BTS tree = new BTS();

        System.out.println("Welcome to Infix & Postfix converter: \n----------------\n");

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("1.\tConvert infix to postfix");
            System.out.println("2.\tConvert postfix to infix");
            System.out.println("3.\tExit");
            System.out.println();

            String input = scan.next();

            Scanner userExpression = new Scanner(System.in);

            switch (input) {
                case "1":
                    tree.insert(20);
                    tree.insert(10);
                    tree.insert(15);
                    tree.delete(15);
                    tree.inorder();
                    break;
                case "2":

                    break;
                case "3":
                    System.out.println("Exiting...");
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Use a number from 1-3 to selection an option or exit");
            }
        }
    }
}
