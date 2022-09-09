package co.com.webtest.certification.globant.tasks.users;

import co.com.webtest.certification.globant.model.*;
import net.serenitybdd.screenplay.*;
import static net.serenitybdd.screenplay.Tasks.*;
import net.serenitybdd.screenplay.rest.interactions.*;
import net.thucydides.core.annotations.*;

public class Create implements Task {
    private final User user;

    public Create(User user) {
        this.user = user;
    }

    public static Create withGivenUser(User user) {
        return instrumented(Create.class, user);
    }

    @Override
    @Step("{0} fetches the user with id #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users")
                        .with(request -> request.body("{\n" +
                                        "    \"name\": \"" + user.getName() + "\",\n" +
                                        "    \"job\": \"" + user.getJob() + "\"\n" +
                                        "}")
                                .contentType("application/json"))
        );
    }
}