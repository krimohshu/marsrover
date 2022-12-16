package com.marsrover.steps;

import com.marsrover.CucumberAutomationApp;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("qa")
@EnableAutoConfiguration
@ContextConfiguration(classes = CucumberAutomationApp.class)
@TestPropertySource({
        "classpath:application.properties",
        "classpath:application.${spring.profiles.active}.properties"
})
public class CucumberContextConfiguration {
    private static final Logger log = LoggerFactory.getLogger(CucumberContextConfiguration.class);

    @Autowired
    private ConfigurableEnvironment env;

    /* @LocalServerPort
     protected int port;
 */
    private RequestSpecification requestSpecification;
    private final String version;

    @Autowired
    public CucumberContextConfiguration(@Value("${rest.baseurl}") String baseUrl, @Value("${version.number}") String version) {
        this.version = version;
        RestAssured.baseURI = baseUrl + version;
        //TODO: Removed relaxedHTTPSValidation when trusted cert is used. Add trusted cert to keystore
        requestSpecification = RestAssured.given().relaxedHTTPSValidation();

    }

    @Test
    public void contextIntegrationTest() {
        System.out.println("A test of springboottest config");
    }

    @Given("hi")
    public void hi() {

    }

}