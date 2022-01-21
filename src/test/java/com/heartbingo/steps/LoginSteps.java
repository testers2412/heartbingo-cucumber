package com.heartbingo.steps;

import com.heartbingo.pages.HomePage;
import com.heartbingo.pages.LoginPage;
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
    public void entersUsernameAndPassword(String email, String password)  {
   new LoginPage().enterCredentials(email,password);


    }
    @And("^click on login button$")
    public void clickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @Then("^verify the error message \"([^\"]*)\"$")
    public void verifyTheErrorMessage(String expectedMessage)  {

  new LoginPage().verifyErrorMessage(expectedMessage);
    }


}
