package com.slotegrator.api.endpoints;

import com.slotegrator.core.ContextProvider;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetPlayerById {

    private final String path = "/v2/players/{id}";

    @Step("Получение информации о пользователе - id:{userId}")
    public Response getUserInfoById(String userId) {
        return given()
                .auth()
                .oauth2(ContextProvider.getContext().getSessionData().getToken())
                .pathParam("id", userId)
                .when()
                .get(path);
    }
}
