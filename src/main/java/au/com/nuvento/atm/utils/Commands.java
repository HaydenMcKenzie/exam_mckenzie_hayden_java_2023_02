package au.com.nuvento.atm.utils;


import au.com.nuvento.atm.ATM;
import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;
import au.com.nuvento.atm.messages.AtmMessages;

import java.io.FileNotFoundException;

import static au.com.nuvento.atm.ATM.bankAccount;

public class Commands {
    BankBuilder account = new BankBuilder();
    /**
     * New Balance Class allows you to input an amount and add/minus from existing account
     * @param userName is user input and is either 001, 002 or 003 - for userID
     * @param options is user input and is either 1 or 2           - for Cheque or Savings accounts
     * @param userOption is user input and is either 1 or 2        - for Deposit or Withdraw
     * @param userAmount is user input and presents what is needed to either be added or taken away
     * @return new balance or old balance                          - old balance is only if there is an input error
     */
    public double newBalance(String userName, String options, String userOption, String userAmount) throws FileNotFoundException {
        String grabAccountInfo = account.selectAccount(userName, options);
        BankAccount b = bankAccount.get(grabAccountInfo);
        AtmMessages errorMessage = AtmMessages.ERROR;

        if (!(Verification.isStringDouble(userAmount))) {
            System.out.println(errorMessage.getActions());
            ATM.setup();
            ATM.userInteraction();
        }

        double enteredAmount = Double.parseDouble(userAmount);
        double balance = Double.parseDouble(b.getOpeningBalance());

        switch (userOption) {
            case "1":
                return balance + enteredAmount;
            case "2":
                return balance - enteredAmount;
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
        String grabAccountInfo = account.selectAccount(userName, options);
        BankAccount b = bankAccount.get(grabAccountInfo);

        return b.getOpeningBalance();
    }
}
