package StepDefinition;

import PageObject.openMap;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class stepDef {
    static WebDriver driver;

    static openMap openmap;

    @Given("User Lunch Chrome browser")
    public void user_lunch_chrome_browser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        openmap = new openMap(driver);
    }

    @When("User open URL {string}")
    public void user_open_url(String string) {
        driver.get(string);
    }

    @Then("Page Title Should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.printf("Passing");
            assertTrue(true);
        } else {
            System.out.printf("failing:- "+actualTitle);
            fail();
        }
    }

    @Then("Close browser")
    public void close_browser() {
        driver.close();
        driver.quit();
    }
    @When("User click on search button and search as {string}")
    public void userClickOnSearchButtonAndSearchAs(String arg0) {
        openmap.searchDestination(arg0);

    }

    @Then("the user should see {string} in the search results")
    public void the_user_should_see_in_the_search_results(String text) {
        String searchOutput = openmap.searchOutput();
        if (searchOutput.equals(text)){
            System.out.printf("Search output passed");
            assertTrue(true);
        }else{
            System.out.printf("Search output falied");
            fail();
        }
    }
    @Given("the user click on direction button")
    public void the_user_click_on_direction_button() {
        openmap.clickDirectionBtn();
    }
    @When("the user enters {string} as the starting location")
    public void the_user_enters_as_the_starting_location(String string) {
       openmap.enterStartingPoint(string);
    }
    @When("enters {string} as the destination")
    public void enters_as_the_destination(String string) {
        openmap.enterDestinationPoint(string);
    }
    @When("clicks on driving icon")
    public void clicks_on_driving_icon() {
       openmap.clickDrivingBtn();
    }
    @Then("the map should display the route between the two locations")
    public void the_map_should_display_the_route_between_the_two_locations() {
        System.out.println("show rout");
        if (openmap.showRoute())
            assertTrue(true);
        else
            fail();
    }
    @Then("the estimated travel time and distance should be shown")
    public void the_estimated_travel_time_and_distance_should_be_shown() {
        String estimatedTime = openmap.getEstimateTime();
        if (estimatedTime!= null){
            assertTrue(true);
        }
        else {
            fail();
        }
    }


}
