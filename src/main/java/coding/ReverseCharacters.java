package main.java.coding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class ReverseCharacters {

    public static String concatReverseString(int positionA, int positionB, String stringToDivide) {
        String fisrtPart = stringToDivide.substring(0, positionA);
        String secondPart = stringToDivide.substring(positionA + 1, positionB);
        String thirdPart = stringToDivide.substring(positionB + 1);
        return (fisrtPart + reverseString(secondPart) + thirdPart).toLowerCase();
    }

    public static String reverseString(String inputString) {
        String reverse = "";
        for (int x = inputString.length() - 1; x >= 0; x--)
            reverse = reverse + inputString.charAt(x);
        return reverse;
    }

    public static String reverse(String inputString) {
        String StringToReverse = inputString;
        Stack<Integer> openParenthesis = new Stack<Integer>();
        for (int i = 0; i < StringToReverse.length(); i++) {
            if (StringToReverse.charAt(i) == '(')
                openParenthesis.push(i);
            if (StringToReverse.charAt(i) == ')' && !openParenthesis.isEmpty()) {
                int characterOpenParenthesis = openParenthesis.pop();
                StringToReverse = concatReverseString(characterOpenParenthesis, i, StringToReverse);
                i = characterOpenParenthesis;
            }
        }
        return StringToReverse;
    }

    public static void evaluate(String readRoot, String saveRoot) throws IOException {
        ArrayList<String> fileInformation = FileManagement.readFile(readRoot);
        ArrayList<String> reverseOutput = new ArrayList<String>();
        for (String stringEvaluate : fileInformation) {
            if (stringEvaluate.length()>50)
                reverseOutput.add("NULL");
            else
                reverseOutput.add(reverse(stringEvaluate));
        }
        FileManagement.writeFile(saveRoot, reverseOutput);
    }
}
