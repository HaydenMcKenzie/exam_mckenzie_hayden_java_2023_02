package au.com.nuvento.atm.utilstest;

import au.com.nuvento.atm.utils.Verification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerificationTest {
    Verification verification;
    String validUserID;
    String validUserOption;
    double invalidNewBalance;

    @BeforeEach
    public void setup() {
        verification = new Verification();
        validUserID = "001";
        validUserOption = "1";
        invalidNewBalance = -1;
    }

    @Test
    public void testFirstInteractionWithValidUserID() throws FileNotFoundException {
        String result = verification.firstInteraction(validUserID);
        assertEquals("", result);
    }

    @Test
    public void testSecondInteractionWithValidUserOption() throws FileNotFoundException {
        String result = verification.secondInteraction(validUserOption);
        assertEquals("", result);
    }

    @Test
    public void testThirdInteractionWithValidOptions() throws FileNotFoundException {
        String result = verification.thirdInteraction(validUserOption);
        assertEquals("", result);
    }
}