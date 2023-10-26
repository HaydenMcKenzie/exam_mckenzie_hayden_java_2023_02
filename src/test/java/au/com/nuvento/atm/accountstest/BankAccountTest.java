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
    void getAccountNumber() {
        assertTrue(bank.getAccountNumber().equalsIgnoreCase("1234567"));
    }

    @Test
    void setAccountNumber() {
        bank.setAccountNumber("0123456");
        assertTrue(bank.getAccountNumber().equalsIgnoreCase("0123456"));
    }
}
