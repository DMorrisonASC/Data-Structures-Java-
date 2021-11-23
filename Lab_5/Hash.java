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
    ArrayList<Node> hashArray;
    ArrayList<Integer> intArray;
//    private Node header = null;  // Pointer to the head of the list.
//    public Node header.data;  // Pointer to the head of the list.

    public Hash(int size) {
//        header = null;
        hashArray = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            hashArray.add(null);
        }
    }

    public void insert(String key, T value) {
        Node oneNode = new Node();
        oneNode.key = key;
        oneNode.data = value;
        int index = key.hashCode() % hashArray.size();

        if (hashArray.get(index) == null) {
            hashArray.set(index, oneNode);
            System.out.println("1st:" + oneNode.key + " & " + oneNode.data); // Check if it's there
        }
        else {
            System.out.println("Ow");
            Node ptr = hashArray.get(index);     // A pointer to travel the list.

            while (ptr != null)    // While not at the end of the list.
            {
                if (ptr.key.equals(key)) {
                    ptr.data = value;
                    return;
                }

                if (ptr.next == null) {
                    ptr.next = oneNode;
                    oneNode.next = null;
                    return;
                }
                ptr = ptr.next;         // Move to the next node.
            }
        }
    }

    public void search (String key) {
        int index = key.hashCode() % hashArray.size();
        Node ptr = hashArray.get(index);     // A pointer to travel the list.

        if (hashArray.get(index) != null) {
            while (ptr != null) {
                if (ptr.key.equals(key)) {
                    System.out.println("Key: " + ptr.key + ", Value: " + ptr.data);
                    return;
                }
                ptr = ptr.next;
            }
        }
        else {
            System.out.println("Key does not exist!");
        }
    }

    public void delete (String key) {
        int index = key.hashCode() % hashArray.size();
        Node ptr = hashArray.get(index);     // A pointer to travel the list.

//        if (hashArray.get(index) != null) {
//            while (ptr != null) {
//                if (hashArray.get(index).key.equals(key)) {
////                    Check if 1st node is the only one in the list
//                    if (hashArray.get(index).next != null) {
//                        ptr.next = ptr.next.next;
//
//                        ptr.next.next = null;
//                        System.out.println("delete1");
//                        return;
//                    } else {
////                        hashArray.clear();
//                        System.out.println("delete2");
//
//                    }
//                }
//                else {
//                    if (ptr.next != null) {
//                        if (ptr.next.key.equals(key)) {
//                            ptr.next = ptr.next.next;
//
//                            ptr.next.next = null;
////                        System.out.println(delet);
//                            return;
//                        }
//                    }
//                    ptr = ptr.next;
//                }
//            }
//        }
//        else {
//            System.out.println("Key does not exist!");
//        }
        if (hashArray.get(index) == null) {
            System.out.println("List is empty. Key does not exist!");
        }

        else {



        }
    }
    public static void main(String[] args) {
        Hash<String> hashtable = new Hash<String>(5);

//        hashtable.insert("Dog", "Farts");
//        hashtable.insert("Dog", "Poo");
//        hashtable.insert("Dogs", "Boo");
//        hashtable.insert("Dogs", "Pow");
//        hashtable.insert("Dogt", "Pow");

        hashtable.insert("Dog", "Farts");
//        hashtable.delete("Dog");
        hashtable.insert("Dog", "Poo");
        hashtable.search("Dog");
        hashtable.search("D");

//        hashtable.search("Cat");
    }

    public class Node
    {
        public String key;
        public T data;      // Data stored in the Node.
        public Node next;   // Pointer to next Node in the list.
    }

}
