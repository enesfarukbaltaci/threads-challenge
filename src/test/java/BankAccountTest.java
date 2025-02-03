import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BankAccountTest {

      private BankAccount account;

        @BeforeEach
        void setUp() {
            account = new BankAccount(1000);
        }

        @Test
        void testDeposit() {
            account.deposit(500);
            assertEquals(1500, account.getBalance(), "Balance should be 1500 after depositing 500");
        }

        @Test
        void testWithdraw() throws InterruptedException {
            account.withdraw(300);
            assertEquals(700, account.getBalance(), "Balance should be 700 after withdrawing 300");
        }

        @Test
        void testWithdrawInsufficientFunds() {
            Thread withdrawThread = new Thread(() -> account.withdraw(1500));
            withdrawThread.start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            assertEquals(1000, account.getBalance(), "Balance should remain 1000 as withdrawal should wait for deposit");
        }

        @Test
        void testInterest() {
            account.addInterest(0.02);
            assertEquals(1020, account.getBalance(), "Balance should be 1020 after 2% interest");
        }
    }