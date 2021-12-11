import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        File fileName = new File("./Example_Data.txt");

        Scanner myFile = new Scanner(fileName);

        while (myFile.hasNextLine()) {
            String eachLine = myFile.nextLine();
            Scanner scanNum = new Scanner(eachLine);

            while (scanNum.hasNext()) {
                String eachNum = scanNum.next();
                System.out.println(eachNum);
            }
        }
    }
}
