package au.com.nuvento.atm.messagestest;

import au.com.nuvento.atm.messages.AtmMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtmMessagesTest {
    AtmMessages inital;
    AtmMessages options;
    AtmMessages exit;
    AtmMessages error;


    @BeforeEach
    public void setup() {
        inital = AtmMessages.INITAL;
        options = AtmMessages.OPTIONS;
        exit = AtmMessages.EXIT;
        error = AtmMessages.ERROR;
    }

    @Test
    public void testingInitialMessage() {
        AtmMessages result = AtmMessages.INITAL;
        assertEquals(result.getActions(), "Please enter your ID:");
    }
    @Test
    public void testingOptionsMessage() {
        AtmMessages result = AtmMessages.OPTIONS;
        assertEquals(result.getActions(), "1 for Deposit\n" +
                "2 for Withdrawal\n" +
                "3 for Balance\n" +
                "q to Quit");
    }
    @Test
    public void testingExitMessage() {
        AtmMessages result = AtmMessages.EXIT;
        assertEquals(result.getActions(), "Thank you. Exiting ATM");
    }
    @Test
    public void testingErrorMessage() {
        AtmMessages result = AtmMessages.ERROR;
        assertEquals(result.getActions(), "Error - Wrong Input. Please Try Again.");
    }
}