import org.junit.Assert;
import org.junit.Test;
import com.service.text.DictionaryImpl;
import com.service.text.StringTransformerImpl;

/**
 * @author Viktor Makarov
 */

public class StringsTest {
    StringTransformerImpl transformer = new StringTransformerImpl(new DictionaryImpl());

    @Test
    public void shouldAddSpaces() {
        String s = "aa";
        String out = "a  a";
        Assert.assertEquals(out, transformer.returnTransformedStrings(s)[0]);
    }

    @Test
    public void shouldSplitToMultipleStrings() {
        String s = "\ns";
        String out = "s";
        Assert.assertEquals(out, transformer.returnTransformedStrings(s)[2]);
    }

    @Test
    public void shouldGetCorrectAlphabetIndex() {
        String s = "azя";
        String out = "1  26 33";
        Assert.assertEquals(out, transformer.returnTransformedStrings(s)[1]);
    }

    @Test
    public void shouldChangeAmountOfSpaces() {
        String s = "aza";
        String out = "1  26 1";
        Assert.assertEquals(out, transformer.returnTransformedStrings(s)[1]);
    }

    @Test
    public void shouldPreserveNotLetter() {
        String s = "a.z";
        String out = "1  .  26";
        Assert.assertEquals(out, transformer.returnTransformedStrings(s)[1]);
    }

    @Test
    public void shouldIgnoreCase() {
        String s = "aA";
        String out = "1  1";
        Assert.assertEquals(out, transformer.returnTransformedStrings(s)[1]);
    }

    @Test
    public void shouldReturnComposedString() {
        String s = "a\nZ";
        String out = "a\n1\nZ\n26";
        Assert.assertEquals(out, transformer.returnTransformedStringsAsSingleString(s));
    }
}
