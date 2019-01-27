package definitions;

import cucumber.api.java.en.When;
import pages.Login;


public class LoginStepDef {
    Login loginPage= new Login();

    @When("^I login into the official Page$")
    public void i_login() {
        loginPage.getURL();
    }

}
