package bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.lang.Math.round;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class FeesCalculatorTest {

    private FeesCalculator calculator;

    @Before
    public void beforeEach() {
        calculator = new FeesCalculator();
    }

    @Test
    public void calculatesTransferWhenStudentHighTransHighFromHighTo() {
        int expected = (int) round(120000 * percent(0.125));
        assertThat(calculator.calculateTransferFee(120000, 150000, 150000, true), is(expected));
    }

    @Test
    public void calculatesTransferWhenStudentHighTransHighFromLowTo() {
        int expected = (int) round(120000 * percent(0.25));
        assertThat(calculator.calculateTransferFee(120000, 150000, 60000, true), is(expected));
    }

    @Test
    public void calculatesTransferWhenStudentHighTransLowFromLowTo() {
        int expected = (int) round(120000 * percent(0.05));
        assertThat(calculator.calculateTransferFee(120000, 60000, 60000, true), is(expected));
    }

    @Test
    public void calculatesTransferWhenStudentLowTransLowFromLowTo() {
        int expected = (int) round(50000 * percent(0.1));
        assertThat(calculator.calculateTransferFee(50000, 60000, 60000, true), is(expected));
    }

    @Test
    public void calculatesTransferWhenStudentLowTransHighFromHighTo() {
        int expected = (int) round(50000 * percent(0.25));
        assertThat(calculator.calculateTransferFee(50000, 150000, 150000, true), is(expected));
    }

    @Test
    public void calculatesTransferWhenStudentHighTransLowFromHighTo() {
        int expected = (int) round(120000 * percent(0.025));
        assertThat(calculator.calculateTransferFee(120000, 60000, 150000, true), is(expected));
    }

    @Test
    public void calculatesTransferWhenStudentLowTransLowFromHighTo() {
        int expected = (int) round(50000 * percent(0.05));
        assertThat(calculator.calculateTransferFee(50000, 60000, 150000, true), is(expected));
    }

    @Test
    public void calculatesTransferWhenStudentLowTransHighFromLowTo() {
        int expected = (int) round(50000 * percent(0.25));
        assertThat(calculator.calculateTransferFee(50000, 150000, 60000, true), is(expected));
    }

    @Test
    public void calculatesTransferWhenNonStudentHighTransHighFromHighTo() {
        int expected = (int) round(120000 * percent(0.25));
        assertThat(calculator.calculateTransferFee(120000, 150000, 150000, false), is(expected));
    }

    @Test
    public void calculatesTransferWhenNonStudentHighTransHighFromLowTo() {
        int expected = (int) round(120000 * percent(0.5));
        assertThat(calculator.calculateTransferFee(120000, 150000, 60000, false), is(expected));
    }

    @Test
    public void calculatesTransferWhenNonStudentHighTransLowFromLowTo() {
        int expected = (int) round(120000 * percent(0.1));
        assertThat(calculator.calculateTransferFee(120000, 60000, 60000, false), is(expected));
    }

    @Test
    public void calculatesTransferWhenNonStudentLowTransLowFromLowTo() {
        int expected = (int) round(50000 * percent(0.2));
        assertThat(calculator.calculateTransferFee(50000, 60000, 60000, false), is(expected));
    }

    @Test
    public void calculatesTransferWhenNonStudentLowTransHighFromHighTo() {
        int expected = (int) round(50000 * percent(0.5));
        assertThat(calculator.calculateTransferFee(50000, 150000, 150000, false), is(expected));
    }

    @Test
    public void calculatesTransferWhenNonStudentHighTransLowFromHighTo() {
        int expected = (int) round(120000 * percent(0.05));
        assertThat(calculator.calculateTransferFee(120000, 60000, 150000, false), is(expected));
    }

    @Test
    public void calculatesTransferWhenNonStudentLowTransLowFromHighTo() {
        int expected = (int) round(50000 * percent(0.1));
        assertThat(calculator.calculateTransferFee(50000, 60000, 150000, false), is(expected));
    }

    @Test
    public void calculatesTransferWhenNonStudentLowTransHighFromLowTo() {
        int expected = (int) round(50000 * percent(1));
        assertThat(calculator.calculateTransferFee(50000, 150000, 60000, false), is(expected));
    }

    private static double percent(double percentage) {
        return percentage / 100;
    }

}
