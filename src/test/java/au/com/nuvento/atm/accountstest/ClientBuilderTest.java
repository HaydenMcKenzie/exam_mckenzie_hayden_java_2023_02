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

public class ClientBuilderTest {
    ReadFile readFile;
    public static List<String[]> userData;

    @BeforeEach
    public void setup() throws FileNotFoundException {
        readFile = new ReadFile();
        userData = readFile.getContentsFromFile("data/UserInfo.txt", ",");
    }

    @Test
    public void callInfoFromUserInfoForJohn() throws FileNotFoundException {
        ClientBuilder clientBuilder = new ClientBuilder();
        HashMap<String, Client> clients = clientBuilder.createUser(userData);

        Client c = clients.get("001");
        assertEquals(c.getFirstName(), "John");
        assertEquals(c.getSurname(), "Smith");
        assertEquals(c.getMobileNumber(), "0403715629");
        assertEquals(c.getAccountOwnerID(), "001");
    }
    @Test
    public void callInfoFromUserInfoForLeanne() throws FileNotFoundException {
        ClientBuilder clientBuilder = new ClientBuilder();
        HashMap<String, Client> clients = clientBuilder.createUser(userData);

        Client c = clients.get("002");
        assertEquals(c.getFirstName(), "Leanne");
        assertEquals(c.getSurname(), "Smith");
        assertEquals(c.getMobileNumber(), "0403185031");
        assertEquals(c.getAccountOwnerID(), "002");
    }
    @Test
    public void callInfoFromUserInfoForKim() throws FileNotFoundException {
        ClientBuilder clientBuilder = new ClientBuilder();
        HashMap<String, Client> clients = clientBuilder.createUser(userData);

        Client c = clients.get("003");
        assertEquals(c.getFirstName(), "Kim");
        assertEquals(c.getSurname(), "Kash");
        assertEquals(c.getMobileNumber(), "0404993021");
        assertEquals(c.getAccountOwnerID(), "003");
    }
}
