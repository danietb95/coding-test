package coding;

import java.io.IOException;
import java.util.ArrayList;

public class Palindrome {

    private static String palindromeClassification(String inputString) {
        int numberWords = inputString.split(" ").length;
        String palindromeType = "";
        if (numberWords == 1)
            palindromeType = "Single Word Palindrome";
        else if (numberWords == 2)
            palindromeType = "Two Words Palindrome";
        else if (numberWords > 2 && numberWords <= 5)
            palindromeType = "Multiple Words Palindrome";
        else if (numberWords > 5)
            palindromeType = " Hell of a Palindrome";
        return palindromeType;
    }

    private static String removeCharacters(String inputString) {
        return inputString.replaceAll("\\W+", "");
    }

    private static boolean isPalindrome(String inputString) {
        String characterString = removeCharacters(inputString.toLowerCase());
        for (int i = 0, j = characterString.length() - 1; i <= j; i++, j--) {
            if (characterString.charAt(i) != characterString.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWordPalindrome(String inputString) {
        String[] wordsArray = inputString.split(" ");
        if (wordsArray.length!=1) {
            for (int i = 0, j = wordsArray.length - 1; i <= j; i++, j--) {
                if (!removeCharacters(wordsArray[i]).equalsIgnoreCase(removeCharacters(wordsArray[j])))
                    return false;
            }
            return true;
        }
        else
            return false;
    }

    public static void evaluate(String readRoot, String saveRoot) throws IOException {
        ArrayList<String> fileInformation = FileManagement.readFile(readRoot);
        ArrayList<String> palindromes = new ArrayList<String>();
        for (String stringEvaluate : fileInformation) {
            if (Palindrome.isPalindrome(stringEvaluate))
                palindromes.add(stringEvaluate + " (" + palindromeClassification(stringEvaluate) + ")");
             else if (Palindrome.isWordPalindrome(stringEvaluate))
                palindromes.add(stringEvaluate + "(Word by Word palindrome)");
        }
        FileManagement.writeFile(saveRoot, palindromes);
    }
}
