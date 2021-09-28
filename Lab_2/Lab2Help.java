/*
 *   A Linked List Class for implementing
 *   some simple recursive functions.
 *
 *   This program uses a singly linked list without sentinel.
 *   Also note that this is a generic class.
 */
public class Lab2Help <T extends Comparable<T>>
{
    private Node header = null;  // Pointer to the head of the list.
    //private Node tail =null;
    public Lab2Help()
    {
        header = null;
    }

    public void addToFront(T item)
    {
        Node n = new Node();     // Construct a new node - ptr points to it.

        n.data = item;           // New node's data is the parameter item.
        n.next = header;         // New node points to current front item.

        header = n;              // The new node becomes the front node.
    }

    public void addToEnd(T item){
      Node n = new Node();      // Construct a new node - ptr points to it.
      n.data = item;            // New node's data is the parameter item.
      n.next = null;            // it points to null because it's added to the end of the list

      Node temp = header;       // temp prevents data from being lost by acting as a placeholder for header

      while(temp.next != null){ // Keep looking for end of the list
        temp = temp.next;

      }
      temp.next = n;            // set new node of "n" to the end of the list

    }

    public void insertFirst(T val) {
        Node n = new Node();     // Construct a new node - ptr points to it.

        n.data = val;           // New node's data is the parameter item.
        n.next = header;         // New node points to current front item.

        header = n;              // The new node becomes the front node.
    }

    public void  insertLast(T val)  {
        Node temp = header;

        while(temp.next != null){
            temp = temp.next;

        }
        temp.data =  val;
        temp.next = null;

    }
    public void insertIndex(T val, int inx)  {
        Node temp = header;
        for (int i = 1; i < inx; i++) {
            temp = temp.next;
        }
        temp.data = val;
    }
    public void  removeFirst()  {
        header = header.next;
    }
    public void  removeLast()  {
        Node temp = header;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }
    public void removeIndex(int inx)  {
        Node temp = header;
        if (inx == 1) {
            header = header.next;
        }
        else {
//        Stop right before intended index
            int count = 1;
            while (count < inx-1) {
                temp = temp.next;
                count++;
            }
        }
        Node removeNode = temp.next;
        temp.next = temp.next.next;
        removeNode.next = null;
    }

    public int searchByValue(T val) {
        Node ptr = header;  // Pointer to traverse the list.
        int count = 0;
        String valString = val.toString();

        while (ptr.next != null) {    // While not at the end of the list ...
            count++;
            T data = ptr.data;              // Get data of current node.
            String dataString = data.toString(); // Convent data to string

            if (dataString.equals(valString)) {  // If it finds the node, return its index(count)
                return count;
            }

            ptr = ptr.next;                 // Move to the next node.
        }
        return -1; // Return -1 if it is not found.
    }

    public int searchByIndex(int inx) {
        Node ptr = header;              // Pointer to traverse the list.
        for (int i = 1; i < inx; i++) { // Runs until it reaches the inputted index & traverses the list
            ptr = ptr.next;
        }
        return Integer.parseInt(ptr.data.toString());
    }

    public boolean Update(int inx, T newVal) {
        Node ptr = header; // Pointer to traverse the list.

        for (int i = 1; i < inx; i++) { // Traverse list x amount of times until it finds the index of the item
            ptr = ptr.next;
        }

        if (ptr != null) { // If there is an item present, update it
            ptr.data = newVal;
            return true;
        }
        else { // Else return false
            return false;
        }
    }

    public int UpdateAll (T oldVal, T newVal) {
        Node ptr = header; // Pointer to traverse the list.
        String oldValString = oldVal.toString(); // Get string of old value
        int count = 0; // counter for how many times an item is present

        while (ptr !=  null) { // Traverse the whole list
            String ptrDataString = ptr.data.toString(); // convert value of current node to a string
            if (oldValString.equals(ptrDataString)) { // Compare them and if they are the same. Replace old value with new one
                ptr.data = newVal;
                count++; // Increase count by 1
            }
            ptr = ptr.next; // move to next node
        }
        return count; // return the frequency that old value appeared
    }

    public String StringToString () {
        Node    ptr = header;  // Pointer to traverse the list.
        StringBuilder listOfValues = new StringBuilder("");

        while (ptr != null) {    // While not at the end of the list ...
            T data = ptr.data;              // Get data of current node.
            listOfValues.append(ptr.data.toString()).append("\n"); // Append new strings  + a newline to the list
            ptr = ptr.next;                 // Move to the next node.
        }

        return listOfValues.toString();
    }

    public static void main(String[] args)
    {
        // Construct lists of Strings, Integers, and Boolean.

        Lab2Help<String> strList = new Lab2Help<String>();
        Lab2Help<Integer> intList = new Lab2Help<Integer>();
        Lab2Help<Boolean> boolList = new Lab2Help<Boolean>();

        // Now populate the lists.

        strList.addToFront("6) I'm first");
        strList.addToFront("5) No you're not!");
        strList.addToFront("4) Move down buddy");
        strList.addToFront("3) Hey make room for me");
        strList.addToFront("2) Move over I'm coming in");
        strList.addToFront("1) They'll let anyone in this list");

        // Create a list with 68 integers.

        for (int i = 0; i < 20; i++)
            intList.addToFront(i);
        for (int i = 20; i < 68; i++)
            intList.addToEnd(i);

        boolList.addToFront(true);
        boolList.addToFront(false);

//        Testing more methods
        strList.insertIndex("I'm Last?", 2);
        strList.removeFirst();
        strList.removeLast();
        strList.removeIndex(3);
        System.out.println(intList.searchByValue(20));
        System.out.println(intList.searchByIndex(2));
        System.out.println(strList.Update(2, "Someone stole my sentence!"));
        System.out.println(strList.UpdateAll("2) Move over I'm coming in", "Sorry, I didn't mean to take your spot!"));
        System.out.println(strList.StringToString());
        boolList.StringToString();

        // Display the list contents

        strList.display();
        intList.display();
        boolList.display();
        // Determine the length of each list iteratively.
        System.out.println("\nList lengths computed iteratively\n");
        System.out.println("strList number of nodes: "+ strList.lengthIterative());
        System.out.println("intListnumber of nodes: "+ intList.lengthIterative());
        System.out.println("boolListnumber of nodes: "+ boolList.lengthIterative());

        // Determine the length of each list recursively.

        System.out.println("\nList lengths computed recursively\n");
        System.out.println("strList number of nodes: "+ strList.lengthRecursive(strList.header));
        System.out.println("intList number of nodes: "+ intList.lengthRecursive(intList.header));
        System.out.println("boolList number of nodes: "+ boolList.lengthRecursive(boolList.header));

    }

    /*
     *   Enter a data item at the front of the list.
     */

    /*
     *    lengthIterative()
     *
     *    Return the length of the list.
     */

    public int lengthIterative()
    {
        Node ptr = header;     // A pointer to travel the list.
        int count = 0;         // Counts the number of nodes.

        while (ptr != null)    // While not at the end of the list.
        {
            count++;                // Add this node to the count.
            ptr = ptr.next;         // Move to the next node.
        }

        return count;     // Return the number of nodes.
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

        while (ptr != null) {    // While not at the end of the list ...
            T data = ptr.data;              // Get data of current node.
            System.out.println(data.toString()); // Print the data.
            ptr = ptr.next;                 // Move to the next node.
        }

        System.out.println("");
    }

    /*
     *    Inner Class - Node objects for a singly linked list.
     *
     */

    private class Node
    {
        public T data;      // Data stored in the Node.
        public Node next;   // Pointer to next Node in the list.
     }

}
