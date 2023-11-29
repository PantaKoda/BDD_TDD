import org.example.loginService.PasswordResetResult;
import org.example.loginService.PasswordResetService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordResetServiceTest {

    @Test
    void testFailedPasswordReset() {
        PasswordResetService passwordResetService = new PasswordResetService();
        String userEmail = "user@example.com";

        PasswordResetResult result = passwordResetService.resetPassword(userEmail);

        assertFalse(result.isSuccessful());
        assertEquals("Password reset failed: User not found", result.getMessage());
    }
}
