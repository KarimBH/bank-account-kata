package com.github.karimbh.bankaccount.domain;

/**
 * A bank's client represented solely by it's unique username
 */
public class Client {

    private String username; // We suppose username is a client's identifier in our system

    public Client(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
