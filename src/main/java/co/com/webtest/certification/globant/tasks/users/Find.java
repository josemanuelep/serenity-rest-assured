package co.com.webtest.certification.globant.tasks.users;

import net.serenitybdd.screenplay.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.rest.interactions.*;
import net.thucydides.core.annotations.*;

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
                Get.resource("/users/{page}")
                        .with(request -> request.pathParam("page", page)
                                .contentType("application/json"))
        );
    }
}