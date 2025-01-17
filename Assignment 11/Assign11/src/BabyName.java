/*
Name- Shishir Ghorashainee
CSC 360-002
Professor Yangyang Tao
Assignment 11


 In this code, we attempt to access the file using loops and compare them.
 Next, the program identifies names that are used for both genders and appear in both maps.
 Also, this program looks for names that appear in all files for both genders and displays them in the output.


 */

import java.util.*;
import java.io.*;

public class BabyName {
    public static void main(String[] args) {
        Map<String, Integer> boyNames = new HashMap<>();
        Map<String, Integer> girlNames = new HashMap<>();
        Set<String> namesUsedForBothGenders = new HashSet<>();

        for (int year = 2001; year <= 2010; year++) {
            String fileName = "babynamesranking" + year + ".txt";

            try (Scanner input = new Scanner(new File(fileName))) {
                while (input.hasNext()) {
                    int rank = input.nextInt();
                    String boyName = input.next();
                    int boyCount = input.nextInt();
                    String girlName = input.next();
                    int girlCount = input.nextInt();

                    boyNames.put(boyName, rank);
                    girlNames.put(girlName, rank);
                }

                Set<String> boySet = new HashSet<>(boyNames.keySet());
                boySet.retainAll(girlNames.keySet());
                namesUsedForBothGenders.addAll(boySet);

                boyNames.clear();
                girlNames.clear();

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
                e.printStackTrace();
            }
        }

        System.out.println("Names used for both genders:");
        namesUsedForBothGenders.forEach(System.out::println);

        if (namesUsedForBothGenders.isEmpty()) {
            System.out.println("No names found that are used for both genders.");
        }
    }
}
