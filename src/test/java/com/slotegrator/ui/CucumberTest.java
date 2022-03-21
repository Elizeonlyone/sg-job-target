package com.slotegrator.ui;

import org.junit.jupiter.api.DisplayName;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features")
@DisplayName("Cucumber UI tests")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.slotegrator.ui.steps")
public class CucumberTest {

}
