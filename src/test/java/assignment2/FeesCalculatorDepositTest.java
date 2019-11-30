package assignment2;

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
public class FeesCalculatorDepositTest {
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
                { "PathP1", true, 11000, 110000, 110 },
                { "PathP2", true, 11000, 90000, 55 },
                { "PathP3", true, 9000, 600000, 45 },
                { "PathP4", true, 9000, 400000, 0 },
                { "PathP5", false, 60000, 600000, 600 },
                { "PathP6", false, 60000, 400000, 300 },
                { "PathP7", false, 40000, 1100000, 200 },
                { "PathP8", false, 40000, 900000, 0 },
        };
        return Arrays.asList(data);
    }

    @Test
    public void testDepositTestCases() {
        assertThat(calculator.calculateDepositInterest(amount, accountBalance, student), is(interest));
    }
}
