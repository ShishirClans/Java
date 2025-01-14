/*import java.util.Scanner;
import java.io.*;

public class Encodes {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //Prompt user to enter the name of the file to encrypt
        System.out.print("Enter the file name to encrypt: ");
        //Create a BufferedInputStream object to read the file to encrypt
        BufferedInputStream in = new BufferedInputStream(new FileInputStream((input.next())));
        //Prompt user to enter the name for the output file
        System.out.print("Enter the output file name: ");
        //Create a BufferedOutputStream object to write the encrypted file
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream((input.next())));
        int s;
        while ((s = in.read()) != -1) {
            output.write(s + 5);

        }
        //close the input and output stream
        input.close();
        output.close();
        System.out.println("File encrypted successfully.");

    }
}
*/

/*
Name- Shishir Ghorashainee
CSC 360-002
Professor Yangyang Tao
Assignment 6

    the program begins as user is prompted to enter the names of an input file to be encrypted and the output file that will store the encrypted file.
     The program begins by prompting the user to The input and output file names are then passed to the encryptFile method, which is eventually called.
     Buffered streams are used inside the encryptFile method to read from the input file and write to the output file.
      It performs a basic encryption process by adding 5 to each byte value read from the input file.
     The output file receives the encrypted data. In the end, a success message is displayed by the program at the end.
 */






import java.io.*;
import java.util.Scanner;

public class Encodes {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        // prompt user to enter name of the file to encrypt
        System.out.print("Enter the file name to encrypt: ");
        String inputFileName = input.next();

        // prompt user to enter the name for the output file
        System.out.print("Enter the output file name: ");
        String outputFileName = input.next(); // the encrypted file is stored in this output file

        // Call the encryptFile method and handle IOException at the calling code
        encryptFile(inputFileName, outputFileName);

        System.out.println("File encrypted successfully.");

        input.close();
    }


    public static void encryptFile(String inputFileName, String outputFileName) throws IOException {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFileName));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFileName))) {

            int store;
            while ((store = inputStream.read()) != -1) {
                outputStream.write(store + 5);
            }
        }
    }
}
