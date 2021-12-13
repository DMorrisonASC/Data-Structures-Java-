import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        boolean keepGoing = true;
        Adjacency_List myList = new Adjacency_List();
        myList = myList.load_List_File("./Example_Data.txt");

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
                    System.out.println("Enter filename: ");
                    String load_FileName = keyboard.nextLine().trim();
                    myList = myList.load_List_File(load_FileName);
                    break;
                case "4":
                    keepGoing = false;
                break;
            }
        }
    }
}
