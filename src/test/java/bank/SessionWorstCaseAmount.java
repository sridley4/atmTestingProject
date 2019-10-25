package bank;

import atm.ATM;
import atm.Session;
import banking.Money;
import banking.exceptions.InvalidAmountException;
import banking.exceptions.InvalidPINException;
import banking.exceptions.InvalidTransactionChoiceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SessionWorstCaseAmount {

    @Test(expected = InvalidAmountException.class)
    public void testNegativeWithdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 134, "123", 0, 1, 0, new Money(-1,0));
        Session session = new Session(theATM, 134, "123", 0, 1, 0, new Money(-1,0));
        session.performSession();
    }

    @Test(expected = InvalidAmountException.class)
    public void testZeroWithdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 345, "123", 0, 1, 0, new Money(0,0));
        Session session = new Session(theATM, 345, "123", 0, 1, 0, new Money(0,0));
        session.performSession();
    }

    @Test(expected = InvalidAmountException.class)
    public void testNotMultipleWithdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 576, "123", 0, 1, 0, new Money(5,0));
        Session session = new Session(theATM, 576, "123", 0, 1, 0, new Money(5,0));
        session.performSession();
    }

    @Test
    public void test50Withdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 890, "123", 0, 1, 0, new Money(50,0));
        Session session = new Session(theATM, 890, "123", 0, 1, 0, new Money(50,0));
        session.performSession();
    }

    @Test
    public void test20Withdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 765, "123", 0, 1, 0, new Money(20,0));
        Session session = new Session(theATM, 765, "123", 0, 1, 0, new Money(20,0));
        session.performSession();
    }

    @Test
    public void test500Withdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 453, "123", 0, 1, 0, new Money(500,0));
        Session session = new Session(theATM, 453, "123", 0, 1, 0, new Money(500,0));
        session.performSession();
    }

    @Test(expected = InvalidAmountException.class)
    public void test980Withdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 897, "123", 0, 1, 0, new Money(980,0));
        Session session = new Session(theATM, 897, "123", 0, 1, 0, new Money(980,0));
        session.performSession();
    }

    @Test
    public void test1000Withdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 573, "123", 0, 1, 0, new Money(980,0));
        Session session = new Session(theATM, 573, "123", 0, 1, 0, new Money(980,0));
        session.performSession();
    }

    @Test(expected = InvalidAmountException.class)
    public void test1020Withdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 536, "123", 0, 1, 0, new Money(980,0));
        Session session = new Session(theATM, 536, "123", 0, 1, 0, new Money(980,0));
        session.performSession();
    }

//    @Test(expected = InvalidAmountException.class)
//    public void testInvalidTwoWithdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
//        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
//                null, true, 675, "123", 0, 1, 0, new Money(500,0));
//        Session session = new Session(theATM, 675, "123", 0, 1, 0, new Money(500,0));
//        session.performSession();
//
//        theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
//                null, true, 675, "123", 0, 1, 0, new Money(550,0));
//        session = new Session(theATM, 675, "123", 0, 1, 0, new Money(550,0));
//        session.performSession();
//    }
//
//    @Test
//    public void testValidTwoWithdrawal() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
//        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
//                null, true, 566, "123", 0, 1, 0, new Money(400,0));
//        Session session = new Session(theATM, 566, "123", 0, 1, 0, new Money(400,0));
//        session.performSession();
//
//        theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
//                null, true, 566, "123", 0, 1, 0, new Money(360,0));
//        session = new Session(theATM, 566, "123", 0, 1, 0, new Money(360,0));
//        session.performSession();
//    }
}
