package secure_banking_Transaction_Engine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankPortal {
    public static void main(String[] Args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            try {
                System.out.println("\n--- BANK MENU ---");
                System.out.println("1. Create New Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Check Balance");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        System.out.print("Enter Account Type (1-Savings, 2-Current): ");
                        int type = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        double balance = sc.nextDouble();

                        System.out.print("Enter Password: ");
                        int PIN = sc.nextInt();

                        if (type == 1) {
                            account = new SavingsAccount(accNo, name, balance, PIN);
                        } else if (type == 2) {
                            account = new CurrentAccount(accNo, name, balance, PIN);
                        } else {
                            System.out.println("Invalid account type!");
                            break;
                        }

                        System.out.println("Account created successfully!");
                        break;

                    case 2:
                        if (account == null) {
                            System.out.println("No account found. Create an account first.");
                            break;
                        }

                        System.out.print("Enter deposit amount: ");
                        int da = sc.nextInt();
                        account.deposit(da);
                        System.out.println("Deposit successful!");
                        System.out.println("Current Balance: " + account.getBalance());
                        break;

                    case 3:
                        if (account == null) {
                            System.out.println("No account found. Create an account first.");
                            break;
                        }

                        System.out.print("Enter PIN: ");
                        int pinn = sc.nextInt();

                        if (account.checkPin(pinn)) {
                            System.out.print("Enter withdrawal amount: ");
                            double wda = sc.nextDouble();
                            account.withdraw(wda);
                            System.out.println("Withdrawal successful!");
                            System.out.println("Current Balance: " + account.getBalance());
                        } else {
                            System.out.println("Incorrect Password");
                        }
                        break;

                    case 4:
                        if (account == null) {
                            System.out.println("No account found. Create an account first.");
                            break;
                        }

                        System.out.print("Enter PIN: ");
                        int pinnn = sc.nextInt();

                        if (account.checkPin(pinnn)) {
                            System.out.println("Current Balance: " + account.getBalance());
                        } else {
                            System.out.println("Incorrect Password");
                        }
                        break;

                    case 5:
                        System.out.println("Thank you for banking with us!");
                        sc.close();
                        System.out.println("Banking session ended");
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (InvalidAmountException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input! Please enter correct type.");
//                sc.nextLine(); 
            }
        }
    }
}
