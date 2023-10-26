package au.com.nuvento.atm.accountstest;

import au.com.nuvento.atm.accounts.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;

public class ClientTest {
    Client client;
    
    @BeforeEach
    void setUp() {
        client = new Client("Hayden", "McKenzie", "0412345678", "004");
    }

    @Test
    void getFirstName() {
        assertTrue(client.getFirstName().equalsIgnoreCase("Hayden"));
    }

    @Test
    void setFirstName() {
        client.setFirstName("Daniel");
        assertTrue(client.getFirstName().equalsIgnoreCase("Daniel"));
    }
}
