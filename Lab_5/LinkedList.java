/*
 *   A Linked List Class for implementing
 *   some simple recursive functions.
 *
 *   This program uses a singly linked list without sentinel.
 *   Also note that this is a generic class.
 */
public class LinkedList <T>
{
    private Node header = null;  // Pointer to the head of the list.

    public LinkedList()
    {
        header = new Node();
        header.key = "-99";
        header.next = null;
    }
    /*
     *   Enter a data item at the front of the list.
     */
    public void insert(String key, T value)
    {
        Node ptr = header;

        Node oneNode = new Node();     // Construct a new node - ptr points to it.

        oneNode.data = value;           // New node's data is the parameter item.
        oneNode.key = key;

        while (ptr.next != null) {
            if (ptr.next.key.equals(key)) {
                ptr.next.data = value;
                return;
            }
            ptr = ptr.next;
        }

        ptr.next = oneNode;
        oneNode.next = null;
    }
    /*
     *    lengthRecursive()
     *
     *    Return the length of the list that starts
     *    at the Node pointed to by ptr.
     */
    public int lengthRecursive(Node ptr)
    {
        if (ptr != null) {
            return lengthRecursive(ptr.next) + 1;
        }

        else return 0;
    }
    /*
     *   Display the contents of the linked list.
     */
    public void display()
    {
        Node    ptr = header;  // Pointer to traverse the list.
        ptr = ptr.next; // Move pointer from header because its data is null
        System.out.print("Header -> ");

        while (ptr != null) {    // While not at the end of the list ...
            T data = ptr.data;              // Get data of current node.
            String key = ptr.key;              // Get data of current node.
            System.out.println(key + " " + data.toString()); // Print the data.
            ptr = ptr.next;                 // Move to the next node.
            System.out.print("->");
        }
        System.out.println();

    }

    public void search() {

    }
    /*
     *    Inner Class - Node objects for a singly linked list.
     *
     */
    public class Node
    {
        public String key;
        public T data;      // Data stored in the Node.
        public Node next;   // Pointer to next Node in the list.
    }
}