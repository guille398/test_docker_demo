package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
           features = {"src/test/resources/"},
           glue = {"Steps","hooks"},
           plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
           tags = "@SmokeTest"
    )

public class RunnerGrid extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }


