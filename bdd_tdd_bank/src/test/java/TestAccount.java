import org.example.bank.Account;
import org.example.bank.Client;
import org.example.bank.customBankExceptions.InsufficientFundsException;
import org.example.bank.customBankExceptions.UnauthorizedAccessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccount {


    private Account account;

    @BeforeEach
    void setup() {
        account = new Account(150);
    }

    @Test
    public void testBalance() {
        var expected = 150;
        var actual = account.getBalance();

        assertEquals(expected, actual, "Accound balance should be 150");
    }


    @Test
    public void testDeposit(){
        // Act
        account.deposit(1000);

        var expected = 1150;
        var actual = account.getBalance();

        assertEquals(expected, actual, "Accound balance should be 1150");

    }

    // Attempt to transfer more than the balance
    @Test
    void testTransferFailsWithInsufficientBalance() {
        Account source = new Account(100);
        Account destination = new Account(50);
        Client user = new Client("001", "user1", "password", "user1@example.com");
        user.addRole("TRANSFER_ROLE");

        assertThrows(InsufficientFundsException.class, () -> {
            source.transfer(destination, 150, user);
        });

        assertEquals(100, source.getBalance());
        assertEquals(50, destination.getBalance());
    }


    //  Unauthorized User
    @Test
    void testTransferFailsWithUnauthorizedUser() {
        Account source = new Account(200);
        Account destination = new Account(100);
        Client user = new Client("002", "user2", "password", "user2@example.com");
        // Not adding TRANSFER_ROLE to user

        assertThrows(UnauthorizedAccessException.class, () -> {
            source.transfer(destination, 50, user); // User lacks TRANSFER_ROLE
        });

        assertEquals(200, source.getBalance());
        assertEquals(100, destination.getBalance());
    }

    //Invalid Transfer Amount
    @Test
    void testTransferFailsWithInvalidAmount() {
        Account source = new Account(200);
        Account destination = new Account(100);
        Client user = new Client("004", "user4", "password", "user4@example.com");
        user.addRole("TRANSFER_ROLE");

        assertThrows(IllegalArgumentException.class, () -> {
            source.transfer(destination, -50, user);
        });

        assertEquals(200, source.getBalance());
        assertEquals(100, destination.getBalance());
    }

    // Valid transfer
    @Test
    void testSuccessfulTransfer() throws InsufficientFundsException, UnauthorizedAccessException {
        Account source = new Account(300);
        Account destination = new Account(100);
        Client user = new Client("003", "user3", "password", "user3@example.com");
        user.addRole("TRANSFER_ROLE");

        source.transfer(destination, 100, user); // Successful transfer

        assertEquals(200, source.getBalance());
        assertEquals(200, destination.getBalance());
    }




}
