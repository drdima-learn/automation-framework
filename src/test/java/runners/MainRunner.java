package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        tags = "@contact-us or @login",
        glue = "stepDefinitions",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json"}
)
public class MainRunner extends AbstractTestNGCucumberTests {

}
