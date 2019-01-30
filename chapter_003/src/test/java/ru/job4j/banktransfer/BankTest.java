package ru.job4j.banktransfer;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Class for testing the Bank class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 30.01.2019
 * @version 1.0
 */
public class BankTest {

    /**
     * Tests when it needs to transfer from person A to person B.
     */
    @Test
    public void whenTransferFromOneToAnotherUserThenSuccess() {
        Bank bank = new Bank();
        User first = new User("Peter", "4123");
        User second = new User("Jack", "9720");
        bank.addUser(first);
        bank.addUser(second);
        Account firstAccount = new Account(10000.00, "73298479324");
        Account secondAccount = new Account(20000.00, "8453045");
        bank.addAccountToUser(first, new Account(10000.00, "73298479324"));
        bank.addAccountToUser(second, secondAccount);
        assertThat(bank.transferMoney(first, firstAccount, second, secondAccount, 5000), is(true));
    }

    /**
     * Tests when it needs to transfer from person A to person B and the result is unsuccessful.
     */
    @Test
    public void whenTransferFromOneToAnotherUserThenUnsuccessful() {
        Bank bank = new Bank();
        User first = new User("Peter", "4123");
        User second = new User("Jack", "9720");
        bank.addUser(first);
        bank.addUser(second);
        Account firstAccount = new Account(10000.00, "73298479324");
        Account secondAccount = new Account(20000.00, "8453045");
        bank.addAccountToUser(first, firstAccount);
        bank.addAccountToUser(second, secondAccount);
        bank.transferMoney(first, firstAccount, second, secondAccount, 11000);
        assertThat(bank.transferMoney(first, firstAccount, second, secondAccount, 11000), is(false));
    }

    /**
     * Tests when it needs to delete a user's account.
     */
    @Test
    public void whenToDeleteUserThenSuccess() {
        Bank bank = new Bank();
        User first = new User("Peter", "4123");
        bank.addUser(first);
        Account firstAcc = new Account(10000.00, "73298479324");
        bank.addAccountToUser(first, firstAcc);
        assertThat(bank.deleteAccountFromUser(first, firstAcc), is(true));
    }

    /**
     * Tests when it needs to delete a user.
     */
    @Test
    public void whenToDeleteUser() {
        Bank bank = new Bank();
        User first = new User("Peter", "4123");
        bank.addUser(first);
        Account firstAcc = new Account(10000.00, "73298479324");
        bank.addAccountToUser(first, firstAcc);
        bank.deleteUser(first);
        assertNull(bank.getUserAccounts(first));
    }
}