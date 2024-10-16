package bank;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void testBankAccountCreationStartsWithZeroBalance() {
        BankAccount bankAccount = new BankAccount();

        double balance = bankAccount.getBalance();

        assertEquals(0, balance, 0);
    }

    @Test
    public void testDepositShouldIncreaseAmountCorrectly() {
        BankAccount bankAccount = new BankAccount();

        bankAccount.deposit(50);

        assertTrue(bankAccount.getBalance() == 50);
    }
}

