package bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Math.round;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class FeesCalculatorWithdrawalTest {
    private FeesCalculator calculator;

    @Before
    public void beforeEach() {
        calculator = new FeesCalculator();
    }

    @Parameter(0)               // input variable
    public String testCase;
    @Parameter(1)               // input variable
    public int amount;
    @Parameter(2)               // input variable
    public int accountBalance;
    @Parameter(3)               // input variable
    public boolean student;
    @Parameter(4)               // input variable
    public int dayOfWeek;
    @Parameter(5)               // intermediate in method
    public double feePercentage;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{
                {"WT1", 10000, 10000, true, 1, 0.0},    // amount $1000.00, balance $1,000.00, Student, Sunday, 0% fee
                {"WT2", 10000, 10000, true, 3, 0.001},  // amount $1000.00, balance $1,000.00, Student, Tuesday, 0% fee
                {"WT3", 10000, 50000, false, 1, 0.002}, // amount $1000.00, balance $500.00, Not Student, Sunday, 0.2% fee
                {"WT4", 10000, 500000, false, 1, 0.001},// amount $1000.00, balance $5,000.00, Not Student, Sunday, 0.1% fee
                {"WT5", 10000, 2000000, false, 1, 0.0}, // amount $1000.00, balance $20,000.00, Not Student, Sunday, 0% fee
        };
        return Arrays.asList(data);
    }

    @Test
    public void testTransferTestCases(){
        int expected = (int) round(amount * feePercentage);
        assertThat(calculator.calculateWithdrawalFee(amount, accountBalance, student, dayOfWeek), is(expected));
    }
}
