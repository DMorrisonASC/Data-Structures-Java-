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
            System.out.println("1.\tInsert an element");
            System.out.println("2.\tInsert ten elements");
            System.out.println("3.\tDelete an element");
            System.out.println("4.\tFind an element");
            System.out.println("5.\tPrint preorder, inorder, and postorder visualization of the Tree");
            System.out.println("6.\tExit");

            String choice = scan.next();

            Scanner userExpression = new Scanner(System.in);

            switch (choice) {
                case "1":
//                    System.out.println("1) Insert one element\n2) Randomly populates your tree with 10 elements");


//                    tree.insert(11);
//                    tree.insert(10);
//                    tree.insert(15);
//                    tree.insert(1);
//                    tree.insert(77);
//                    tree.insert(9);


                    break;
                    case "2":
//                    System.out.println("1) Insert one element\n2) Randomly populates your tree with 10 elements");


//                    tree.insert(11);
//                    tree.insert(10);
//                    tree.insert(15);
//                    tree.insert(1);
//                    tree.insert(77);
//                    tree.insert(9);


                    break;
                case "3":
                    System.out.println("What element to delete?");
                    int userInput = userExpression.nextInt();
                    tree.delete(userInput);
                    break;
                case "4":
                    tree.findNode(20);
                    break;
                case "5":
                    tree.printAllOrders();
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
