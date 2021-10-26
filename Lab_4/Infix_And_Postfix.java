public class Infix_And_Postfix<T> implements StackInterface<T> {
    T expression;
    T a;
    T b;
    T c;

    public Infix_And_Postfix(T expression) {
//        this.expression = expression;
    }

    public void push(T number) {

    }
    public void push(String number) {
    }

    public T pop() {
        return null;
    }

    public T peek() {
        return null;
    }

    public boolean isEmpty() {
        System.out.println("hey");
        return true;
    }

    public boolean isFull() {
        return false;
    }

    public static void main(String[] args) {
//        Infix_And_Postfix userExpression = new Infix_And_Postfix("12+")

    }
}
