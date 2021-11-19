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
            System.out.println(oneNode.key + " & " + oneNode.data); // Check if it's there
        }
        else {
            System.out.println("Ow");
            Node ptr = hashArray.get(index);     // A pointer to travel the list.
            System.out.println(ptr.key + " & " + ptr.data); // Check if it's there

            while (ptr.next != null)    // While not at the end of the list.
            {
                ptr = ptr.next;         // Move to the next node.
                System.out.println(ptr.key + " & " + ptr.data); // Check if it's there
            }

            ptr.next = oneNode;
            oneNode.next = null;

            System.out.println(oneNode.key + " & " + oneNode.data); // Check if it's there
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
        System.out.println("Key does not exist!");

    }

    public static void main(String[] args) {
        Hash<String> hashtable = new Hash<String>(5);

        hashtable.insert("Dog", "Farts");
        hashtable.insert("Dog", "Poo");
        hashtable.insert("Dog", "Boo");
        hashtable.insert("Dog", "Pow");
        hashtable.search("Cat");
    }

    public class Node
    {
        public String key;
        public T data;      // Data stored in the Node.
        public Node next;   // Pointer to next Node in the list.
    }

}
