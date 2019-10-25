package bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.lang.Math.round;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import banking.exceptions.*;

@RunWith(JUnit4.class)
public class FeesCalculatorDepositTest {

    private FeesCalculator calculator;

    @Before
    public void beforeEach() {
        calculator = new FeesCalculator();
    }
    
    //Test case DT1
    @Test
    public void depositWhenStudentLowDepositLowBalance() {
    	boolean student = true;
    	int deposit = 50;
    	int balance = 500;
    	double percent = 0;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit * 100, balance * 100, student) / 100, is(expected));
    }

  //Test case DT2
    @Test
    public void depositWhenMpmStudentLowDepositLowBalance() {
    	boolean student = false;
    	int deposit = 250;
    	int balance = 1500;
    	double percent = 0;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit * 100, balance * 100, student) / 100, is(expected));
    }

  //Test case DT3
    @Test
    public void depositWhenNonStudentLowDepositLowBalance() {
    	boolean student = false;
    	int deposit = 500;
    	int balance = 7500;
    	double percent = 0;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit * 100, balance * 100, student) / 100, is(expected));
    }

  //Test case DT4
    @Test
    public void depositWhenNonStudentHighDepositHighBalance() {
    	boolean student = false;
    	int deposit = 1000;
    	int balance = 20000;
    	double percent = 1;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit * 100, balance * 100, student) / 100, is(expected));
    }

    private static double percent(double percentage) {
        return percentage / 100;
    }

}