/*
Shishir Ghorashainee
CSC 360
Professor Yangyang Tao
Assignment 7
November 1, 2023

 */

import java.util.Scanner;
public class SolutionTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a number (e.g. 121): ");
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num >= 0) {
                boolean isPalindrome = testPalindrome(num);
                if (isPalindrome) {
                    System.out.println( num + "is a palindrome!");
                } else {
                    System.out.println( num + "is not a palindrome.");
                }
            } else {
                System.out.println("Try again!!! The input can't be a negative number.");
            }
        } else {
            System.out.println("Enter a valid number!!!!");
        }
        scanner.close();
    }

    public static boolean testPalindrome(int number) {
        String numToStr = Integer.toString(number);
        String revNumber = new StringBuilder(numToStr).reverse().toString();
        return numToStr.equals(revNumber);
    }