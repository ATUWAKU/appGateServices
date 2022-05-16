package com.appgate.prueba.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/Features/TimeZoneQuery.feature",
        glue = "com.appgate.prueba.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class TimeZoneQueryRunner {
}
