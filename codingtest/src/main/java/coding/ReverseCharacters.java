package coding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class ReverseCharacters {

    public static String concatReverseString(int positionA, int positionB, String stringToDivide) {
        String firstPart = stringToDivide.substring(0, positionA);
        String secondPart = stringToDivide.substring(positionA + 1, positionB);
        String thirdPart = stringToDivide.substring(positionB + 1);
        return (firstPart + reverseString(secondPart) + thirdPart).toLowerCase();
    }

    public static String reverseString(String inputString) {
        String reverse = "";
        for (int i = inputString.length() - 1; i >= 0; i--)
            reverse = reverse + inputString.charAt(i);
        return reverse;
    }

    public static boolean isValidString(Stack<Integer> openParenthesis, int position, String StringToReverse) {
        if (!openParenthesis.isEmpty() && position == StringToReverse.length() - 1 && StringToReverse.charAt(position) != ')') {
            return false;
        }
        if (StringToReverse.charAt(position) == ')' && openParenthesis.isEmpty()) {
            return false;
        }
        return true;
    }

    public static String reverse(String inputString) {
        String StringToReverse = inputString;
        Stack<Integer> openParenthesis = new Stack<Integer>();
        if (inputString.length() <= 50) {
            for (int i = 0; i < StringToReverse.length(); i++) {
                if (!isValidString(openParenthesis, i, StringToReverse)) {
                    StringToReverse = "";
                    break;
                }
                if (StringToReverse.charAt(i) == '(')
                    openParenthesis.push(i);
                if (StringToReverse.charAt(i) == ')' && !openParenthesis.isEmpty()) {
                    int characterOpenParenthesis = openParenthesis.pop();
                    StringToReverse = concatReverseString(characterOpenParenthesis, i, StringToReverse);
                    i = characterOpenParenthesis;
                }
            }
        } else
            StringToReverse = "NULL";
        return StringToReverse;
    }

    /**
     * Read line by line and evaluate if the input can be reversed
     *
     * @param readRoot file root where the input is read it
     * @param saveRoot file root where the result is presented
     */
    public static void evaluate(String readRoot, String saveRoot) throws IOException {
        ArrayList<String> fileInformation = FileManagement.readFile(readRoot);
        ArrayList<String> reverseOutput = new ArrayList<String>();
        for (String stringEvaluate : fileInformation) {
            reverseOutput.add(reverse(stringEvaluate));
        }
        FileManagement.writeFile(saveRoot, reverseOutput);
    }
}
