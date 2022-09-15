package runners;

import io.cucumber.junit.*;
import net.serenitybdd.cucumber.*;
import org.junit.runner.*;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/Login.feature",
        tags = "@Regression",
        glue = "stepsdefinitions"
)
public class LoginRunner {
}
