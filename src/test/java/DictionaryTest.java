import org.junit.Assert;
import org.junit.Test;
import com.service.text.Dictionary;
import com.service.text.DictionaryImpl;

import java.util.Map;

/**
 * @author Viktor Makarov
 */
public class DictionaryTest {
    Dictionary dictionary = new DictionaryImpl();

    @Test
    public void shouldGetDictionary() {
        Assert.assertNotNull(dictionary.getDictionary());
    }

    @Test
    public void shouldReturnCorrectIndex() {
        Assert.assertEquals(33L, (long) dictionary.getDictionary().get('Я'));
        Assert.assertEquals(26L, (long) dictionary.getDictionary().get('Z'));
    }

    @Test
    public void shouldReturnNull() {
        Assert.assertNull(dictionary.getDictionary().get('.'));
    }

    @Test
    public void shouldPreserveDictionary() {
        Map map = dictionary.getDictionary();
        map.put("Z", 555);
        Assert.assertEquals(26L, (long) dictionary.getDictionary().get('Z'));
    }
}
