package bank;

import bank.FeesCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Math.round;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class FeesCalculatorTransferTest {
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
    public int fromAccountBalance;
    @Parameter(4)
    public int toAccountBalance;
    @Parameter(5)
    public double feePercent;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{
                {"T1", true, 5000, 80000, 80000, 0.001},
                {"T2", true, 5000, 80000, 500000, 0.0005},
                {"T3", true, 5000, 500000, 80000, 0.005},
                {"T4", true, 5000, 500000, 500000, 0.0025},
                {"T5", true, 12000, 80000, 80000, 0.0005},
                {"T6", true, 12000, 80000, 500000, 0.00025},
                {"T7", true, 12000, 500000, 80000, 0.0025},
                {"T8", true, 12000, 500000, 500000, 0.00125},
                {"T9", false, 5000, 80000, 80000, 0.002},
                {"T10", false, 5000, 80000, 500000, 0.001},
                {"T11", false, 5000, 500000, 80000, 0.01},
                {"T12", false, 5000, 500000, 500000, 0.005},
                {"T13", false, 12000, 80000, 80000, 0.001},
                {"T14", false, 12000, 80000, 500000, 0.0005},
                {"T15", false, 12000, 500000, 80000, 0.005},
                {"T16", false, 12000, 500000, 500000, 0.0025},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testTransferTestCases(){
        int expected = (int) round(amount * feePercent);
        assertThat(calculator.calculateTransferFee(amount, fromAccountBalance, toAccountBalance, student), is(expected));
    }
}
