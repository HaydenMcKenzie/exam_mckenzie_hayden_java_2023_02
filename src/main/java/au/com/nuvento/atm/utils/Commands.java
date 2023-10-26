package au.com.nuvento.atm.utils;


import au.com.nuvento.atm.ATM;
import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;

import java.io.FileNotFoundException;

import static au.com.nuvento.atm.ATM.bankAccount;

public class Commands {
    /**
     * New Balance Class allows you to input an amount and add/minus from existing account
     * @param userName is user input and is either 001, 002 or 003 - for userID
     * @param options is user input and is either 1 or 2           - for Cheque or Savings accounts
     * @param userOption is user input and is either 1 or 2        - for Deposit or Withdraw
     * @param userAmount is user input and presents what is needed to either be added or taken away
     * @return new balance or old balance                          - old balance is only if there is an input error
     */
    public double newBalance(String userName, String options, String userOption, double userAmount) throws FileNotFoundException {
        BankBuilder selectAccount = new BankBuilder();

        String grabAccountInfo = selectAccount.selectAccount(userName, options);
        BankAccount b = bankAccount.get(grabAccountInfo);

        double balance = Double.parseDouble(b.getOpeningBalance());

        switch (userOption) {
            case "1":
                return balance + userAmount;
            case "2":
                return balance - userAmount;
            default:
                System.out.println("ERROR: You didn't enter a number");
                ATM.setup();
                ATM.userInteraction();
        }
        return balance;
    }

    /**
     * New Write Balance
     * @param userName is user input and is either 001, 002 or 003 - for userID
     * @param options is user input and is either 1 or 2           - for Cheque or Savings accounts
     * @return Opening Balance of selected account
     */
    public String newWriteBal(String userName, String options) {
        BankBuilder selectAccount = new BankBuilder();

        String grabAccountInfo = selectAccount.selectAccount(userName, options);
        BankAccount b = bankAccount.get(grabAccountInfo);

        return b.getOpeningBalance();
    }
}
