import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> boyNames = new HashMap<>();
        Map<String, Integer> girlNames = new HashMap<>();
        List<String> namesUsedForBothGenders = new ArrayList<>();

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

                namesUsedForBothGenders.addAll(boyNames.keySet());
                namesUsedForBothGenders.retainAll(girlNames.keySet());

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
