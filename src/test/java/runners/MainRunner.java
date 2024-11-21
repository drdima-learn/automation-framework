package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"classpath:features"},
        /*tags = "@contact-us or @login",*/
        tags = "@regression",
        glue = "stepDefinitions",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json"}
)
public class MainRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
