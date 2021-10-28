import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String output = "";

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
                    System.out.println("Loading...");
                    infix_to_postfix stack = new infix_to_postfix();
                    output = stack.conversion("+*");
                    System.out.println("The output is: " + output);
                    break;
                case "2":
                    System.out.println("Yes");
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

//    public static String infix_to_postfix(String expression) {
//        String output = "";
//        Infix_And_Postfix<String> operationsStack = new Infix_And_Postfix<String>();
////        for (int i = 0; i < expression.length(); i++) {
////            expressionStack
////        }
////        for (char element: expression.toCharArray()) {
////            operationsStack.push(Character.toString(element));
////        }
//            operationsStack.push("A");
//            operationsStack.outPut();
//
//        return output;
//    }

    public String postfix_to_infix(String expression) {

        return "No";
    }
}
