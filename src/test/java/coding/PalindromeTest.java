package test.java.coding;

import main.java.coding.Palindrome;

import java.io.IOException;

public class PalindromeTest {
    public static void main(String[] args) throws IOException {
        Palindrome.evaluate("palindromeInput.csv", "palindromeOutput.csv");
    }
}
