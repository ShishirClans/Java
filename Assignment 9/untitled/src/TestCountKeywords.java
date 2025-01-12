/*
Shishir Ghorashainee
Assignment 9
Professor Yangyang Tao

There are two main functions in this program. It first requests the name of a Java source file from the user.
After that, it reads the file and counts the total number of Java keywords that are used in it.
Every word in the file is examined by the program to see if it contains a Java keyword.
Finally, the code displays the total number of Java keywords that are in the file.

 */

import java.io.*;
import java.util.*;

public class TestCountKeywords {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file (e.g., src/CountKeywords.java): ");
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
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
                "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        Set<String> countedKeywords = new HashSet<>();
        int count = 0;

        try (Scanner input = new Scanner(file)) {
            boolean isInComment = false;

            while (input.hasNext()) {
                String word = input.next().replaceAll("[^a-zA-Z0-9_]", "");

                if (!isInComment && keywordSet.contains(word) && !countedKeywords.contains(word) && !isInString(word)) {
                    System.out.println(word);
                    countedKeywords.add(word);
                    count++;
                }

                if (word.contains("//")) {
                    break;
                } else if (word.contains("/*")) {
                    isInComment = true;
                } else if (word.contains("*/")) {
                    isInComment = false;
                }
            }
        }

        return count;
    }

    private static boolean isInString(String word) {
        return word.startsWith("\"") && word.endsWith("\"");
    }
}
