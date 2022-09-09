package co.com.webtest.certification.globant.stepsdefinitions;


import co.com.webtest.certification.globant.model.*;
import co.com.webtest.certification.globant.tasks.users.*;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.rest.abilities.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import net.thucydides.core.util.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.*;

public class GeneralSteps {

    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor sam;

    @DataTableType
    public User authorEntry(Map<String, String> entry) {
        return new User(entry.get("name"), entry.get("job"));
    }

    @Before
    public void configureBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");

        sam = Actor.named("Sam the supervisor").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @Given("Sam the supervisor fetches all users from page {int}")
    public void sam_the_supervisor_fetches_all_users(int page) {
        sam.attemptsTo(
                Find.fromPage(page)
        );
    }

    @Then("User details should be correct")
    public void user_details_should_be_correct() {
        sam.should(
                seeThatResponse("User details should be correct",
                        response -> response.statusCode(200)
                                .body("data.first_name", equalTo("George"))
                                .body("data.last_name", equalTo("Bluth"))
                )
        );
    }

    @Given("Sam create the given user")
    public void sam_create_the_given_user(User user) {

    }
    @Then("The status code of the response should be {int}")
    public void the_status_code_of_the_response_should_be(int status) {
    }

}