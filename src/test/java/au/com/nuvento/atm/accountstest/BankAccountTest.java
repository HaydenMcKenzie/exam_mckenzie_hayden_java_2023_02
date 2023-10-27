package au.com.nuvento.atm.accountstest;

import au.com.nuvento.atm.accounts.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;

public class BankAccountTest {
    BankAccount bank;

    @BeforeEach
    void setUp() {
        bank = new BankAccount("004", "1234567", "Saving", "500");
    }

    @Test
    void getAccountOwnerID() {
        assertTrue(bank.getAccountOwnerID().equalsIgnoreCase("004"));
    }

    @Test
    void setAccountOwnerID() {
        bank.setAccountOwnerID("005");
        assertTrue(bank.getAccountOwnerID().equalsIgnoreCase("005"));
    }

    @Test
    void getAccountNumber() {
        assertTrue(bank.getAccountNumber().equalsIgnoreCase("1234567"));
    }

    @Test
    void setAccountNumber() {
        bank.setAccountNumber("0123456");
        assertTrue(bank.getAccountNumber().equalsIgnoreCase("0123456"));
    }

    @Test
    void getAccountType() {
        assertTrue(bank.getAccountType().equalsIgnoreCase("Saving"));
    }

    @Test
    void setAccountType() {
        bank.setAccountType("Cheque");
        assertTrue(bank.getAccountType().equalsIgnoreCase("Cheque"));
    }

    @Test
    void getOpeningBalance() {
        assertTrue(bank.getOpeningBalance().equalsIgnoreCase("500"));
    }

    @Test
    void setOpeningBalance() {
        bank.setOpeningBalance("600");
        assertTrue(bank.getOpeningBalance().equalsIgnoreCase("600"));
    }
}
