import com.service.calcualtion.Part;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Viktor Makarov
 */
public class PartTest {
    Part part;

    @Test
    public void shouldSum() {
        part = Part.DEBIT;

        Assert.assertEquals(2L, part.action(1, 1));
    }

    @Test
    public void shouldSubtract() {
        part = Part.CREDIT;

        Assert.assertEquals(0L, part.action(1, 1));
    }

    @Test
    public void shouldDoNothing() {
        part = Part.DEFAULT;

        Assert.assertEquals(1L, part.action(1, 1));
    }
}
