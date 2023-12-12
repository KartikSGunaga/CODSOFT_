package task03;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class ATMMachine_OOP extends Application {
    private final int accountNumber;
    private final int password;
    private float balance;
    private ArrayList<String[]> transactionList;

    public ATMMachine_OOP(int accountNumber, int password) {
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
            System.out.println("Transaction unsuccessful. \nNot enough balance available");
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

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ATM Machine");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label choiceLabel = new Label("Select your choice:");
        GridPane.setConstraints(choiceLabel, 0, 0);

        ComboBox<String> choices = new ComboBox<>();
        choices.getItems().addAll("Deposit money", "Withdraw money", "View Balance", "View Transaction History", "Exit");
        choices.setPromptText("Select Option");
        GridPane.setConstraints(choices, 1, 0);

        Label amountLabel = new Label("Enter the amount:");
        GridPane.setConstraints(amountLabel, 0, 1);

        TextField amountInput = new TextField();
        amountInput.setPromptText("Amount");
        GridPane.setConstraints(amountInput, 1, 1);

        Button executeButton = new Button("Execute");
        GridPane.setConstraints(executeButton, 1, 2);

        grid.getChildren().addAll(choiceLabel, choices, amountLabel, amountInput, executeButton);

        executeButton.setOnAction(e -> {
            int choice = choices.getSelectionModel().getSelectedIndex() + 1;
            float amount = Float.parseFloat(amountInput.getText());

            switch (choice) {
                case 1:
                    deposit(amount);
                    break;
                case 2:
                    withdraw(amount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    transactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM! \nPlease visit again!");
                    primaryStage.close();
                    break;
                default:
                    System.out.println("Invalid entry. \nPlease select in range (1-5).");
            }
        });

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
