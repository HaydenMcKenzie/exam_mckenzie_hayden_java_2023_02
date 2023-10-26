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
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BankBuilderTest {
    ReadFile readFile;
    public static List<String[]> accountData;

    @BeforeEach
    public void setup() throws FileNotFoundException {
        readFile = new ReadFile();
        accountData = readFile.getContentsFromFile("data/OpeningAccountsData.txt", "\\|\\|\\|");
    }

    @Test
    public void callAccountNumberFromInput1or2ForJohnSmithFromOpeningAccountData() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankBuilder selectAccount = new BankBuilder();
        String johnsFirstAccount = selectAccount.selectAccount("001", "1");
        String johnsSecondAccount = selectAccount.selectAccount("001", "2");
        String LeanneSecondAccount = selectAccount.selectAccount("002", "2");

        //testing recall of first account for John
        BankAccount c = bankAccounts.get(johnsFirstAccount);
        assertEquals(c.getAccountNumber(), johnsFirstAccount);
        assertNotEquals(c.getAccountNumber(), johnsSecondAccount);
        assertNotEquals(c.getAccountNumber(), LeanneSecondAccount);

        //testing recall of second account for John
        BankAccount d = bankAccounts.get(johnsSecondAccount);
        assertEquals(d.getAccountNumber(), johnsSecondAccount);
        assertNotEquals(d.getAccountNumber(), johnsFirstAccount);
        assertNotEquals(d.getAccountNumber(), LeanneSecondAccount);
    }
    @Test
    public void callAccountNumberFromInput1or2ForLeanneSmithFromOpeningAccountData() throws FileNotFoundException {
        BankBuilder bankBuilder = new BankBuilder();
        HashMap<String, BankAccount> bankAccounts = bankBuilder.createBank(accountData);

        BankBuilder selectAccount = new BankBuilder();
        String LeanneFirstAccount = selectAccount.selectAccount("002", "1");
        String LeanneSecondAccount = selectAccount.selectAccount("002", "2");
        String JohnSecondAccount = selectAccount.selectAccount("001", "2");

        //testing recall of first account for Leanne
        BankAccount c = bankAccounts.get(LeanneFirstAccount);
        assertEquals(c.getAccountNumber(), LeanneFirstAccount);
        assertNotEquals(c.getAccountNumber(), LeanneSecondAccount);
        assertNotEquals(c.getAccountNumber(), JohnSecondAccount);

        //testing recall of second account for Leanne
        BankAccount d = bankAccounts.get(LeanneSecondAccount);
        assertEquals(d.getAccountNumber(), LeanneSecondAccount);
        assertNotEquals(d.getAccountNumber(), LeanneFirstAccount);
        assertNotEquals(d.getAccountNumber(), JohnSecondAccount);
    }

}