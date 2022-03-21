package com.slotegrator.core;

import lombok.Data;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;


@Data
public class Context {

    private SessionData sessionData;
    private SoftAssertions softAssert;
    private Assertions anAssert;

}
