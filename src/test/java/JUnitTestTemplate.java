import DataCreation.DataCreation;
import atm.ATM;
import atm.Session;
import bank.AccountEntry;
import bank.BankDatabase;
import bank.CustomerEntry;
import banking.BankClerk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JUnitTestTemplate {
    DataCreation data = new DataCreation();
    @Before
    public void CreateData(){
        data.CreateData();
    }

    @After
    public void resetData(){
        data.resetData();
    }

    @Test
    public void wrongPINTest(){
        ATM atm = new ATM()
        Session session = new Session()
    }
}
