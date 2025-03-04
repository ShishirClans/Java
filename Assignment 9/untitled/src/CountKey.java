/*
    Name: Binayak Shrestha
    Instructor: Prof. Yangyang Tao
    Assignment 9
    Brief description: This program covers Lists, Stacks, and Queues
    Date: Nov 26th 2023
 */
import java.util.*;
import java.io.*;

public class CountKey {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file (e.g. src/countkeywords.java): ");
        String filename = input.nextLine();
        input.close();

        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The number of keywords in " + filename + " is " + countKeywords(file));
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {
        // Array of all Java keywords true, false and null
        String[] keywordString = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;
        boolean inComment = false;
        boolean inString = false;

        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String word = input.next();

            // Check if we're in a comment or string
            if (word.startsWith("\"") && !inComment) {
                inString = !inString;
            } else if (word.startsWith("//") || (word.startsWith("/*") && !inString)) {
                inComment = true;
            }

            // If not in a comment or string, check if the word is a keyword
            if (!inComment && !inString && keywordSet.contains(word)) {
                count++;
            }

            // Check if we've reached the end of a comment
            if (word.endsWith("*/")) {
                inComment = false;
            }
        }
        input.close();
        return count;
    }
}