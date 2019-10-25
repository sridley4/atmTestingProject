package bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.lang.Math.round;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class FeesCalculatorWithdrawTest {

    private FeesCalculator calculator;

    @Before
    public void beforeEach() {
        calculator = new FeesCalculator();
    }



    @Test
    public void withdrawWhenStudentIsNegativeWeekday() {
        int expected = (int) round(-100 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(-100, 100000, true, 3), is(expected));
    }
    @Test
    public void withdrawWhenStudentIsZeroWeekday() {
        int expected = (int) round(0 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(0, 100000, true, 3), is(expected));
    }
    @Test
    public void withdrawWhenStudentIsPositiveWeekday() {
        int expected = (int) round(10000 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(10000, 100000, true, 3), is(expected));
    }

    @Test
    public void withdrawWhenStudentIsNegativeWeekend() {
        int expected = (int) round(-100 * percent(0.00));
        assertThat(calculator.calculateWithdrawalFee(-100, 100000, true, 1), is(expected));
    }
    @Test
    public void withdrawWhenStudentIsZeroWeekend() {
        int expected = (int) round(0 * percent(0.00));
        assertThat(calculator.calculateWithdrawalFee(0, 100000, true, 1), is(expected));
    }
    @Test
    public void withdrawWhenStudentIsPositiveWeekend() {
        int expected = (int) round(10000 * percent(0.00));
        assertThat(calculator.calculateWithdrawalFee(10000, 100000, true, 1), is(expected));
    }


    @Test
    public void withdrawWhenNonStudentIsNegativeBelow() {
        int expected = (int) round(-500 * percent(0.20));
        assertThat(calculator.calculateWithdrawalFee(-500, -100, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentIsZero() {
        int expected = (int) round(0 * percent(0.20));
        assertThat(calculator.calculateWithdrawalFee(0, 0, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentIsAt1Below() {
        int expected = (int) round(100 * percent(0.20));
        assertThat(calculator.calculateWithdrawalFee(100, 100, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat500Below() {
        int expected = (int) round(40000 * percent(0.20));
        assertThat(calculator.calculateWithdrawalFee(40000, 50000, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat999Below() {
        int expected = (int) round(50000 * percent(0.20));
        assertThat(calculator.calculateWithdrawalFee(50000, 99900, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat1000Below() {
        int expected = (int) round(50000 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(50000, 100000, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat1001Below() {
        int expected = (int) round(50000 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(50000, 100100, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat5000Below() {
        int expected = (int) round(50000 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(50000, 500000, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat9999Below() {
        int expected = (int) round(50000 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(50000, 999900, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat10000Below() {
        int expected = (int) round(50000 * percent(0.00));
        assertThat(calculator.calculateWithdrawalFee(50000, 1000000, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat10001Below() {
        int expected = (int) round(50000 * percent(0.00));
        assertThat(calculator.calculateWithdrawalFee(50000, 1000100, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat30000Below() {
        int expected = (int) round(50000 * percent(0.00));
        assertThat(calculator.calculateWithdrawalFee(50000, 3000000, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentIsNegativeAbove() {
        int expected = (int) round(10000 * percent(0.20));
        assertThat(calculator.calculateWithdrawalFee(10000, -100, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentIsZeroAbove() {
        int expected = (int) round(10000 * percent(0.20));
        assertThat(calculator.calculateWithdrawalFee(10000, 0, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentIsAt1Above() {
        int expected = (int) round(10000 * percent(0.20));
        assertThat(calculator.calculateWithdrawalFee(10000, 100, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat500Above() {
        int expected = (int) round(50100 * percent(0.20));
        assertThat(calculator.calculateWithdrawalFee(50100, 50000, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat999Above() {
        int expected = (int) round(100000 * percent(0.20));
        assertThat(calculator.calculateWithdrawalFee(100000, 99900, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat1000Above() {
        int expected = (int) round(100100 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(100100, 100000, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat1001Above() {
        int expected = (int) round(100200 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(100200, 100100, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat5000Above() {
        int expected = (int) round(500100 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(500100, 500000, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat9999Above() {
        int expected = (int) round(1000000 * percent(0.10));
        assertThat(calculator.calculateWithdrawalFee(1000000, 999900, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat10000Above() {
        int expected = (int) round(1000100 * percent(0.00));
        assertThat(calculator.calculateWithdrawalFee(1000100, 1000000, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat10001Above() {
        int expected = (int) round(1000200 * percent(0.00));
        assertThat(calculator.calculateWithdrawalFee(1000200, 1000100, false, 0), is(expected));
    }

    @Test
    public void withdrawWhenNonStudentat30000Above() {
        int expected = (int) round(3000100 * percent(0.00));
        assertThat(calculator.calculateWithdrawalFee(3000100, 3000000, false, 0), is(expected));
    }

    private static double percent(double percentage) {
        return percentage / 100;
    }

}
