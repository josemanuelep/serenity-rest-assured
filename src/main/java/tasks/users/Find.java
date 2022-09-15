package tasks.users;

import net.serenitybdd.screenplay.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.rest.interactions.*;

public class Find implements Task {
    private final int page;

    public Find(int page) {
        this.page = page;
    }

    public static Find fromPage(int id) {
        return instrumented(Find.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users").with(request -> request.queryParam("page", page))
        );

    }
}