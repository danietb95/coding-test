package coding;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

public class ReverseUnitTest {
    @Spy
    ReverseCharacters reverse= Mockito.spy(new ReverseCharacters());

    @Test
    public void cuandoIngresa5EntoncesRetornaV() {
        Mockito.when(ReverseCharacters.reverseString(Mockito.any(String.class))).thenReturn("de");
        String answer = ReverseCharacters.reverseString("da");
        Assert.assertEquals(answer, "ad");
    }
}
