package Runner;



import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = {"src/test/resources/"},
        glue = {"Steps","hooks"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        dryRun = false,
        tags = "@SmokeTest"
)
@Test
public class Runner extends AbstractTestNGCucumberTests {
}
