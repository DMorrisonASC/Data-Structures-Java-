import java.util.ArrayList;

public class Adjacency_List {
    ArrayList<LinkedList<Integer>> hashArray;

    public Adjacency_List(int size) {
        hashArray = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            LinkedList<String> oneLinkedList = new LinkedList<String>();
            hashArray.add(oneLinkedList);
        }
    }

    public void insert(String key, int value) {
        int index = Integer.parseInt(key);

        LinkedList<Integer> selectedLinkedList = hashArray.get(index);

        selectedLinkedList.insert(key, value);
    }


    public void search (String key) {
        int index = key.hashCode() % hashArray.size();

        LinkedList selectedLinkedList = hashArray.get(index);

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
        Adjacency_List hashtable = new Adjacency_List(5);

        hashtable.insert("Dog", "Farts");
        hashtable.insert("Dog", "Poo");
//        hashtable.delete("Dog");
////        hashtable.insert("Dogh", "Poo");
////        hashtable.insert("Doh", "Poo");
        hashtable.search("Dog");
        hashtable.display();
    }

}
