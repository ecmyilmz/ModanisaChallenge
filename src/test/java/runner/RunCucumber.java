package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.gen.Core;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@CucumberOptions(features = {"classpath:features"}
                  //, tags = {"@regression"}
                 ,glue = {"stepdefinitions"}
                 )

@Test
public class RunCucumber extends AbstractTestNGCucumberTests {


    private static String HOST = "localhost";
    private static int PROXY = 40496;
    public static WebDriver driver;

    @BeforeMethod
    public static void setup() throws InterruptedException, IOException {
        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(HOST + ":" + PROXY)
                .setFtpProxy(HOST + ":" + PROXY)
                .setSslProxy(HOST + ":" + PROXY);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PROXY, proxy);
        // Open ZAP Tool
        Desktop.getDesktop().open(new File("/Applications/OWASP ZAP.app"));

        Thread.sleep(20000);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://todomvc.com/examples/vue/");
    }
    @AfterMethod
    public void teardown(){
        try {
            ClientApi clientApi = new ClientApi(HOST, PROXY);
            Core core = new Core(clientApi);
            FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/HtmlReport/ModanisaZAPHtmlReport.html");
            fos.write(core.htmlreport("ed06mf5o7nehlpgcbplji3nr68"));
            fos.close();
        } catch (Exception ex) {
        }

        if (driver != null) {
            driver.quit();
        }

    }

}
