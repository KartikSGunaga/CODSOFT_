package task03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ATMMachine {
    static Scanner scanner = new Scanner(System.in);
    private final int accountNumber;
    private final int password;
    private float balance;
    private ArrayList<String[]> transactionList;

    public ATMMachine(int accountNumber, int password) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = 0;
        this.transactionList = new ArrayList<>();
    }

    public void checkBalance() {
        System.out.println("The available balance is: " + balance);
    }

    public void withdraw(float amount) {
        if (balance >= amount) {
            System.out.println("Transaction successful! ");
            this.balance -= amount;
            this.transactionList.add(new String[]{"Withdrawal", Float.toString(amount)});
        } else {
            System.out.println("Transaction unsuccessful. \n" +
                    "Not enough balance available");
        }
    }

    public void deposit(float amount) {
        this.balance += amount;
        System.out.println("Amount deposited successfully!");
        this.transactionList.add(new String[]{"Deposit", Float.toString(amount)});
    }

    public void transactionHistory() {
        System.out.println("Below are your transactions: ");
        for (String[] transaction : this.transactionList) {
            System.out.println(Arrays.toString(transaction));
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM!");

        System.out.println("Enter the account number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("Enter the PIN: ");
        int pin = scanner.nextInt();

        ATMMachine user = new ATMMachine(accountNumber, pin);

        while(true){
            System.out.println("Select your choice: \n" +
                    "1. Deposit money \n" +
                    "2. Withdraw money\n" +
                    "3. View Balance\n" +
                    "4. View Transaction History\n" +
                    "5. Exit ");
            int choice = scanner.nextInt();

            if(choice == 1) {
                System.out.println("Enter the amount to deposit: ");
                int amount = scanner.nextInt();
                user.deposit(amount);
            } else if (choice == 2) {
                System.out.println("Enter the amount to withdraw: ");
                int amount = scanner.nextInt();
                user.withdraw(amount);
            } else if (choice == 3) {
                user.checkBalance();
            } else if (choice == 4) {
                user.transactionHistory();
            } else if (choice == 5) {
                System.out.println("Thank you for using the ATM! \n" +
                        "Please visit again!");
                break;
            }
            else {
                System.out.println("Invalid entry. \n" +
                        "Please select in range (1-5).");
            }
        }
    }
}
