import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();
    private final Condition sufficientFunds = lock.newCondition();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Deposited: $" + amount + " | Current Balance: $" + balance);
            sufficientFunds.signalAll(); // Notify waiting threads
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            while (balance < amount) {
                System.out.println("Insufficient funds for withdrawal: $" + amount + ". Waiting for deposit...");
                sufficientFunds.await(); // Wait until enough balance is available
            }
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " | Current Balance: $" + balance);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void addInterest(double rate) {
        lock.lock();
        try {
            double interest = balance * rate;
            balance += interest;
            System.out.println("Interest added: $" + interest + " | Current Balance: $" + balance);
        } finally {
            lock.unlock();
        }
    }
    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
