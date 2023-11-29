package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.bank.Account;
import org.example.bank.Client;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MoneyTransferSteps {
    private Account accountA;
    private Account accountB;
    private Client user;
    private Exception lastException;

    @Given("the user has two accounts AccountA and AccountB")
    public void theUserHasTwoAccountsAccountAAndAccountB() {
        user = new Client("001", "Tom", "tom123", "tom@example.com");
        user.addRole("TRANSFER_ROLE");
        accountA = new Account(0);
        accountB = new Account(0);
    }

    @And("AccountA balance is {int}")
    public void accountABalanceIs(int amount) {
        accountA.deposit(amount);
    }

    @And("AccountB balance is {int}")
    public void accountBBalanceIs(int amount) {
        accountB.deposit(amount);
    }

    @When("the user transfers {int} from AccountA to AccountB")
    public void theUserTransfersFromAccountAToAccountB(int amount) {
        try {
            accountA.transfer(accountB, amount, user);
            lastException = null;
        } catch (Exception e) {
            lastException = e;
        }
    }

    @Then("AccountA balance should be {int}")
    public void accountABalanceShouldBe(int expectedBalance) {
        assertEquals(expectedBalance, accountA.getBalance());
    }

    @And("AccountB balance should be {int}")
    public void accountBBalanceShouldBe(int expectedBalance) {
        assertEquals(expectedBalance, accountB.getBalance());
    }

    @When("the user tries to transfer {int} from AccountA to AccountB")
    public void theUserTriesToTransferFromAccountAToAccountB(int amount) {
        theUserTransfersFromAccountAToAccountB(amount);
    }

    @Then("the transfer should be declined")
    public void theTransferShouldBeDeclined() {
        assertNotNull(lastException, "Expected an exception to be thrown");
    }

    @And("AccountA balance should remain {int}")
    public void accountABalanceShouldRemain(int expectedBalance) {
        assertEquals(expectedBalance, accountA.getBalance());
    }

    @And("AccountB balance should remain {int}")
    public void accountBBalanceShouldRemain(int expectedBalance) {
        assertEquals(expectedBalance, accountB.getBalance());
    }
}
