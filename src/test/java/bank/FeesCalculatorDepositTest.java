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

//	public int calculateDepositInterest(int amount, int accountBalance, boolean student) {
	
    private FeesCalculator calculator;

    @Before
    public void beforeEach() {
        calculator = new FeesCalculator();
    }

    @Test
    public void depositWhenStudentHighDepositHighBalance() {
    	boolean student = true;
    	int deposit = 200;
    	int balance = 1500;
    	double percent = 1;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit, balance, student), is(expected));
    }

    @Test
    public void depositWhenStudentHighDepositLowBalance() {
    	boolean student = true;
    	int deposit = 200;
    	int balance = 500;
    	double percent = 0.5;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit, balance, student), is(expected));
    }

    @Test
    public void depositWhenStudentLowDepositHighBalance() {
    	boolean student = true;
    	int deposit = 50;
    	int balance = 10000;
    	double percent = 0.5;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit, balance, student), is(expected));
    }

    @Test
    public void depositWhenStudentLowDepositLowBalance() {
    	boolean student = true;
    	int deposit = 50;
    	int balance = 1000;
    	double percent = 0;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit, balance, student), is(expected));
    }

    @Test(expected = InvalidAmountException.class)
    public void depositWhenStudentInvalidDeposit() {
    	boolean student = true;
    	int deposit = 50;
    	int balance = 1000;
        calculator.calculateDepositInterest(deposit, balance, student);
    }

    @Test
    public void depositWhenNonStudentHighDepositHighBalance() {
    	boolean student = false;
    	int deposit = 1000;
    	int balance = 10000;
    	double percent = 1;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit, balance, student), is(expected));
    }

    @Test
    public void depositWhenNonStudentHighDepositLowBalance() {
    	boolean student = false;
    	int deposit = 1000;
    	int balance = 2500;
    	double percent = 0.5;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit, balance, student), is(expected));
    }

    @Test
    public void depositWhenNonStudentLowDepositHighBalance() {
    	boolean student = false;
    	int deposit = 250;
    	int balance = 20000;
    	double percent = 0.5;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit, balance, student), is(expected));
    }

    @Test
    public void depositWhenNonStudentLowDepositLowBalance() {
    	boolean student = false;
    	int deposit = 250;
    	int balance = 5000;
    	double percent = 0;
        int expected = (int) round(deposit * percent(percent));
        assertThat(calculator.calculateDepositInterest(deposit, balance, student), is(expected));
    }

    @Test(expected = InvalidAmountException.class)
    public void depositWhenNonStudentInvalidDeposit() {
    	boolean student = false;
    	int deposit = 50;
    	int balance = 1000;
        calculator.calculateDepositInterest(deposit, balance, student);
    }

    private static double percent(double percentage) {
        return percentage / 100;
    }

}