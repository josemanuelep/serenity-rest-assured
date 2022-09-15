package tasks.users;

import model.*;
import net.serenitybdd.screenplay.*;
import static net.serenitybdd.screenplay.Tasks.*;
import net.serenitybdd.screenplay.rest.interactions.*;
import net.thucydides.core.annotations.*;

public class Update implements Task {
    private final User user;

    public Update(User user) {
        this.user = user;
    }

    public static Update withGivenUser(User user) {
        return instrumented(Update.class, user);
    }

    @Override
    @Step("{0} update user with id #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users/{id}")
                        .with(request -> request.body("{\n" +
                                        "    \"name\": \"" + user.getName() + "\",\n" +
                                        "    \"job\": \"" + user.getJob() + "\"\n" +
                                        "}").pathParam("id", user.getId())
                                .contentType("application/json"))
        );
    }
}