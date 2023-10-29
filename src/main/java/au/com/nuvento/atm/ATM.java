package au.com.nuvento.atm;

// Import Classes

import au.com.nuvento.atm.accounts.BankAccount;
import au.com.nuvento.atm.accounts.BankBuilder;
import au.com.nuvento.atm.accounts.Client;
import au.com.nuvento.atm.accounts.ClientBuilder;
import au.com.nuvento.atm.handlefiles.ReadFile;
import au.com.nuvento.atm.messages.Interactions;
import au.com.nuvento.atm.utils.Commands;
import au.com.nuvento.atm.utils.Verification;
import au.com.nuvento.atm.utils.WriteToFile;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class ATM
{
    public static HashMap<String, Client> clients;
    public static HashMap<String, BankAccount> bankAccount;

    /**
     * User Interaction Method
     * Where user interacts with code to edit accounts
     * @throws FileNotFoundException Thrown if file not in path
     */
    public static void userInteraction() throws FileNotFoundException {
        // Imports
        Scanner sc = new Scanner(System.in);
        Verification verification = new Verification();
        Interactions interactions = new Interactions();
        Commands commands = new Commands();
        WriteToFile writeToFile = new WriteToFile();

        // Intro
        interactions.welcomeInteraction();
        String userName = sc.nextLine();
        verification.firstInteraction(userName);

        // Printing Name with Options
        interactions.userDecision(userName);
        String userOption = sc.nextLine();
        verification.secondInteraction(userOption);

        // Showing the accounts
        interactions.showAccount(userName, userOption);
        String options = sc.nextLine(); // test id
        verification.thirdInteraction(options);

        // Showing Balance and enter amount
        interactions.enterInAccount(userName, options, userOption);
        String userAmount = sc.nextLine();
        double newBal = commands.newBalance(userName, options, userOption, userAmount);
        verification.fourthInteraction(userName, options, newBal, userAmount);
        System.out.println("Your new Balance is: $" + String.format("%.2f", newBal));

        // Write to File
        writeToFile.reWrite(commands.newWriteBal(userName, options), Double.toString(Double.parseDouble(String.format("%.2f", newBal))));

        // Recall
        ATM.setup();
        ATM.userInteraction();
    }

    /**
     * Main Method
     * @param args Arguments passed to mains
     * @throws FileNotFoundException Thrown if file not in path
     */
    public static void main( String[] args ) throws FileNotFoundException {
        setup();
        userInteraction(); // + Write to file
    }

    /**
     * Setup Method
     * Builds the client and bank accounts
     * @throws FileNotFoundException Thrown if file not in path
     */
    public static void setup() throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        List<String[]> userData = readFile.getContentsFromFile("data/UserInfo.txt", ",");
        List<String[]> accountData = readFile.getContentsFromFile("data/OpeningAccountsData.txt", "\\|\\|\\|");

        ClientBuilder clientBuilder = new ClientBuilder();
        clients = clientBuilder.createUser(userData);

        BankBuilder bankBuilder = new BankBuilder();
        bankAccount = bankBuilder.createBank(accountData);
    }
}
