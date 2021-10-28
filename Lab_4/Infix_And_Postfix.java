/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date:
    Instructor: Professor Silveyra
    Description: Develop and Implement a Program in Java for converting an Infix Expression to a Postfix Expression
    and vice versa.
 */
public class Infix_And_Postfix<T> implements StackInterface<T> {
    private Node head;
    public class Node {
        private T node_value;
        Node next;

        public Node(T obj) {
            node_value = obj;
            next = null;
        }
        public T value() {
            return node_value;
        }
    }
//    Constructor
    public Infix_And_Postfix() {
        Node head = new Node(null);
    }

    public void push(T operation) {
        Node element = new Node(operation);
//
//        if (isEmpty()) {
//            head.next = element;
//        }
//        else {
//            element.next = head.next;
//            head.next = element;
//        }
        element.next = head;         // New node points to current front item.

        head = element;              // The new node becomes the front node.
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        else {
//            Node element = head.next;
//            head.next = element.next;
//            element.next = null;
//            return element.value();
            Node element = head;
            head = head.next;
            element.next = null;
            return element.node_value;
        }
    }

    public T peek() {
        return head.next.value();
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public void printOutPut() {
        Node traverse = head;

        while (traverse != null) {
            System.out.println(traverse.node_value);
            traverse = traverse.next;
        }
    }

    public boolean isFull() {
        return false;
    }

}
