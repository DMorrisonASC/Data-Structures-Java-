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

        public void insert(String key, String value) {
            int index = key.hashCode() % hashArray.size();
            System.out.println(index);

            LinkedList<String> selectedLinkedList = hashArray.get(index);

            selectedLinkedList.insert(key, value);
        }


    public void search (String key) {
        int index = key.hashCode() % hashArray.size();

        LinkedList<String> selectedLinkedList = hashArray.get(index);

        selectedLinkedList.search(key);
    }

    public void delete (String key) {
        int index = key.hashCode() % hashArray.size();

        LinkedList<String> selectedLinkedList = hashArray.get(index);

        selectedLinkedList.delete(key);
    }

    public void display () {

        for (int i = 0; i < hashArray.size(); i++) {
            LinkedList<String> selectedLinkedList = hashArray.get(i);
            System.out.println("Index " + i + " Of Hashmap: ");
            selectedLinkedList.display();
        }

    }

    public static void main(String[] args) {
        Hash<String> hashtable = new Hash<String>(5);

        hashtable.insert("Dog", "Farts");
        hashtable.insert("Dog", "Poo");
//        hashtable.delete("Dog");
////        hashtable.insert("Dogh", "Poo");
////        hashtable.insert("Doh", "Poo");
//        hashtable.search("Dog");
        hashtable.display();
    }
}
