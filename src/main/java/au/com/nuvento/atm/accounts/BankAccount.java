package au.com.nuvento.atm.accounts;

public class BankAccount {

    // Initialization
    String AccountOwnerID;
    String AccountNumber;
    String AccountType;
    String OpeningBalance;


    // Getter & Setter AccountOwnerID
    public String getAccountOwnerID() { return AccountOwnerID; }

    public void setAccountOwnerID(String accountOwnerID) { AccountOwnerID = accountOwnerID; }

    // Getter & Setter AccountNumber
    public String getAccountNumber() { return AccountNumber; }

    public void setAccountNumber(String accountNumber) { AccountNumber = accountNumber; }

    // Getter & Setter AccountType
    public String getAccountType() { return AccountType; }

    public void setAccountType(String accountType) { AccountType = accountType; }

    // Getter & Setter OpeningBalance
    public String getOpeningBalance() { return OpeningBalance; }

    public void setOpeningBalance(String openingBalance) { OpeningBalance = openingBalance; }


    // Main Function
    public BankAccount(String accountOwnerID, String accountNumber, String accountType, String openingBalance) {
        AccountOwnerID = accountOwnerID;
        AccountNumber = accountNumber;
        AccountType = accountType;
        OpeningBalance = openingBalance;
    }
}