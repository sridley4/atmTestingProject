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
public class SessionWorstCasePIN {

    @Test(expected = InvalidPINException.class)
    public void wrong3PINTest() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 456, "123", 0, 100, 100, new Money(50,0));
        Session session = new Session(theATM, 456, "123", 0, 0, 0, new Money(50,0));
        session.performSession();
    }

    @Test(expected = InvalidPINException.class)
    public void wrong4PINTest() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 456, "1235", 0, 100, 100, new Money(50,0));
        Session session = new Session(theATM, 456, "1235", 0, 0, 0, new Money(50,0));
        session.performSession();
    }

    @Test
    public void right4PINTest() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 456, "1234", 0, 100, 100, new Money(50,0));
        Session session = new Session(theATM, 456, "1234", 0, 0, 0, new Money(50,0));
        try{
            session.performSession();
        } catch (InvalidPINException e){
            Assert.fail();
        }
    }

    @Test(expected = InvalidPINException.class)
    public void wrong5PINTest() throws InvalidTransactionChoiceException, InvalidAmountException, InvalidPINException {
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null, true, 456, "12345", 0, 100, 100, new Money(50,0));
        Session session = new Session(theATM, 456, "12345", 0, 0, 0, new Money(50,0));
        session.performSession();
    }
}
