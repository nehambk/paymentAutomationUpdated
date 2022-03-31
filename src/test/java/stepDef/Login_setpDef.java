package stepDef;

import helper.LoginHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_setpDef
{
    LoginHelper loginHelper = new LoginHelper();

    @Given("API Url and Headers")
    public void apiHeaders(){
        loginHelper.setURL();
        loginHelper.header();
    }

    @When("I enter {string}")
    public void iEnterMobileNumber(String mobile_Number)
    {
        loginHelper.createRequest("cell", mobile_Number);
    }

    @Then("An OTP should be generated")
    public void otpGeneration()
    {
        loginHelper.postResponse();
    }

    @Then("Read OTP from database for {string}")
    public void readOtp(String mobile_Number)
    {
        loginHelper.readOtpFromTable(mobile_Number);
    }


}
