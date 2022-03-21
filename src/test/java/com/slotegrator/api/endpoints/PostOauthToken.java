package com.slotegrator.api.endpoints;

import com.slotegrator.api.data.User;
import com.slotegrator.core.ContextProvider;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.restassured.RestAssured.*;

public class PostOauthToken {

    private final String path = "/v2/oauth2/token";

    @Step("Получение токена гостя")
    public Response getDefaultGuestToken() {
        return given()
                .auth()
                .preemptive()
                .basic(ContextProvider.getContext().getSessionData().getUsername(),
                        ContextProvider.getContext().getSessionData().getPassword())
                .with()
                .body(DEFAULT_GUEST_BODY())
                .when()
                .contentType(ContentType.JSON)
                .post(path);
    }

    @Step("Получение токена существующего юзера - {user.username}")
    public Response getUserToken(User user) {
        Body body = new Body("password",
                null,
                user.getUsername(),
                user.getEncodedPassword());

        return given()
                .auth()
                .preemptive()
                .basic(ContextProvider.getContext().getSessionData().getUsername(),
                        ContextProvider.getContext().getSessionData().getPassword())
                .with()
                .body(body)
                .when()
                .contentType(ContentType.JSON)
                .post(path);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Body {
        String grant_type;
        String scope;
        String username;
        String password;
    }

    //DATA PROVIDER
    final Body DEFAULT_GUEST_BODY() {
        Body body = new Body();
        body.setGrant_type("client_credentials");
        body.setScope("guest:default");
        return body;
    }
}
