package coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ReverseUnitTest {

    @Test
    public void whenInsertCadenaReturnAnedac() {
        String answer = ReverseCharacters.reverseString("Cadena");
        Assert.assertEquals(answer, "anedaC");
    }

    @Test
    public void whenInserNumbersAndCharacters() {
        String answer = ReverseCharacters.reverseString("12string");
        Assert.assertEquals(answer, "gnirts21");
    }

    @Test
    public void whenInsertSpecialCharacters() {
        String answer = ReverseCharacters.reverseString("!#$%&/ ");
        Assert.assertEquals(answer, " /&%$#!");
    }

    @Test
    public void concatAndReverseCharacters() {
        String answer = ReverseCharacters.concatReverseString(2, 6, "st(ing)oncat");
        Assert.assertEquals(answer, "stgnioncat");
    }

    @Test
    public void concatAndReverseEmptyCharacters() {
        String answer = ReverseCharacters.concatReverseString(0, 1, "()");
        Assert.assertEquals(answer, "");
    }

    @Test
    public void concatAndReverseFirstAndLastCharacter() {
        String answer = ReverseCharacters.concatReverseString(0, 5, "(DEMO)");
        Assert.assertEquals(answer, "omed");
    }

    @Test
    public void concatAndReverseNestParenthesis() {
        String answer = ReverseCharacters.reverse("foo(bar(baz))blim");
        Assert.assertEquals(answer, "foobazrabblim");
    }

    @Test
    public void concatAndReverseSingleParenthesis() {
        String answer = ReverseCharacters.reverse("foo(bar)baz");
        Assert.assertEquals(answer, "foorabbaz");
    }

    @Test
    public void concatAndReverseExtraOpenParenthesis() {
        String answer = ReverseCharacters.reverse("foo((bar)baz");
        Assert.assertEquals(answer, "");
    }

    @Test
    public void concatAndReverseExtraCloseParenthesis() {
        String answer = ReverseCharacters.reverse("foo(bar)baz)");
        Assert.assertEquals(answer, "");
    }

    @Test
    public void concatAndReverseParenthesis() {
        String answer = ReverseCharacters.reverse("()");
        Assert.assertEquals(answer, "");
    }

    @Test
    public void concatAndReverseWrongParenthesis() {
        String answer = ReverseCharacters.reverse(")(");
        Assert.assertEquals(answer, "");
    }

    @Test
    public void concatAndReverseMore50Characters() {
        String answer = ReverseCharacters.reverse("(thisisthestring)(thisisthestring)(thisisthestring)(thisisthestring)(thisisthestring)");
        Assert.assertEquals(answer, "NULL");
    }

    @Test
    public void validStringToReverse() {
        Stack<Integer> openParenthesis = new Stack<Integer>();
        openParenthesis.push(1);
        boolean answer = ReverseCharacters.isValidString(openParenthesis, 5, "D(emo)");
        Assert.assertTrue(answer);
    }

    @Test
    public void validStringToReverseEmpty() {
        Stack<Integer> openParenthesis = new Stack<Integer>();
        openParenthesis.push(0);
        boolean answer = ReverseCharacters.isValidString(openParenthesis, 1, "()");
        Assert.assertTrue(answer);
    }

    @Test
    public void invalidStringCloseParenthesis() {
        Stack<Integer> openParenthesis = new Stack<Integer>();
        boolean answer = ReverseCharacters.isValidString(openParenthesis, 4, "Demo)");
        Assert.assertFalse(answer);
    }

    @Test
    public void invalidStringOpenParenthesis() {
        Stack<Integer> openParenthesis = new Stack<Integer>();
        openParenthesis.push(0);
        boolean answer = ReverseCharacters.isValidString(openParenthesis, 4, "(Demo");
        Assert.assertFalse(answer);
    }
}
