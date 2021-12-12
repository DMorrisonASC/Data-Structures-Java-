import java.util.ArrayList;

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

    public void DFS () {
        Stack<Integer> DFS_Stack = new Stack<Integer>();
        ArrayList<Integer> visitedNodes = new ArrayList<>(size);

        DFS_Stack.push(0);

        while (visitedNodes.size() != size){
            int popNodeIndex = DFS_Stack.pop();
                if (!visitedNodes.contains(popNodeIndex)) {
                    visitedNodes.add(popNodeIndex);
                    System.out.println(popNodeIndex);
                    LinkedList<Integer>.Node ptr = adjList_Array[popNodeIndex].header;
                    while (ptr.next != null) {
                        ptr = ptr.next;
                        DFS_Stack.push(Integer.parseInt(ptr.key));
                    }
                }
        }

        for (int i = 0; i < visitedNodes.size(); i++) {
            System.out.print(visitedNodes.get(i));
        }
    }
    
    
}
