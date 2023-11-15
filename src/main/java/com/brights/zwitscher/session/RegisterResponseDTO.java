package com.brights.zwitscher.session;

public class RegisterResponseDTO {
    String username;

    public RegisterResponseDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
