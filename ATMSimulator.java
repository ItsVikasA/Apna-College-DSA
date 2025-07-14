import java.util.Scanner;           
class ATM  {                        
private double balance;    

    public ATM(double initialBalance) {     
        this.balance = initialBalance;
    }
    
    public void checkBalance() { 
        System.out.printf("💰 Current Balance: ₹%.2f%n", balance);
    } 

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("✅ ₹%.2f deposited successfully!%n", amount);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    public void withdraw(double amount)  {
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be greater than zero!");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance!");
        } else {
            balance -= amount;
            System.out.printf("✅ ₹%.2f withdrawn successfully!%n", amount);
        }
    }
}

public class ATMSimulator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ATM atm = new ATM(5000); // Initial balance

            while (true) {
                System.out.println("\n===== ATM Menu =====");
                System.out.println("1️⃣  Check Balance");
                System.out.println("2️⃣  Deposit Money");
                System.out.println("3️⃣  Withdraw Money");
                System.out.println("4️⃣  Exit");
                System.out.print("👉 Choose an option: ");

                int choice;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                } else {
                    System.out.println("❌ Invalid input! Please enter a number.");
                    scanner.next(); // Clear invalid input
                    continue;
                }

                switch (choice) {
                    case 1 -> atm.checkBalance();
                    case 2 -> {
                        System.out.print("Enter deposit amount: ₹");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                    }
                    case 3 -> {
                        System.out.print("Enter withdrawal amount: ₹");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                    }
                    case 4 -> {
                        System.out.println("👋 Exiting... Thank you for using ATM!");
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice! Please select from 1 to 4.");
                }
            }
        }
    }
}
