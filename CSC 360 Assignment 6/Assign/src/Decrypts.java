/*import java.util.Scanner;
import java.io.*;

public class Decrypts {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //Prompt user to enter the name of the file to decrypt
        System.out.print("Enter name of the file to decrypt: ");
        //Create a BufferedInputStream object to read the file to decrypt
        BufferedInputStream in = new BufferedInputStream(new FileInputStream((input.next())));
        //Prompt user to enter the name for the output file
        System.out.print("Enter name for the output file: ");
        //Create a BufferedOutputStream object to write the dcrypted file
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream((input.next())));
        int s;
        while ((s = in.read()) != -1) {
            output.write(s - 5); //Subtract 5 from each byte to decrypt it
        }
        //Close the input and output stream
        input.close();
        output.close();
    }
}
*/

/*

Name- Shishir Ghorashainee
CSC 360-002
Professor Yangyang Tao
Assignment 6

 */



/*
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decrypts {
    public static void main(String[] args) {
        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Enter input file name for decryption: ");
            String inputFileName = scanner.nextLine();
            System.out.print("Enter output file name for decryption: ");
            String outputFileName = scanner.nextLine();
            scanner.close();

            try (
                    BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFileName));
                    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFileName));
            ) {
                int data;
                while ((data = inputStream.read()) != -1) {
                    // Subtract 5 from each byte and write it to the output file
                    outputStream.write(data - 5);
                }
            }

            System.out.println("File decrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/


/*

This Java program reads a file, reduces it by 5, then saves the result in a different file for decryption.
The user is asked to enter the names of the input and output files.
 It opens the input and output streams for reading and writing using these file names.
  A byte from the input file is read, 5 is subtracted, and the new modified byte is written to the output file.
*/
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decrypts {
    public static void main(String[] args) throws IOException {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter input file name for decryption: ");
        String inputFileName = sc.nextLine();
        System.out.print("Enter output file name for decryption: ");
        String outputFileName = sc.nextLine();
        sc.close();

        try (
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFileName));
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFileName));
        ) {
            int data;
            while ((data = inputStream.read()) != -1) {
                // Subtract 5 from each byte and write it to the output file
                outputStream.write(data - 5);
            }
        }

        System.out.println("File decrypted successfully.");
    }
}














