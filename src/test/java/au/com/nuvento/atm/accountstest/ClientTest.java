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

    @Test
    void getSurname() {
        assertTrue(client.getSurname().equalsIgnoreCase("McKenzie"));
    }

    @Test
    void setSurname() {
        client.setSurname("D'Angelo");
        assertTrue(client.getSurname().equalsIgnoreCase("D'Angelo"));
    }

    @Test
    void getMobileNumber() {
        assertTrue(client.getMobileNumber().equalsIgnoreCase("0412345678"));
    }

    @Test
    void setMobileNumber() {
        client.setMobileNumber("0487654321");
        assertTrue(client.getMobileNumber().equalsIgnoreCase("0487654321"));
    }

    @Test
    void getAccountOwnerID() {
        assertTrue(client.getAccountOwnerID().equalsIgnoreCase("004"));
    }

    @Test
    void setAccountOwnerID() {
        client.setAccountOwnerID("005");
        assertTrue(client.getAccountOwnerID().equalsIgnoreCase("005"));
    }
}
