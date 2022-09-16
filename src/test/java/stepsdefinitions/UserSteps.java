package stepsdefinitions;


import io.cucumber.java.*;
import io.cucumber.java.en.*;
import model.*;
import net.serenitybdd.screenplay.actors.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import net.serenitybdd.screenplay.rest.abilities.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import net.thucydides.core.util.*;
import org.hamcrest.*;
import tasks.users.*;

import java.util.*;

public class UserSteps {

    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;

    @DataTableType
    public User authorEntry(Map<String, String> entry) {
        return new User(entry.get("name"), entry.get("job"));
    }


    @Before
    public void configureBaseUrl() {
        OnStage.setTheStage(new OnlineCast());
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");
        theActorCalled("Sam").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @Given("Sam the supervisor fetches all users from page {int}")
    public void sam_the_supervisor_fetches_all_users(int page) {
        theActorInTheSpotlight().attemptsTo(
                Find.fromPage(page)
        );
        theActorInTheSpotlight().remember("page", page);
    }

    @Then("User details should be correct")
    public void user_details_should_be_correct() {
        theActorInTheSpotlight().should(
                seeThatResponse("User details should be correct",
                        response -> response
                                .body("data", Matchers.notNullValue())
                )
        );
    }

    @Given("Sam create the given user")
    public void sam_create_the_given_user(User user) {
        theActorInTheSpotlight().attemptsTo(Create.withGivenUser(user));
    }

    @Then("The status code of the response should be {int}")
    public void the_status_code_of_the_response_should_be(int status) {
        theActorInTheSpotlight().should(
                seeThatResponse("The response was correct",
                        response -> response.statusCode(status))
        );
    }

    @Given("Sam update an existing user with {int}")
    public void sam_update_an_existing_user(int id, User user) {
        user.setId(id);
        theActorInTheSpotlight().attemptsTo(Update.withGivenUser(user));

    }

}
