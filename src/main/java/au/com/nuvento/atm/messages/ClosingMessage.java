package au.com.nuvento.atm.messages;

import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;

import static au.com.nuvento.atm.ATM.bankAccount;



public class ClosingMessage {

    public void endMessage()   {
        BankBuilder account = new BankBuilder();

        // John
        String johnFirstAccount = account.selectAccount("001", "1");
        String johnSecondAccount = account.selectAccount("001", "2");
        BankAccount jOne = bankAccount.get(johnFirstAccount);
        BankAccount jTwo = bankAccount.get(johnSecondAccount);

        // Leanne
        String leanneFirstAccount = account.selectAccount("002", "1");
        String leanneSecondAccount = account.selectAccount("002", "2");
        BankAccount lOne = bankAccount.get(leanneFirstAccount);
        BankAccount lTwo = bankAccount.get(leanneSecondAccount);

        // Kim
        String KimOnlyAccount = account.selectAccount("003", "1");
        BankAccount kOne = bankAccount.get(KimOnlyAccount);

        // Print all
        System.out.println("John's Accounts");
        System.out.println("First Account: $" + jOne.getOpeningBalance());
        System.out.println("Second Account: $" + jTwo.getOpeningBalance() + "\n");
        System.out.println("Leanne's Accounts");
        System.out.println("First Account: $" + lOne.getOpeningBalance());
        System.out.println("Second Account: $" + lTwo.getOpeningBalance() + "\n");
        System.out.println("Kim's Accounts");
        System.out.println("First Account: $" + kOne.getOpeningBalance());
    }
}
