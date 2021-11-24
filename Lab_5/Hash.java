/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date: 11/18/2021
    Instructor: Professor
    Description: Program 1:
    Design, Develop and Implement a Program in Java for an open hash table. The program should
    support the functions search, insert, display, and remove.
    Errors: None
 */
import java.util.ArrayList;

public class Hash<T> {
    ArrayList<LinkedList<String>> hashArray;

    public Hash(int size) {
        hashArray = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            LinkedList<String> oneLinkedList = new LinkedList<String>();
            hashArray.add(oneLinkedList);
        }
    }

//    public void insert(String key, T value) {
//        Node oneNode = new Node();
//        oneNode.key = key;
//        oneNode.data = value;
//        int index = key.hashCode() % hashArray.size();
//
//        if (hashArray.get(index) == null) {
//            hashArray.set(index, oneNode);
//            System.out.println("1st:" + oneNode.key + " & " + oneNode.data); // Check if it's there
//        }
//        else {
//            System.out.println("Ow");
//            Node ptr = hashArray.get(index);     // A pointer to travel the list.
//
//            while (ptr != null)    // While not at the end of the list.
//            {
//                if (ptr.key.equals(key)) {
//                    ptr.data = value;
//                    return;
//                }
//
//                if (ptr.next == null) {
//                    ptr.next = oneNode;
//                    oneNode.next = null;
//                    return;
//                }
//                ptr = ptr.next;         // Move to the next node.
//            }
//        }
//    }

        public void insert(String key, String value) {
            int index = key.hashCode() % hashArray.size();

            LinkedList<String> selectedLinkedList = hashArray.get(index);

            selectedLinkedList.insert(key, value);
            selectedLinkedList.display();
        }


    public void search (String key) {

    }

    public void delete (String key) {

    }

    public static void main(String[] args) {
        Hash<String> hashtable = new Hash<String>(5);

        hashtable.insert("Dog", "Farts");
        hashtable.insert("Dog", "Poo");
        hashtable.insert("Dogh", "Poo");
        hashtable.insert("Doh", "Poo");
    }

//    public class Node
//    {
//        public String key;
//        public T data;      // Data stored in the Node.
//        public Node next;   // Pointer to next Node in the list.
//    }

}
