public class BankingSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        // Deposit Thread
        Thread depositThread = new Thread(() -> {
            while (true) {
                account.deposit(300);
                sleep(1000);
            }
        });

        // Withdrawal Threads
        Thread withdrawThread1 = new Thread(() -> {
            while (true) {
                account.withdraw(200);
                sleep(2000);
            }
        });

        Thread withdrawThread2 = new Thread(() -> {
            while (true) {
                account.withdraw(500);
                sleep(3000);
            }
        });

        // Interest Thread
        Thread interestThread = new Thread(() -> {
            while (true) {
                account.addInterest(0.02);
                sleep(5000);
            }
        });

        depositThread.start();
        withdrawThread1.start();
        withdrawThread2.start();
        interestThread.start();
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
