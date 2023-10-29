package au.com.nuvento.atm.utilstest;

import au.com.nuvento.atm.ATM;
import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.utils.Commands;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static au.com.nuvento.atm.ATM.bankAccount;

public class CommandsTest {
    Commands c;
    BankAccount bal;


    @BeforeEach
    public void setup() throws FileNotFoundException {
        ATM.setup();
        c = new Commands();
        bal = bankAccount.get("9264945");
    }

    @Test
    public void testNewBalanceForAdding() throws FileNotFoundException {
        double addResult = c.newBalance("001", "1","1", "10");
        assertEquals(addResult, 510.09);
    }
    @Test
    public void testNewBalanceForMinus() throws FileNotFoundException {
        double minusResult = c.newBalance("001", "1","2", "10");
        assertEquals(minusResult, 490.09);
    }

    @Test
    public void TestNewWrittenBalanceForJohnsFirstAccount() {
        String result = c.newWriteBal("001", "1");
        assertEquals(result, bal.getOpeningBalance());
    }
}
