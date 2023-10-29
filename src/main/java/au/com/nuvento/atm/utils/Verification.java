package au.com.nuvento.atm.utils;

import au.com.nuvento.atm.ATM;
import au.com.nuvento.atm.messages.AtmMessages;
import au.com.nuvento.atm.messages.ClosingMessage;
import au.com.nuvento.atm.messages.Interactions;

import java.io.FileNotFoundException;

public class Verification {
    /**
     * First Interaction Verification
     * @param userID is user input and is either 001, 002 or 003 - for userID
     * @return based on input, it is to verify input is correct. If not, to recalls the application and or quits
     * @throws FileNotFoundException Thrown if file not in path
     */
    public String firstInteraction(String userID) throws FileNotFoundException {
        AtmMessages exitMessage = AtmMessages.EXIT;
        ClosingMessage closingMessage = new ClosingMessage();
        switch (userID) {
            case "001":
            case "002":
            case "003":
                return "";
            case "q":
                System.out.println(exitMessage.getActions());
                closingMessage.endMessage();
                System.exit(0);
                break;
            default:
                AtmMessages errorMessage = AtmMessages.ERROR;
                System.out.println(errorMessage.getActions());
                ATM.setup();
                ATM.userInteraction();
        }
        return userID;
    }

    /**
     * Second Interaction Verification
     * @param userOption is user input and is either 1, 2 or 3        - for Deposit or Withdraw or Balance
     * @return based on input, it is to verify input is correct. If not, to recalls the application and or quits
     * @throws FileNotFoundException Thrown if file not in path
     */
    public String secondInteraction(String userOption) throws FileNotFoundException {
        AtmMessages exitMessage = AtmMessages.EXIT;
        ClosingMessage closingMessage = new ClosingMessage();
        switch (userOption) {
            case "1":
            case "2":
            case "3":
                return "";
            case "q":
                System.out.println(exitMessage.getActions());
                closingMessage.endMessage();
                System.exit(0);
                break;
            default:
                AtmMessages errorMessage = AtmMessages.ERROR;
                System.out.println(errorMessage.getActions());
                ATM.setup();
                ATM.userInteraction();
        }
        return userOption;
    }

    /**
     * Third Interaction Verification
     * @param options is user input and is either 1 or 2           - for Cheque or Savings accounts
     * @return based on input, it is to verify input is correct. If not, to recalls the application and or quits
     * @throws FileNotFoundException Thrown if file not in path
     */
    public String thirdInteraction(String options) throws FileNotFoundException {
        AtmMessages exitMessage = AtmMessages.EXIT;
        ClosingMessage closingMessage = new ClosingMessage();
        switch (options) {
            case "1":
            case "2":
                return "";
            case "q":
                System.out.println(exitMessage.getActions());
                closingMessage.endMessage();
                System.exit(0);
                break;
            default:
                AtmMessages errorMessage = AtmMessages.ERROR;
                System.out.println(errorMessage.getActions());
                ATM.setup();
                ATM.userInteraction();
                break;
        }
        return options;
    }

    /**
     * Fourth Interaction Verification
     * @param newBal is a variable from userInteraction() from ATM. It is to verify weather the New Balance if less than 0. If so, recall application
     * @throws FileNotFoundException Thrown if file not in path
     */
    public String fourthInteraction(String userName, String options, double newBal, String userAmountEntered) throws FileNotFoundException {
        Interactions interactions = new Interactions();
        AtmMessages errorMessage = AtmMessages.ERROR;
        double enteredAmount = Double.parseDouble(userAmountEntered);

        if (newBal < 0) {
            System.out.println(interactions.invalidAmountEntered(userName, options, enteredAmount));
            ATM.setup();
            ATM.userInteraction();
        }
        if (!(isStringDouble(userAmountEntered))) {
            System.out.println(errorMessage.getActions());
            ATM.setup();
            ATM.userInteraction();
        }

        return userAmountEntered;
    }

    public static boolean isStringDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
