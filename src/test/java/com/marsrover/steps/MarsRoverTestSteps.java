package com.marsrover.steps;


import com.marsrover.Rover;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.assertj.core.api.SoftAssertions;

public class MarsRoverTestSteps extends AbstractStepDefinition {

    private static final Logger log = LoggerFactory.getLogger(MarsRoverTestSteps.class);

    @Autowired
    Environment environment;

    @Autowired
    private Rover rover;

    @Before
    public void before(final Scenario scenario) {
        super.before(scenario);
    }

    @Given("rover is initialized")
    public void rover_is_initialized() {
        System.out.println("shyam");
    }

    @Then("rover is on the {int}, {int} cordinates")
    public void rover_is_on_the_cordinates(int xCordinate, int yCcordinate) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(rover.getX().intValue()).isEqualTo(xCordinate);
        softly.assertThat(rover.getY().intValue()).isEqualTo(yCcordinate);
        softly.assertAll();

    }



}
