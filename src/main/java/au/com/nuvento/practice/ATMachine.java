package au.com.nuvento.practice;

import java.util.*;
import java.lang.*;

public class ATMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a user ID: ");
        String User = sc.nextLine();

        // Setup based off pseudocode
        String name = null;
        String accounts = null;
        double cheque = 0;
        double saving = 0;
        switch (User) {
            case "001":
                name = "John Smith";
                cheque = 500.09;
                saving = 200.09;
                accounts = "1 for 9264945 (Cheque)"
                        + "\n2 for 7814135 (Saving)";
                break;
            case "q":
                System.out.println("Thank you");
                System.exit(0);
            default:
                System.out.println("Error - Try Again");
                System.exit(0);
        }

        // Interaction based off pseudocode
        String Welcome = "Welcome " + name
                + "\nPlease choose an option:"
                + "\n1. Deposit"
                + "\n2. Withdrawal"
                + "\n3. Balance"
                + "\nq. quit";
        System.out.println(Welcome);
        String userOption = sc.nextLine();
        switch (userOption) {
            case "1": case "2": case "3":
                System.out.println(accounts);
                break;
            case "q":
                System.out.println("Thank you");
                System.exit(0);
            default:
                System.out.println("Error - Invalid Option. Please Try Again");
                System.exit(0);
        }

        String userAccount = sc.nextLine();
        double amount;
        double newbalance;
        switch (userAccount) {
            case "1":
                switch (userOption) {
                    case "1":
                        System.out.println("How much do you want to Deposit:");
                        amount = Integer.parseInt(sc.nextLine());
                        newbalance = cheque + amount;
                        System.out.println("New Balance: $" + newbalance);
                        break;
                    case "2":
                        System.out.println("How much do you want to Withdrawal:");
                        amount = Integer.parseInt(sc.nextLine());
                        newbalance = cheque - amount;
                        if (newbalance < 0) {
                            System.out.println("Error - The amount you entered ($" + amount + ") is greater than your balance ($" + cheque + ")");
                        } else {
                            System.out.println("New Balance: $" + newbalance);
                        }
                        break;
                    case "3":
                        System.out.println("Your Balance is: $" + cheque);
                        System.exit(0);
                }
                break;
            case "2":
                switch (userOption) {
                    case "1":
                        System.out.println("How much do you want to Deposit:");
                        amount = Integer.parseInt(sc.nextLine());
                        newbalance = saving + amount;
                        System.out.println("New Balance: $" + newbalance);
                        break;
                    case "2":
                        System.out.println("How much do you want to Withdrawal:");
                        amount = Integer.parseInt(sc.nextLine());
                        newbalance = saving - amount;
                        if (newbalance < 0) {
                            System.out.println("Error - The amount you entered ($" + amount + ") is greater than your balance ($" + saving + ")");
                        } else {
                            System.out.println("New Balance: $" + newbalance);
                        }
                        break;
                    case "3":
                        System.out.println("Your Balance is: $" + saving);
                        System.exit(0);
                }
                break;
            case "q":
                System.out.println("Thank you");
                System.exit(0);
            default:
                System.out.println("Error - Invalid Number. Please Try Again");
                System.exit(0);
        }

        // This is when the Rewrite of the code to the .txt would go
        // Exit
    }
}

