package test.java.coding;

import main.java.coding.Palindrome;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Palindrome.evaluate("Readpalindrome.csv", "Palindromes.csv");
    }
}
