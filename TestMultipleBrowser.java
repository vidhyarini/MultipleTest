
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestMultipleBrowser {
    public WebDriver driver;

    @Parameters("browser")

    @BeforeClass

    // Passing Browser parameter from TestNG xml

    public void beforeTest(String browser) {

        // If the browser is Firefox, then do this

        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","C:\\Selenium\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();

            // If browser is IE, then do this

        }else if (browser.equalsIgnoreCase("ie")) {

            // Here I am setting up the path for my IEDriver

            System.setProperty("webdriver.edge.driver", "C:\\Selenium\\drivers\\MicrosoftWebDriver.exe");

            driver = new EdgeDriver();

        }else if (browser.equalsIgnoreCase("Chrome")){
            // Here I am setting up the path for Chrome
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");

            driver = new ChromeDriver();
        }

        // Doesn't the browser type, lauch the Website

        driver.get("https://ruter.no/");

    }

    // Once Before method is completed, Test method will start

    @Test
    public void login() throws InterruptedException {

        driver.findElement(By.className("header__login-link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("LoginForm.Email.Value")).sendKeys("testuser_1");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("LoginForm.Password.Value")).sendKeys("Test@123");

    }

    @AfterClass
    public void afterTest() {

        driver.quit();

    }

}


