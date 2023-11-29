package org.example.loginService;

public class LoginResult {

    private final LoginStatus status;
    private final String message;

    public LoginResult(LoginStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public LoginStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}