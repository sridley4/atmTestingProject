package assignment2;

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
public class transferTest {
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
                {"PathP1", true, 5000, 80000, 80000, 0.001},
                {"PathP2", true, 5000, 80000, 500000, 0.0005},
                {"PathP3", true, 5000, 500000, 80000, 0.005},
                {"PathP4", true, 5000, 500000, 500000, 0.0025},
                {"PathP5", true, 12000, 80000, 80000, 0.0005},
                {"PathP6", true, 12000, 80000, 500000, 0.00025},
                {"PathP7", true, 12000, 500000, 80000, 0.0025},
                {"PathP8", true, 12000, 500000, 500000, 0.00125},
                {"PathP9", false, 5000, 80000, 80000, 0.002},
                {"PathP10", false, 5000, 80000, 500000, 0.001},
                {"PathP11", false, 5000, 500000, 80000, 0.01},
                {"PathP12", false, 5000, 500000, 500000, 0.005},
                {"PathP13", false, 12000, 80000, 80000, 0.001},
                {"PathP14", false, 12000, 80000, 500000, 0.0005},
                {"PathP15", false, 12000, 500000, 80000, 0.005},
                {"PathP16", false, 12000, 500000, 500000, 0.0025},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testTransferTestCases(){
        int expected = (int) round(amount * feePercent);
        assertThat(calculator.calculateTransferFee(amount, fromAccountBalance, toAccountBalance, student), is(expected));
    }
}
