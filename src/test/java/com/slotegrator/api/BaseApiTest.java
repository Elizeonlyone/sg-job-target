package com.slotegrator.api;

import com.slotegrator.core.Config;
import com.slotegrator.core.Context;
import com.slotegrator.core.ContextProvider;
import com.slotegrator.core.SessionData;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;

public class BaseApiTest {

    @BeforeEach
    public void beforeScenario() {
        contextCreation();
        RestAssured.baseURI = ContextProvider.getContext().getSessionData().getBaseUrl();
    }

    private void contextCreation() {
        Context context;
        if (ContextProvider.getContext() == null) {
            context = new Context();
            ContextProvider.setContext(context);
        } else {
            context = ContextProvider.getContext();
        }
        SoftAssertions softAssert = new SoftAssertions();
        context.setSoftAssert(softAssert);
        ContextProvider.getContext().setSessionData(initTestClassSessionDataTemplate());
    }

    private SessionData initTestClassSessionDataTemplate() {
        SessionData sessionData = new SessionData();
        sessionData.setBaseUrl(Config.API_URL);
        sessionData.setUsername(Config.API_BASIC_AUTH);
        sessionData.setPassword("");
        return sessionData;
    }
}
