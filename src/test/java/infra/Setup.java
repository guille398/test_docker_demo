package infra;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;




public class Setup {

    public static RemoteWebDriver driver;

    @Before
    public void setWebDriver() throws Exception {

        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }

        URL hub = new URL(System.getProperty("hub"));

        // switch (browser) {
        //     case "chrome":
        DesiredCapabilities capabilityCH = new DesiredCapabilities();
        capabilityCH.setBrowserName("chrome");
        capabilityCH.setPlatform(Platform.LINUX);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.merge(capabilityCH);
        driver = new RemoteWebDriver(hub, chromeOptions);
        //     case "firefox":
        //         DesiredCapabilities capabilityFX = new DesiredCapabilities();
        //         capabilityFX.setBrowserName("firefox");
        //         capabilityFX.setPlatform(Platform.LINUX);
        //         FirefoxOptions firefoxOptions = new FirefoxOptions();
        //         firefoxOptions.addArguments("--start-maximized");
        //         firefoxOptions.merge(capabilityFX);
        //         driver = new RemoteWebDriver(hub, capabilityFX);
        //     case "edge":
        //         DesiredCapabilities capabilityE = new DesiredCapabilities();
        //         capabilityE.setBrowserName("firefox");
        //         capabilityE.setPlatform(Platform.LINUX);
        //         EdgeOptions edgeOptions = new EdgeOptions();
        //         edgeOptions.addArguments("--start-maximized");
        //         edgeOptions.merge(capabilityE);
        //         driver = new RemoteWebDriver(hub, edgeOptions);
        // }
    }

}
