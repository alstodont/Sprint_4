package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;



public class driverSelection {

    String url = "https://qa-scooter.praktikum-services.ru/";

    public WebDriver chromeSession() {
        //System.setProperty("webdriver.chrome.driver", "C://Program Files//WebDriver//bin//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        return driver;
    }

    public WebDriver firefoxSession() {
        //System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDriver\\bin\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        //.addPreference("browser.startup.page",3)
        //.addPreference("browser.startup.homepage", url);
        options.addArguments( "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new FirefoxDriver(options);
        driver.get(url);
        return driver;
    }
}
