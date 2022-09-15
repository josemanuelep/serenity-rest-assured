package stepsdefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import model.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import tasks.login.*;

import java.util.*;

public class LoginSteps {

    @DataTableType
    public LoginData authorEntry(Map<String, String> entry) {
        return new LoginData(entry.get("email"), entry.get("password"));
    }

    @Given("Sam login with credentials")
    public void sam_login_with_credentials(LoginData login) {
        theActorInTheSpotlight().attemptsTo(Login.withGivenUser(login));
    }
}
