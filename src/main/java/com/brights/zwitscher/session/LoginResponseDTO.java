package com.brights.zwitscher.session;

public class LoginResponseDTO {

    private String username;

    public LoginResponseDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

