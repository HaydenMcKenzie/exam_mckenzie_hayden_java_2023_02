package au.com.nuvento.atm.accountstest;

import au.com.nuvento.atm.accounts.Client;
import au.com.nuvento.atm.accounts.ClientBuilder;
import au.com.nuvento.atm.handlefiles.ReadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ClientBuilderTest {
    ReadFile readFile;
    public static List<String[]> userData;

    @BeforeEach
    public void setup() throws FileNotFoundException {
        readFile = new ReadFile();
        userData = readFile.getContentsFromFile("data/UserInfo.txt", ",");
    }

    @Test
    public void callNameFromUserInfo() throws FileNotFoundException {
        ClientBuilder clientBuilder = new ClientBuilder();
        HashMap<String, Client> clients = clientBuilder.createUser(userData);

        Client c = clients.get("002");
        assertEquals(c.getFirstName(), "Leanne");
        assertNotEquals(c.getFirstName(), "John");
    }
}
