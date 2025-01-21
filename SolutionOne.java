/*
Shishir Ghorashainee
CSC 360
Professor Yangyang Tao
Assignment 7
November 1, 2023

 */
/*
The user is asked by the Java programme "Solution_One" for a starting text and a number
        After that, a list of parts with numbers, such as "1.2.3.", is created and displayed on the screen.
*/

import java.util.Scanner;
public class SolutionOne{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the prefix: ");
        String customPrefix = input.nextLine();
        System.out.print("Enter the levels: ");
        int customLevels = input.nextInt();
        Sections(customPrefix, customLevels);
    }

    public static void Sections(String prefix, int levels) {
        if (levels == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 1; i <= 3; i++) {
                String newPrefix = prefix + i + ".";
                Sections(newPrefix, levels - 1);
            }
        }
    }
}
