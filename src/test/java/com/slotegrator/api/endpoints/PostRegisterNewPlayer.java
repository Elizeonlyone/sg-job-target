package com.slotegrator.api.endpoints;

import com.slotegrator.api.data.User;
import com.slotegrator.core.ContextProvider;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import static io.restassured.RestAssured.given;

public class PostRegisterNewPlayer {

    private final String path = "/v2/players";


    @Step("Создание нового пользователя")
    public Response createNewRandomUser() {
        return given()
                .auth()
                .oauth2(ContextProvider.getContext().getSessionData().getToken())
                .with()
                .body(RANDOM_NEW_USER())
                .when()
                .contentType(ContentType.JSON)
                .post(path);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Body {
        String username;
        String password_change;
        String password_repeat;
        String email;
        String name;
        String surname;
        String currency_code;
    }

    //DATA PROVIDER
    final Body RANDOM_NEW_USER() {
        User user = new User(
                "testUser_" + RandomStringUtils.random(5, true, true),
                RandomStringUtils.random(8, true, true),
                RandomStringUtils.random(8, true, true) + "@test.com",
                null);
        ContextProvider.getContext().getSessionData().setApiUser(user);

        Body body = new Body();
        body.setUsername(user.getUsername());
        body.setPassword_change(user.getEncodedPassword());
        body.setPassword_repeat(user.getEncodedPassword());
        body.setEmail(user.getEmail());
        body.setName("Auto");
        body.setSurname("Bot");
        body.setCurrency_code("RUB");
        return body;
    }
}
