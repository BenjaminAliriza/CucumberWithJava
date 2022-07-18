package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue={"stepdefinitions"}, features = "src/test/resources", monochrome = true, plugin = { "pretty", "html:target/site/cucumber-pretty.html",
        "json:target/cucumber.json" })
public class RunCucumberTests {
}