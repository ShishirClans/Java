
/*

Name- Shishir Ghorashainee
CSC 360-002
Professor Yangyang Tao
Assignment 6

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

public class Decode {
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
                // 5 is subtracted from each byte and is written to the output file
                outputStream.write(data - 5);
            }
        }

        System.out.println("File decrypted successfully.");
    }
}














