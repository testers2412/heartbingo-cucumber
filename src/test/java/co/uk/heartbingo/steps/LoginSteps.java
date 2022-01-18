package co.uk.heartbingo.steps;

import co.uk.heartbingo.pages.HomePage;
import co.uk.heartbingo.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
    @Given("^User is on home page$")
    public void userIsOnHomePage() {
    }

    @When("^User click on Login button$")
    public void userClickOnLoginButton() {
        new HomePage().clickOnLogin();
    }

    @Then("^verify user is on Login page$")
    public void verifyUserIsOnLoginPage() {
        new LoginPage().verifyLoginPage();
    }

    @And("^enters username and password \"([^\"]*)\" \"([^\"]*)\"$")
    public void entersUsernameAndPassword(String arg0, String arg1)  {


    }

    @Then("^verify the error message \"([^\"]*)\"$")
    public void verifyTheErrorMessage(String arg0)  {


    }
}
