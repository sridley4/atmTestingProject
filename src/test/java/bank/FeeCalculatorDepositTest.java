package bank;

import bank.FeesCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class FeeCalculatorDepositTest {
    private FeesCalculator calculator;

    @Before
    public void beforeEach() {
        calculator = new FeesCalculator();
    }

    @Parameter(0)
    public String testName;
    @Parameter(1)
    public boolean student;
    @Parameter(2)
    public int amount;
    @Parameter(3)
    public int accountBalance;
    @Parameter(4)
    public int interest;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "DT1", true, 11000, 110000, 110 },
                { "DT2", true, 11000, 90000, 55 },
                { "DT3", true, 9000, 600000, 45 },
                { "DT4", true, 9000, 400000, 0 },
                { "DT5", false, 60000, 600000, 600 },
                { "DT6", false, 60000, 400000, 300 },
                { "DT7", false, 40000, 1100000, 200 },
                { "DT8", false, 40000, 900000, 0 },
        };
        return Arrays.asList(data);
    }

    @Test
    public void testDepositTestCases() {
        assertThat(calculator.calculateDepositInterest(amount, accountBalance, student), is(interest));
    }
}