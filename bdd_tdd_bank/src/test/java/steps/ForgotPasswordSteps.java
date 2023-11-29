package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.loginService.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ForgotPasswordSteps {

    private LoginPage loginPage;
    private String displayedMessage;

    @Given("User is in the login page")
    public void userIsInTheLoginPage() {
        loginPage = new LoginPage();
    }

    @And("user clicks on forgot password Button")
    public void userClicksOnForgotPasswordButton() {
        loginPage.clickForgotPasswordButton();
        displayedMessage = loginPage.getForgotPasswordMessage();
    }

    @Then("User should see a message to enter email")
    public void userShouldSeeAMessageToEnterEmail() {
        assertEquals("Please enter your email to reset your password", displayedMessage);
    }
}
