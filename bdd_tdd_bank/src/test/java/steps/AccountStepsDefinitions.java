package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountStepsDefinitions {

    private int balance;

    @Given("that the user's balance is {int} dollars")
    public void that_the_user_s_balance_is_dollars(Integer startingBalance) {
        this.balance = startingBalance;
    }

    @When("the user deposits {int} dollars")
    public void the_user_deposits_amount_dollars(Integer amount) {
        this.balance += amount;
    }

    @Then("the user's balance is {int}")
    public void the_user_s_balance_is_dollars(Integer newBalance) {
        assertEquals(newBalance.intValue(), this.balance);
    }
}


