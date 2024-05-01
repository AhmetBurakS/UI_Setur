package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import logger.TestResultLogger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

@ExtendWith(TestResultLogger.class)

public class Driver {

    private Driver(){

    }

    static WebDriver driver;
    public static WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");

        if (driver == null){

            switch (browser){

                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver= new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:

                    ChromeOptions options = new ChromeOptions();

                    // Gizli modu etkinleştir
                    options.addArguments("--incognito");
                    options.addArguments("--disable-notifications"); // Bildirimleri devre dışı bırakmak için


                    driver = new ChromeDriver();
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }
    }
}