import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ForumTest {

    @Test
    public void loginWithInvalidCredentials() throws Exception{
        System.setProperty("webdriver.chrome.driver","libs/chromedriver");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName",System.getProperty("browserType"));
        caps.setCapability("platform", System.getProperty("platformType"));
        caps.setCapability("version", System.getProperty("browserVersion"));

        String USERNAME = "guancao";
        String ACCESS_KEY = "5cc18117-ac69-4c0f-8f49-f2d6d0498ee1";
        String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


        WebDriver driver = new RemoteWebDriver(new URL(URL),caps);
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

        driver.get("https://forum.piit.us/");

        driver.findElement(By.name("user")).sendKeys("testuser");
        driver.findElement(By.name("passwrd")).sendKeys("test1234");
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[3]/p/input")).click();

        driver.quit();
    }
}
