package org.example.loginService;

public class LoginService {

    public LoginResult login(String username, String password) {

        // For now, just check if the username is invalid
        if ("wrongUser".equals(username)) {
            return new LoginResult(LoginStatus.INVALID_USERNAME, "Incorrect username");
        }
        return new LoginResult(LoginStatus.SUCCESS, null);
    }


}
