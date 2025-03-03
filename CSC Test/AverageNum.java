/* Name: Shishir Ghorashainee
   Course: CSC 360
   Professor Yangyang Tao
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AverageNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of input file: ");
        String fileName = sc.nextLine();
        
        File inputFile = new File(fileName);

        if (!inputFile.exists()) {
            System.out.println("File not found: " + fileName);
            sc.close();
            return; // Exit the program if the file doesn't exist.
        }

        int sum = 0, count = 0, unparsableLines = 0;

        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                try {
                    int number = Integer.parseInt(line);
                    sum += number;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Cannot parse " + line + " as an int");
                    unparsableLines++;
                }
            }
            
            if (count > 0) {
                double average = (double) sum / count;
                System.out.println("Number of Parsable Lines: " + count);
                System.out.println("Average Value: " + average);
            }
            
            System.out.println("Number of unparsable lines: " + unparsableLines);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file: " + fileName);
        }
        
        sc.close();
    }
}
