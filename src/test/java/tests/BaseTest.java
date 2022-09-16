package tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver(ITestContext ctx) throws IOException {

        String host="localhost";
        DesiredCapabilities dc;
        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc=DesiredCapabilities.firefox();
            dc.setBrowserName("firefox");
            dc.setPlatform(Platform.LINUX);

        }else{
            dc=DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST") != null){
            host=System.getProperty("HUB_HOST");
        }
        String testName=ctx.getCurrentXmlTest().getName();

        String completeUrl="http://" + host + ":4444/wd/hub";
        dc.setCapability("name", testName);
        this.driver=new RemoteWebDriver(new URL(completeUrl),dc);

    }

    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }
}

