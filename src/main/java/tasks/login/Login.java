package tasks.login;
import model.*;
import net.serenitybdd.screenplay.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.rest.interactions.*;

public class Login implements Task {

    private LoginData user;

    public Login(LoginData user) {
        this.user = user;
    }

    public static Login withGivenUser(LoginData user) {
        return instrumented(Login.class, user);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/login")
                        .with(request -> request.body("{\n" +
                                        "    \"email\": \"" + user.getEmail() + "\",\n" +
                                        "    \"password\": \"" + user.getPassword() + "\"\n" +
                                        "}")
                                .contentType("application/json"))
        );

    }
}
