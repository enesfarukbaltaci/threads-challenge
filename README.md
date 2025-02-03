# Banking Simulation with Java Threads

## Overview
This project implements a **multi-threaded banking system** in Java using **concurrency and synchronization**. It simulates multiple users performing deposits and withdrawals on a shared bank account while ensuring **thread safety**. Additionally, it includes an **interest system** that periodically applies interest to the account balance.

## Features
- **Thread-Safe Bank Account**: Uses `ReentrantLock` and `Condition` to handle concurrent transactions.
- **Multiple Transactions**: Supports simultaneous deposits and withdrawals.
- **Synchronization**: Ensures withdrawals wait if funds are insufficient.
- **Logging**: Tracks deposits, withdrawals, and balance updates.
- **Interest System**: Adds 2% interest every 5 seconds.

## How It Works
1. The program starts with a **shared bank account** initialized with a balance of **$1000**.
2. **Three transaction threads** perform deposits and withdrawals at different intervals:
   - **Thread 1**: Deposits $300 every second.
   - **Thread 2**: Withdraws $200 every two seconds.
   - **Thread 3**: Withdraws $500 every three seconds.
3. **An interest thread** applies a **2% interest** to the balance every **5 seconds**.
4. Transactions are logged, including:
   - Deposits and withdrawals.
   - Current balance after each transaction.
   - Failed withdrawals due to insufficient funds.

## Technologies Used
- **Java** (JDK 8 or higher)
- **Concurrency APIs** (`ReentrantLock`, `Condition`, `Thread`)

## Setup & Execution
1. Clone this repository:
   ```sh
   git clone https://github.com/enesfarukbaltaci/threads-challenge.git
   cd banking-simulation
   ```
2. Compile the Java files:
   ```sh
   javac BankingSimulation.java
   ```
3. Run the program:
   ```sh
   java BankingSimulation
   ```

## Example Output
```
Deposited: $300 | Current Balance: $1300
Withdrawn: $200 | Current Balance: $1100
Withdrawn: $500 | Current Balance: $600
Insufficient funds for withdrawal: $500. Waiting for deposit...
Deposited: $300 | Current Balance: $900
Interest added: $18.0 | Current Balance: $918.0
```

