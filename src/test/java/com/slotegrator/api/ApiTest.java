package com.slotegrator.api;

import com.slotegrator.api.endpoints.GetPlayerById;
import com.slotegrator.api.endpoints.PostOauthToken;
import com.slotegrator.api.endpoints.PostRegisterNewPlayer;
import com.slotegrator.core.ContextProvider;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


@DisplayName("API test Suite")
public class ApiTest extends BaseApiTest {

    PostOauthToken postOauthToken = new PostOauthToken();
    PostRegisterNewPlayer postRegisterNewPlayer = new PostRegisterNewPlayer();
    GetPlayerById getPlayerById = new GetPlayerById();


    @Test
    @DisplayName("E2E тест по созданию пользователя и проверке доступов")
    public void apiTest() {
        //Получение токена гостя
        Response oauthGuestResponse = postOauthToken.getDefaultGuestToken();
        oauthGuestResponse
                .then().statusCode(200).assertThat().body(matchesJsonSchemaInClasspath("json-schemas/oauth.json"));

        ContextProvider.getContext().getSessionData().setToken(
                oauthGuestResponse.jsonPath().get("access_token"));

        //Регистрация нового юзера
        Response registerNewPlayerResponse = postRegisterNewPlayer.createNewRandomUser();
        registerNewPlayerResponse
                .then().statusCode(201).assertThat().body(matchesJsonSchemaInClasspath("json-schemas/user-profile.json"));
        ContextProvider.getContext().getSessionData().getApiUser()
                .setId(registerNewPlayerResponse.jsonPath().get("id").toString());

        //Авторизация под созданным игроком
        Response oauthUserResponse = postOauthToken.getUserToken(
                ContextProvider.getContext().getSessionData().getApiUser());
        oauthUserResponse
                .then().statusCode(200).assertThat().body(matchesJsonSchemaInClasspath("json-schemas/oauth.json"));
        ContextProvider.getContext().getSessionData().setToken(
                oauthUserResponse.jsonPath().get("access_token"));

        //Запросить данные профиля игрока
        getPlayerById.getUserInfoById(ContextProvider.getContext().getSessionData().getApiUser().getId())
                .then().statusCode(200).assertThat().body(matchesJsonSchemaInClasspath("json-schemas/user-profile.json"));

        //Запросить данные другого игрока
        getPlayerById.getUserInfoById("1")
                .then().statusCode(404).assertThat().body(matchesJsonSchemaInClasspath("json-schemas/error.json"));
    }
}
