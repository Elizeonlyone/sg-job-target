package com.slotegrator.core;

import com.slotegrator.api.data.User;
import lombok.Data;

@Data
public class SessionData {

    private String token;
    private String username;
    private String password;
    private String baseUrl;
    private User apiUser;

}
