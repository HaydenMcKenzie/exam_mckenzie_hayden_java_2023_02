package au.com.nuvento.atm.accounts;

public class Client {

    // Initialization
    String FirstName;
    String Surname;
    String MobileNumber;
    String AccountOwnerID;


    // Getter & Setter for First Name
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    // Getter & Setter for Surname
    public String getSurname() { return Surname; }

    public void setSurname(String surname) {
        Surname = surname;
    }

    // Getter & Setter for Mobile Number
    public String getMobileNumber() { return MobileNumber; }

    public void setMobileNumber(String mobileNumber) { MobileNumber = mobileNumber;}

    // Getter & Setter for AccountOwnerID
    public String getAccountOwnerID() {
        return AccountOwnerID;
    }

    public void setAccountOwnerID(String accountOwnerID) {
        AccountOwnerID = accountOwnerID;
    }


    // Main Function
    public Client(String firstName, String surname, String mobileNumber, String accountOwnerID) {
        FirstName = firstName;
        Surname = surname;
        MobileNumber = mobileNumber;
        AccountOwnerID = accountOwnerID;
    }
}
