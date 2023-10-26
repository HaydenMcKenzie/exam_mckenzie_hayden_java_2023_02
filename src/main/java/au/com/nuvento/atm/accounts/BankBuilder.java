package au.com.nuvento.atm.accounts;

import au.com.nuvento.atm.messages.AtmMessages;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class BankBuilder {
    /**
     * Select Account
     * @param userID is user input and is either 001, 002 or 003 - for userID
     * @param accountSelect is user input and is either 1 or 2
     * @return based on userID and accountSelect, returns their accountNo - Had to hard code.
     */
    public String selectAccount(String userID, String accountSelect)  {
        AtmMessages exitMessage = AtmMessages.ERROR;
        switch (userID) {
            case "001":
                switch (accountSelect) {
                    case "1":
                        return "9264945"; // First account for John
                    case "2":
                        return "7814135";
                }
                break;
            case "002":
                switch (accountSelect) {
                    case "1":
                        return "9676422";
                    case "2":
                        return "7524155";
                }
                break;
            case "003":
                if (accountSelect.equals("1")) {
                    return "9042221";
                }
        }
        return userID;
    }

    /**
     * Account Select
     * @param accountSelect is user input and is either 1, 2 or 3
     * @return Deposit, Withdraw or Balance
     */
    public String accountSelect(String accountSelect)  {
        AtmMessages errorMessage = AtmMessages.ERROR;
        AtmMessages exitMessage = AtmMessages.EXIT;
        switch (accountSelect) {
            case "1":
                return "Deposit";
            case "2":
                return "Withdraw";
            case "3":
                return "Balance";
            case "q":
                System.out.println(exitMessage.getActions());
                System.exit(0);
            default:
                System.out.println(errorMessage.getActions());
                break;
        }
        return accountSelect;
    }

    public BankAccount createBank(String[] accountInfo) {
        HashMap<String, BankAccount> bankAccount = new HashMap<>();
        if (accountInfo.length == 4) {
            return new BankAccount(accountInfo[0], accountInfo[1], accountInfo[2], accountInfo[3]);
        }
        return null;
    }

    /**
     * Create Bank
     * @param info is from File - From OpeningAccountsData.txt
     * @return new List
     * @throws FileNotFoundException Thrown if file not in path
     */
    public HashMap<String, BankAccount> createBank( List<String[]> info ) throws FileNotFoundException {
        HashMap<String, BankAccount> bankAccount = new HashMap<>();
        info.stream().forEach(x -> {
            BankAccount u = createBank(x);
            bankAccount.put(u.getAccountNumber(), u);
        });
        return bankAccount;
    }
}
