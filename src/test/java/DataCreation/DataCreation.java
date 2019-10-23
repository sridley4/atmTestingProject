package DataCreation;

import bank.AccountEntry;
import bank.BankDatabase;
import bank.CustomerEntry;

public class DataCreation {
    private BankDatabase bankDatabase;

    public DataCreation(){
        bankDatabase = BankDatabase.getInstance();
    }

    public void CreateData(){
        int customerID;
        BankDatabase bankDatabase = BankDatabase.getInstance();
        bankDatabase.addCustomer(new CustomerEntry(0, "Someone", "Something", true, 0100202030, 1234));
        try {
            customerID = bankDatabase.getCustomerInfo(Integer.parseInt("0100202030")).getID();
        } catch (BankDatabase.CustomerNotFound e) {
            System.out.println("Something is wrong with the database.");
            return;
        }
        try{
            bankDatabase.addAccount(0, new AccountEntry(customerID, "0", 5000, 5000, 1000, 0));
        } catch (BankDatabase.AccountNotFound e){
            System.out.println("Customer could not be found for account creation");
            return;
        }

    }

    public void resetData(){
        int customerID;
        try {
            customerID = bankDatabase.getCustomerInfo(Integer.parseInt("0100202030")).getID();
        } catch (BankDatabase.CustomerNotFound e) {
            System.out.println("Something is wrong with the database.");
            return;
        }
        try{
            bankDatabase.updateAccountInfo(0, new AccountEntry(customerID, "0", 5000, 5000, 1000, 0));
        } catch (BankDatabase.AccountNotFound e){
            System.out.println("Customer could not be found for account creation");
            return;
        }
    }


}
