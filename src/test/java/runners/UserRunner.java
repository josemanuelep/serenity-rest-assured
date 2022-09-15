package runners;

import io.cucumber.junit.*;
import net.serenitybdd.cucumber.*;
import org.junit.runner.*;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/Users.feature",
        tags = "@Regression",
        glue = "stepsdefinitions"
)
public class UserRunner {
}
