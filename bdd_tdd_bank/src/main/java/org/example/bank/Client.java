package org.example.bank;

import java.util.HashSet;
import java.util.Set;

public final class Client {

    private String clientID;
    private String clientUsername;
    private String clientPassword;
    private String clientEmail;
    private String clientRole;
    private Set<String> roles;


    public Client(String clientID, String clientUsername, String getClientPassword, String clientEmail) {
        this.clientID = clientID;
        this.clientUsername = clientUsername;
        this.clientPassword = getClientPassword;
        this.clientEmail = clientEmail;
        this.roles = new HashSet<>();
    }

    public String getClientID() {
        return clientID;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public String getGetClientPassword() {
        return clientPassword;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void addRole(String role) {
        roles.add(role);
    }

    public boolean hasRole(String role) {
        return roles.contains(role);
    }
}
