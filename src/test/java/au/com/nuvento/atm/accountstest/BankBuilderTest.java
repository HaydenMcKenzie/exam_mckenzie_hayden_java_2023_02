package au.com.nuvento.atm.accountstest;


import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;
import au.com.nuvento.atm.handlefiles.ReadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankBuilderTest {
    ReadFile readFile;
    String Deposit;
    String Withdraw;
    String Balance;
    String johnsFirstAccount;
    String johnsSecondAccount;
    String leanneFirstAccount;
    String leanneSecondAccount;
    String kimOnlyAccount;

    public static List<String[]> accountData;

    @BeforeEach
    public void setup() throws FileNotFoundException {
        readFile = new ReadFile();
        accountData = readFile.getContentsFromFile("data/OpeningAccountsData.txt", "\\|\\|\\|");
    }

    @Test
    public void callAccountNumberFromInput1or2ForJohnSmith() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankBuilder account = new BankBuilder();
        johnsFirstAccount = account.selectAccount("001", "1");
        johnsSecondAccount = account.selectAccount("001", "2");

        // testing recall of first and second account for John
        BankAccount johnAccountOne = bankAccounts.get(johnsFirstAccount);
        assertEquals(johnAccountOne.getAccountNumber(), johnsFirstAccount);

        BankAccount johnAccountTwo = bankAccounts.get(johnsSecondAccount);
        assertEquals(johnAccountTwo.getAccountNumber(), johnsSecondAccount);
    }

    @Test
    public void callAccountNumberFromInput1or2ForLeanneSmith() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankBuilder account = new BankBuilder();
        leanneFirstAccount = account.selectAccount("002", "1");
        leanneSecondAccount = account.selectAccount("002", "2");

        // testing recall of first and second account for Leanne
        BankAccount leanneAccountOne = bankAccounts.get(leanneFirstAccount);
        assertEquals(leanneAccountOne.getAccountNumber(), leanneFirstAccount);

        BankAccount leanneAccountTwo = bankAccounts.get(leanneSecondAccount);
        assertEquals(leanneAccountTwo.getAccountNumber(), leanneSecondAccount);
    }

    @Test
    public void callAccountNumberFromKim() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankBuilder account = new BankBuilder();
        kimOnlyAccount = account.selectAccount("003", "1");

        // testing recall of first and second account for Kim
        BankAccount kimAccountOne = bankAccounts.get(kimOnlyAccount);
        assertEquals(kimAccountOne.getAccountNumber(), kimOnlyAccount);
    }

    @Test
    public void callingAtmOperations() {
        // Setting Operations
        BankBuilder account = new BankBuilder();
        Deposit = account.accountSelect("1");
        Withdraw = account.accountSelect("2");
        Balance = account.accountSelect("3");

        // Testing Operations
        assertEquals(Deposit, "Deposit");
        assertEquals(Withdraw, "Withdraw");
        assertEquals(Balance, "Balance");
    }

    @Test
    public void callBankInfoForJohnsFirstAccount() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankAccount b = bankAccounts.get("9264945");
        assertEquals(b.getAccountOwnerID(), "001");
        assertEquals(b.getAccountNumber(), "9264945");
        assertEquals(b.getAccountType(), "Cheque");
        assertEquals(b.getOpeningBalance(), "500.09");
    }

    @Test
    public void callBankInfoForJohnsSecondAccount() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankAccount b = bankAccounts.get("7814135");
        assertEquals(b.getAccountOwnerID(), "001");
        assertEquals(b.getAccountNumber(), "7814135");
        assertEquals(b.getAccountType(), "Saving");
        assertEquals(b.getOpeningBalance(), "200.09");
    }

    @Test
    public void callBankInfoForLeanneFirstAccount() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankAccount b = bankAccounts.get("9676422");
        assertEquals(b.getAccountOwnerID(), "002");
        assertEquals(b.getAccountNumber(), "9676422");
        assertEquals(b.getAccountType(), "Saving");
        assertEquals(b.getOpeningBalance(), "1200.00");
    }

    @Test
    public void callBankInfoForLeaneSecondAccount() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankAccount b = bankAccounts.get("7524155");
        assertEquals(b.getAccountOwnerID(), "002");
        assertEquals(b.getAccountNumber(), "7524155");
        assertEquals(b.getAccountType(), "Cheque");
        assertEquals(b.getOpeningBalance(), "50.00");
    }

    @Test
    public void callBankInfoForKimOnlyAccount() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankAccount b = bankAccounts.get("9042221");
        assertEquals(b.getAccountOwnerID(), "003");
        assertEquals(b.getAccountNumber(), "9042221");
        assertEquals(b.getAccountType(), "Saving");
        assertEquals(b.getOpeningBalance(), "4000.20");
    }
}