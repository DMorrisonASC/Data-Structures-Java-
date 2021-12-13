import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        boolean keepGoing = true;
        File fileName = new File("./Example_Data.txt");
        Scanner myFile = new Scanner(fileName);
        Adjacency_List myList;
        int adjListSize;
        int amountOfEdges;

        // Scan in the 1st line in file that sets size of adjacency list and it's edges
        String theFirstLine = myFile.nextLine();
        Scanner theFirstLineScanner = new Scanner(theFirstLine);

        adjListSize = Integer.parseInt(theFirstLineScanner.next());
        amountOfEdges = Integer.parseInt(theFirstLineScanner.next());
        myList = new Adjacency_List(adjListSize, amountOfEdges);

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

                myList.insert(index, to_node_name, weight);
            }
        }
//        myList.displayAllList();

        Scanner keyboard = new Scanner(System.in);

        while (keepGoing) {
            System.out.println("1. Find the shortest path\n" +
                    "2. DFS and BFS\n" +
                    "3. Load new file\n" +
                    "4. Exit\n");

            String choice = keyboard.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("Enter node: ");
                    break;
                case "2":
                    System.out.print("DFS: ");
                    myList.DFS();
                    System.out.print("BFS: ");
                    myList.BFS();
                break;

                case "3":

                    break;
                case "4":
                    keepGoing = false;
                break;

            }

        }

    }
    
}
