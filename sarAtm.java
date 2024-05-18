import java.util.Scanner;
import java.lang.String;

public class sarAtm {
    private bankAcc account;

    public sarAtm(bankAcc account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("WELCOME TO SAR-ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();

            // used switch case here

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the SAR-ATM");
                    return;
                default:
                    System.out.println("Invalid option.");
            }

        }

    }

    // non para- constructor..
    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", account.getBalance());
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.printf("Successfully deposited $%.2f.  new balance is: $%.2f%n", amount,
                    account.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.printf("Successfully withdrew $%.2f. Your new balance is: $%.2f%n", amount,
                    account.getBalance());
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public class Main {
        public static void main(String[] args) {
            bankAcc account = new bankAcc(1000.00); // Initial balance
            sarAtm atm = new sarAtm(account);
            atm.start();

        }
    }
}
