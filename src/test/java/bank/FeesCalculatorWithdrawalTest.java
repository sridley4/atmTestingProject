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
    public int feePercentage;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{
                {"WT1", 1000, 1000, true, 1, 0.0},
                {"WT2", 1000, 1000, true, 3, 0.001},
                {"WT3", 1000, 1000, false, 1, 0.002},
                {"WT4", 1000, 1000, false, 1, 0.001},
                {"WT5", 1000, 1000, false, 1, 0.0},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testTransferTestCases(){
        int expected = round(amount * feePercentage);
        assertThat(calculator.calculateWithdrawalFee(amount, accountBalance, student, dayOfWeek), is(expected));
    }
}
