package org.example.loginService;

public class PasswordResetService {

    public PasswordResetResult resetPassword(String email) {
        // For now, just return a failed result
        return new PasswordResetResult(false, "Password reset failed: User not found");
    }
}
