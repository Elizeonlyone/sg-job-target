package com.slotegrator.api.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private String email;
    private String id;

    public String getEncodedPassword() {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}
