import com.model.Payment;
import com.model.PaymentList;
import com.model.Result;
import com.service.calcualtion.Calculation;
import com.service.calcualtion.CalculationImpl;
import com.service.calcualtion.DateConversion;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Viktor Makarov
 */
public class CalculationTest {
    static PaymentList paymentList = new PaymentList();
    private Calculation calculation = new CalculationImpl();

    @BeforeClass
    public static void init() {
        List<Payment> payments = new ArrayList<Payment>();
        Payment payment = new Payment("Billy",
                DateConversion.getDateFromString("2000-03-10"),
                false, 'п', 1000);
        payments.add(payment);
        payment = new Payment("Willy",
                DateConversion.getDateFromString("2010-03-10"),
                false, 'к', 200);
        payments.add(payment);
        payment = new Payment("Dilly",
                DateConversion.getDateFromString("2020-03-10"),
                true, 'К', 300);
        payments.add(payment);
        payment = new Payment("Eddie",
                DateConversion.getDateFromString("2030-03-10"),
                true, 'П', 400);
        payments.add(payment);
        paymentList.setPayments(payments);
    }

    @Test
    public void shouldCalculateAllBalance() {
        Result result = calculation.calculateResult(paymentList, false);
        Assert.assertEquals(900L, result.getBalance());
    }

    @Test
    public void shouldCalculateForTaxes() {
        Result result = calculation.calculateResult(paymentList, true);
        Assert.assertEquals(100L, result.getBalance());
    }

    @Test
    public void shouldCalculatePercent() {
        Result result = calculation.calculateResult(paymentList, true);
        Assert.assertEquals(13, result.getPercent(), 0.1);
    }

    @Test
    public void shouldCalculateUpToDate() {
        Result result = calculation.calculateResult(paymentList, false, "10-04-10");
        Assert.assertEquals(800L, result.getBalance());
    }

    @Test
    public void shouldCalculateWithOtherPercent() {
        Result result = new CalculationImpl(0.3F).calculateResult(paymentList, true);
        Assert.assertEquals(30, result.getPercent(), 0.1);
    }
}
