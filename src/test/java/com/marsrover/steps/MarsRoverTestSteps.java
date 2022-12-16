package com.marsrover.steps;


import com.marsrover.Rover;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.assertj.core.api.SoftAssertions;

public class MarsRoverTestSteps extends AbstractStepDefinition {

    private static final Logger log = LoggerFactory.getLogger(MarsRoverTestSteps.class);

    @Autowired
    private Environment environment;

    @Autowired
    private Rover rover;

    @Before
    public void before(final Scenario scenario) {
        super.before(scenario);
    }

    @Given("rover is initialized {int} and {int}")
    public void rover_is_initialized(int x_starting, int y_starting) {
       rover.setX(x_starting);
       rover.setY(y_starting);
    }

    @When("rover process the command {string}")
    public void rover_process_the_command(String command) {
         rover.process(command);
    }


    @Then("{string} rover is on the {int}, {int} cordinates facing {int}")
    public void rover_is_on_the_cordinates(String userInputOfRoverPosition, int xCordinate, int yCcordinate, int facing) {
       if ("GET".equalsIgnoreCase(userInputOfRoverPosition)){
            verifiyRoverPosition( xCordinate,  yCcordinate, facing);
        }
        if ("SET".equalsIgnoreCase(userInputOfRoverPosition)){
            rover.setPosition(xCordinate, yCcordinate ,Rover.N );
        }

    }

    public void verifiyRoverPosition(int xCordinate, int yCcordinate, int facing){
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(rover.getX().intValue()).isEqualTo(xCordinate);
        softly.assertThat(rover.getY().intValue()).isEqualTo(yCcordinate);
        softly.assertThat(rover.getFacing().intValue()).isEqualTo(facing);
        softly.assertAll();
    }


}
