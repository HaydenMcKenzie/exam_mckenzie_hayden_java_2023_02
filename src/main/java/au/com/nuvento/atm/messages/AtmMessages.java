package au.com.nuvento.atm.messages;

public enum AtmMessages {
    INITAL("Please enter your ID:"),
    OPTIONS("1 for Deposit\n" +
            "2 for Withdrawal\n" +
            "3 for Balance\n" +
            "q to Quit"),
    EXIT("Thank you. Exiting ATM"),
    ERROR("Error - Wrong Input. Please Try Again."),;

    private String action;

    public String getActions() { return this.action; }
    private AtmMessages(String action) { this.action = action; }
}
