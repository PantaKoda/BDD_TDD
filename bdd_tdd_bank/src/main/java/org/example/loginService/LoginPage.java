package org.example.loginService;

public class LoginPage {

    private String message;

    public LoginPage() {

    }

    public void clickForgotPasswordButton() {
        // Simulate the action of clicking the "Forgot Password" button
        this.message = "Please enter your email to reset your password";
    }

    public String getForgotPasswordMessage() {
        // Return the message that should be displayed after clicking the button
        return this.message;
    }
}
