package au.com.nuvento.atm.handlefiletest;


import au.com.nuvento.atm.handlefiles.ReadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadFileTest {

    // getContentsFromFile(String filePath, String remove_delim)

    ReadFile readFile;
    String account_data;
    String user_data;
    String account_delim;
    String user_delim;

    @BeforeEach
    public void setup() {
        readFile = new ReadFile();
        account_data = "data/OpeningAccountsData.txt";
        account_delim = "\\|\\|\\|";
        user_data = "data/UserInfo.txt";
        user_delim = ",";
    }

    @Test
    public void readUserInfoDataThenCountElements() throws FileNotFoundException {
        List<String[]>  userInfo = readFile.getContentsFromFile(user_data, user_delim);

        assertEquals(userInfo.size(), 4);
        assertEquals(userInfo.get(0).length, 4);
    }

    @Test
    public void readOpeningAccountsDataThenCountElements() throws FileNotFoundException {
        List<String[]>  accountData = readFile.getContentsFromFile(account_data, account_delim);

        assertEquals(accountData.size(), 6);
        assertEquals(accountData.get(0).length, 4);
    }
}

