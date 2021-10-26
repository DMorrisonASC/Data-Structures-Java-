
public class Infix_And_Postfix implements StackInterface {
    String expression;
    String a;
    String b;
    String c;

    public Infix_And_Postfix(String expression) {
        this.expression = expression;
    }

    public void push(String number) {
        System.out.println("Up");
    }

    public void push( number) {
        
    }

    public String pop() {
        return "Yes";
    }

    public String peek() {
        return "Yes";
    }

    public boolean isEmpty() {
        System.out.println("hey");
        return true;
    }

    public boolean isFull() {
        return false;
    }

    public static void main(String[] args) {
        Infix_And_Postfix userExpression = new Infix_And_Postfix("12+");

    }
}
