
/*
Name- Shishir Ghorashainee
CSC 360-002
Professor Yangyang Tao
Assignment 6

    the program begins as user is prompted to enter the names of an input file to be encrypted and the output file that will store the encrypted file.
     Then the input and output file names are then passed to the encrypt method which is later called.
     Buffered streams are used inside the encryptFile method to read from the input file and write to the output file.
     It performs a basic encryption process by adding 5 to each byte value read from the input file.
     The output file receives the encrypted data. In the end, a success message is displayed.
 */



import java.io.*;
import java.util.Scanner;

public class Encode {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        // prompt user to enter name of the file to encrypt
        System.out.print("Enter the file name to encrypt: ");
        String inputFileName = input.next();
        // prompt user to enter the name for the output file
        System.out.print("Enter the output file name: ");
        String outputFileName = input.next(); // the encrypted file is stored in this output file

        // Call the encrypt method and handle IOException
        encrypt(inputFileName, outputFileName);

        System.out.println("File encrypted successfully.");
        input.close();
    }

    public static void encrypt(String inputFileName, String outputFileName) throws IOException {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFileName));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFileName))) {

            int store;
            while ((store = inputStream.read()) != -1) {
                outputStream.write(store + 5);
            }
        }
    }
}
