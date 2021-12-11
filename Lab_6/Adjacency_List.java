

public class Adjacency_List {
    LinkedList<Integer>[] adjList_Array;
    int size;

    public Adjacency_List(int size) {
        this.size = size;
        adjList_Array = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> oneLinkedlist = new LinkedList<Integer>();
            adjList_Array[i] = oneLinkedlist;
        }
    }

    public void insert(int index, String to_node, int weight) {
        LinkedList<Integer> selectedLinkedList = adjList_Array[index];
        selectedLinkedList.insert(to_node, weight);
    }

    public void displayAllList() {
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> selectedLinkedList = adjList_Array[i];
            System.out.println("Node " + i + " Connections: ");
            selectedLinkedList.display();
        }
    }

    public static void main(String[] args) {
        Adjacency_List myList = new Adjacency_List(5);

        myList.insert(1, "9", 5);
        myList.insert(1, "2", 5);
        myList.insert(1, "3", 5);

        myList.displayAllList();

    }
}
