package co.com.webtest.certification.globant.runners;

import io.cucumber.junit.*;
import net.serenitybdd.cucumber.*;
import org.junit.runner.*;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/",
        glue = "co.com.webtest.certification.globant.stepsdefinitions"
)
public class TestRunner {
}
