package au.com.nuvento.atm.accounts;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class ClientBuilder {

    public Client createUser(String[] userInfo) {
        HashMap<String, Client> clients = new HashMap<>();
        if (userInfo.length == 4) {
            return new Client(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
        }
        return null;
    }

    /**
     * Create User
     * @param info is from File - From UserInfo.txt
     * @return new List
     * @throws FileNotFoundException Thrown if file not in path
     */
    public HashMap<String, Client> createUser( List<String[]> info ) throws FileNotFoundException {
        HashMap<String, Client> clients = new HashMap<>();
        info.stream().forEach(x -> {
            Client u = createUser(x);
            clients.put(u.getAccountOwnerID(), u);
        });
        return clients;
    }

}