import com.service.calcualtion.DateConversion;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author Viktor Makarov
 */
public class DateConversionTest {

    @Test
    public void shouldConvertDate() {
        String date = "1987-02-23";
        long year = 87L;
        long month = 1L;
        long day = 23L;

        Date result = DateConversion.getDateFromString(date);

        Assert.assertEquals(year, result.getYear());
        Assert.assertEquals(month, result.getMonth());
        Assert.assertEquals(day, result.getDate());
    }

    @Test
    public void shouldAdd20() {
        String dateOne = "20-02-20";
        String dateTwo = "2020-02-20";

        Date result = DateConversion.getDateFromString(dateOne);
        Date out = DateConversion.getDateFromString(dateTwo);

        Assert.assertEquals(result.getYear(), out.getYear());
    }

    @Test
    public void shouldReturnNull() {
        String incorrectDate = "";
        Date result = DateConversion.getDateFromString(incorrectDate);
        Assert.assertNull(result);
    }
}
