import org.example.loginService.LoginPage;
import org.example.loginService.LoginResult;
import org.example.loginService.LoginService;
import org.example.loginService.LoginStatus;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin {

    @Test
    void testInvalidUsernameLogin() {

        LoginService loginService = new LoginService();
        String invalidUsername = "wrongUser";
        String password = "password123";

        LoginResult result = loginService.login(invalidUsername, password);

        assertEquals(LoginStatus.INVALID_USERNAME, result.getStatus());
        assertNotNull(result.getMessage(), "Message should be provided for invalid username");
    }

    @Test
    void testForgotPassword() {
        LoginPage loginPage = new LoginPage();

        loginPage.clickForgotPasswordButton();
        String message = loginPage.getForgotPasswordMessage();

        assertEquals("Please enter your email to reset your password", message, "The message to enter email should be displayed");
    }


}
