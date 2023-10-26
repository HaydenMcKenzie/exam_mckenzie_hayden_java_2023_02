package au.com.nuvento.atm.messages;

import au.com.nuvento.atm.ATM;
import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;
import au.com.nuvento.atm.accounts.Client;

import java.io.FileNotFoundException;

import static au.com.nuvento.atm.ATM.bankAccount;
import static au.com.nuvento.atm.ATM.clients;

public class Interactions {
    /**
     * Welcome Interaction
     * It is an easy call to INITAL message from AtmMessages
     * @return INITIAL message
     */
    public void welcomeInteraction() {
        AtmMessages welcomeMessage = AtmMessages.INITAL;

        System.out.println(welcomeMessage.getActions());
    }

    /**
     * User Decision
     * @param userName is user input and is either 001, 002 or 003  - for userID
     * @return Welcome message with First and Last name as well account options
     */
    public void userDecision(String userName) throws FileNotFoundException {
        AtmMessages myOptions = AtmMessages.OPTIONS;

        Client c = clients.get(userName);
        System.out.println("Welcome " + c.getFirstName() + " "  + c.getSurname() + ". Please enter an Option"); // Testing getting name from ClientBuilder
        System.out.println(myOptions.getActions());
    }

    /**
     * Grab Information
     * @param userOption is user input and is either 1, 2 or 3        - for Deposit or Withdraw
     * @return Deposit for "1", Withdraw for "2" or Balance for "3"
     */
    public String grabInfo(String userOption) {
        BankBuilder selectAccount = new BankBuilder(); // import selectAccount
        return selectAccount.accountSelect(userOption);
    }

    /**
     * Show Account
     * @param userName is user input and is either 001, 002 or 003    - for userID
     * @param userOption is user input and is either 1, 2 or 3        - for Deposit or Withdraw
     * @return If it is 001 or 002, print both accounts, else, print one account
     */
    public void showAccount(String userName, String userOption) {
        BankBuilder account = new BankBuilder();

        System.out.println("Which account do you want to " + grabInfo(userOption) + " from:");

        String firstAccount = account.selectAccount(userName, "1");
        String secondAccount = account.selectAccount(userName, "2");
        BankAccount x = bankAccount.get(firstAccount);
        BankAccount y = bankAccount.get(secondAccount);

        switch (userName) {
            case "001":
            case "002":
                System.out.println("1 for " + x.getAccountNumber() + " (" + x.getAccountType() + ")");
                System.out.println("2 for " + y.getAccountNumber() + " (" + y.getAccountType() + ")");
                break;
            case "003":
                System.out.println("1 for " + x.getAccountNumber() + " (" + x.getAccountType() + ")");
                break;
        }

    }

    /**
     * Enter In Account
     * @param userName is user input and is either 001, 002 or 003    - for userID
     * @param options is user input and is either 1 or 2              - for Cheque or Savings accounts
     * @param userOption is user input and is either 1, 2 or 3        - for Deposit or Withdraw
     * @throws FileNotFoundException Thrown if file not in path
     * @return Prompt for Deposit/Withdraw and or Balance of account
     */
    public void enterInAccount(String userName, String options, String userOption) throws FileNotFoundException {
        BankBuilder account = new BankBuilder(); // import selectAccount

        String grabAccountInfo = account.selectAccount(userName, options);
        BankAccount b = bankAccount.get(grabAccountInfo);

        switch (userOption) {
            case "1":
            case "2":
                System.out.println("How much do you wish to " + grabInfo(userOption) + "? Balance = $" + b.getOpeningBalance());
                break;
            case "3":
                System.out.println("Your account balance is: $" + b.getOpeningBalance());
                ATM.setup();
                ATM.userInteraction();
        }
    }

    public String invalidAmountEntered(String userName, String options, double userEnteredAmount) {
        BankBuilder account = new BankBuilder(); // import selectAccount

        String grabAccountInfo = account.selectAccount(userName, options);
        BankAccount b = bankAccount.get(grabAccountInfo);

        return "Error - Wrong Input. Amount entered ($" + userEnteredAmount + ") is greater than amount in account ($" + b.getOpeningBalance() + ") ";
    }
}
