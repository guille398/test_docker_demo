package Runner;

import Pages.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/"},
        glue = "Steps",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        dryRun = false,
        tags = "@SmokeTest"
)
public class Runner {
    @AfterClass
    public static void afterAll() {
       BasePage.closeDriver();
    }
}
