import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        File fileName = new File("./Example_Data.txt");
        Scanner myFile = new Scanner(fileName);
        Adjacency_List myList;
        int adjListSize;
        String amountOfEdges;

        // Scan in the 1st line in file that sets size of adjacency list and it's edges
        String theFirstLine = myFile.nextLine();
        Scanner theFirstLineScanner = new Scanner(theFirstLine);

        adjListSize = Integer.parseInt(theFirstLineScanner.next());
        amountOfEdges = theFirstLineScanner.next();
        myList = new Adjacency_List(adjListSize);

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
        myList.displayAllList();
    }
}
