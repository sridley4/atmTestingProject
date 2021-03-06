/* * ATM Example system - file Deposit.java    * * copyright (c) 2001 - Russell C. Bjork * */ package atm.transaction;import atm.ATM;import atm.Session;import atm.physical.CustomerConsole;import banking.AccountInformation;import banking.Card;import banking.Message;import banking.Money;import banking.Receipt;import banking.Success;import banking.exceptions.InvalidAmountException;/** Representation for a deposit transaction *//** * @author ktsiouni * */public class Deposit extends Transaction{    /** Constructor     *     *  @param atm the ATM used to communicate with customer     *  @param session the session in which the transaction is being performed     *  @param card the customer's card     *  @param pin the PIN entered by the customer     */    public Deposit(ATM atm, Session session, Card card, int pin)    {        super(atm, session, card, pin);    }        /** Constructor for testing     * Overriden for CS4472 testing    *    *  @param atm the ATM used to communicate with customer    *  @param session the session in which the transaction is being performed    *  @param card the customer's card    *  @param pin the PIN entered by the customer    *  @param testing value indicating whether testing is performed    */    public Deposit(ATM atm, Session session, Card card, int pin, boolean testing) {    	super(atm, session, card, pin, testing);	}	/** Get specifics for the transaction from the customer     *     *  @return message to bank for initiating this transaction     *  @exception CustomerConsole.Cancelled if customer cancelled this transaction     */    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled    {        to = atm.getCustomerConsole().readMenuChoice(            "Account to deposit to",            AccountInformation.ACCOUNT_NAMES);                amount = atm.getCustomerConsole().readAmount("Amount to deposit");        while (!BankNotesValidator.checkDepositNotes(amount)) {         	amount = atm.getCustomerConsole().readAmount("Invalid amount. Can only deposit 10s, 20s \nor 50s.\n" +         												 "Amount to deposit");        }         return new Message(Message.INITIATE_DEPOSIT,                           card, pin, serialNumber, -1, to, amount);    }	protected Message getSpecificsFromParameters(int from, int to, Money amount) throws InvalidAmountException{		this.to = to;    	this.amount = amount;    	    	if (!BankNotesValidator.checkDepositNotes(amount))    		throw new InvalidAmountException();				return new Message(Message.INITIATE_DEPOSIT,                card, pin, serialNumber, -1, to, amount);	}	    /** Complete an approved transaction     *     *  @return receipt to be printed for this transaction     *  @exception CustomerConsole.Cancelled if customer cancelled or      *             transaction timed out     */    protected Receipt completeTransaction(Success status) throws CustomerConsole.Cancelled    {        atm.getEnvelopeAcceptor().acceptEnvelope();        Success newStatus = (Success) atm.getNetworkToBank().sendMessage(            new Message(Message.COMPLETE_DEPOSIT,                        card, pin, serialNumber, -1, to, amount));                    return new Receipt(this.atm, this.card, this, newStatus.getAccountInfo()) {            {                detailsPortion = new String[2];                detailsPortion[0] = "DEPOSIT TO: " +                                     AccountInformation.ACCOUNT_ABBREVIATIONS[to];                detailsPortion[1] = "AMOUNT: " + amount.toString();            }        };    }        /** Account to deposit to     */     private int to;        /** Amount of money to deposit     */    private Money amount;            }