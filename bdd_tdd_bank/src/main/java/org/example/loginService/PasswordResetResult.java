package org.example.loginService;

public class PasswordResetResult {

    private final boolean successful;
    private final String message;

    public PasswordResetResult(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getMessage() {
        return message;
    }
}
