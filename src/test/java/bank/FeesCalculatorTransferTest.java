package bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.lang.Math.round;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class FeesCalculatorTransferTest {

    private FeesCalculator calculator;

    @Before
    public void beforeEach() {
        calculator = new FeesCalculator();
    }

    @Test
    public void transferWhenStudentHighTransHighFromHighTo() {
        int expected = (int) round(120000 * percent(0.125));
        assertThat(calculator.calculateTransferFee(120000, 150000, 150000, true), is(expected));
    }

    @Test
    public void transferWhenStudentHighTransHighFromLowTo() {
        int expected = (int) round(120000 * percent(0.25));
        assertThat(calculator.calculateTransferFee(120000, 150000, 60000, true), is(expected));
    }

    @Test
    public void transferWhenStudentHighTransLowFromLowTo() {
        int expected = (int) round(120000 * percent(0.05));
        assertThat(calculator.calculateTransferFee(120000, 60000, 60000, true), is(expected));
    }

    @Test
    public void transferWhenStudentLowTransLowFromLowTo() {
        int expected = (int) round(50000 * percent(0.1));
        assertThat(calculator.calculateTransferFee(50000, 60000, 60000, true), is(expected));
    }

    @Test
    public void transferWhenStudentLowTransHighFromHighTo() {
        int expected = (int) round(50000 * percent(0.25));
        assertThat(calculator.calculateTransferFee(50000, 150000, 150000, true), is(expected));
    }

    @Test
    public void transferWhenStudentHighTransLowFromHighTo() {
        int expected = (int) round(120000 * percent(0.025));
        assertThat(calculator.calculateTransferFee(120000, 60000, 150000, true), is(expected));
    }

    @Test
    public void transferWhenStudentLowTransLowFromHighTo() {
        int expected = (int) round(50000 * percent(0.05));
        assertThat(calculator.calculateTransferFee(50000, 60000, 150000, true), is(expected));
    }

    @Test
    public void transferWhenStudentLowTransHighFromLowTo() {
        int expected = (int) round(50000 * percent(0.25));
        assertThat(calculator.calculateTransferFee(50000, 150000, 60000, true), is(expected));
    }

    @Test
    public void transferWhenNonStudentHighTransHighFromHighTo() {
        int expected = (int) round(120000 * percent(0.25));
        assertThat(calculator.calculateTransferFee(120000, 150000, 150000, false), is(expected));
    }

    @Test
    public void transferWhenNonStudentHighTransHighFromLowTo() {
        int expected = (int) round(120000 * percent(0.5));
        assertThat(calculator.calculateTransferFee(120000, 150000, 60000, false), is(expected));
    }

    @Test
    public void transferWhenNonStudentHighTransLowFromLowTo() {
        int expected = (int) round(120000 * percent(0.1));
        assertThat(calculator.calculateTransferFee(120000, 60000, 60000, false), is(expected));
    }

    @Test
    public void transferWhenNonStudentLowTransLowFromLowTo() {
        int expected = (int) round(50000 * percent(0.2));
        assertThat(calculator.calculateTransferFee(50000, 60000, 60000, false), is(expected));
    }

    @Test
    public void transferWhenNonStudentLowTransHighFromHighTo() {
        int expected = (int) round(50000 * percent(0.5));
        assertThat(calculator.calculateTransferFee(50000, 150000, 150000, false), is(expected));
    }

    @Test
    public void transferWhenNonStudentHighTransLowFromHighTo() {
        int expected = (int) round(120000 * percent(0.05));
        assertThat(calculator.calculateTransferFee(120000, 60000, 150000, false), is(expected));
    }

    @Test
    public void transferWhenNonStudentLowTransLowFromHighTo() {
        int expected = (int) round(50000 * percent(0.1));
        assertThat(calculator.calculateTransferFee(50000, 60000, 150000, false), is(expected));
    }

    @Test
    public void transferWhenNonStudentLowTransHighFromLowTo() {
        int expected = (int) round(50000 * percent(1));
        assertThat(calculator.calculateTransferFee(50000, 150000, 60000, false), is(expected));
    }

    private static double percent(double percentage) {
        return percentage / 100;
    }

}
