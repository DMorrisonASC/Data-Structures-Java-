/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date:
    Instructor: Professor
    Description: Implement of an adjacency list.
    Errors:
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Adjacency_List {
    LinkedList<Integer>[] adjList_Array;
    int size;
    int edges;

    public Adjacency_List() {

    }

    public Adjacency_List(int size, int edges) {
        this.size = size;
        this.edges = edges;
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
        System.out.println();
    }

    public void BFS () {
        MyQueue BFS_Queue = new MyQueue(100);
        ArrayList<Integer> visitedNodes = new ArrayList<>(size);

        BFS_Queue.enqueue(0);

        while (visitedNodes.size() != size){
            int popNodeIndex = BFS_Queue.peek();
            if (!visitedNodes.contains(popNodeIndex)) {
                visitedNodes.add(popNodeIndex);
//                Get all the keys of the nodes that the index is pointing to
                LinkedList<Integer>.Node ptr = adjList_Array[popNodeIndex].header;
                while (ptr.next != null) {
                    ptr = ptr.next;
                    BFS_Queue.enqueue(Integer.parseInt(ptr.key));
                }
//                Then remove it from queue
            }
            BFS_Queue.dequeue();
        }

        for (int i = 0; i < visitedNodes.size(); i++) {
            System.out.print(visitedNodes.get(i));
        }
        System.out.println();
    }

    public Adjacency_List load_List_File (String myList) throws IOException {
        File fileName = new File(myList);
        Scanner myFile = new Scanner(fileName);
        Adjacency_List createdList;
        int adjListSize;
        int amountOfEdges;

        // Scan in the 1st line in file that sets size of adjacency list and it's edges
        String theFirstLine = myFile.nextLine();
        Scanner theFirstLineScanner = new Scanner(theFirstLine);

        adjListSize = Integer.parseInt(theFirstLineScanner.next());
        amountOfEdges = Integer.parseInt(theFirstLineScanner.next());
        createdList = new Adjacency_List(adjListSize, amountOfEdges);

        /*
         * Read and load in data from example graph
         * */
        while (myFile.hasNextLine()) {
//            Scan in one line in file
            String eachLine = myFile.nextLine();
            Scanner scanNum = new Scanner(eachLine);
//          Scan number
            while (scanNum.hasNext()) {
                int index = Integer.parseInt(scanNum.next());
                String to_node_name = scanNum.next();
                int weight = Integer.parseInt(scanNum.next());

                createdList.insert(index, to_node_name, weight);
            }
        }
//        myList.displayAllList();
        return createdList;
    }
}
