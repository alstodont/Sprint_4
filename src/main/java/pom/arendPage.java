package pom;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class arendPage {
    private WebDriver driver;

    public arendPage(WebDriver driver){
        this.driver = driver;
    }
    final By findDate = By.xpath(".//*[@placeholder = '* Когда привезти самокат']");
    final By findPeriod = By.xpath(".//*[text() = '* Срок аренды']/parent::div");

    final By findComment = By.xpath(".//*[@placeholder = 'Комментарий для курьера']");
    final By orderButton = By.xpath(".//*[(@class ='Button_Button__ra12g Button_Middle__1CSJM')]");
    final By yesButton = By.xpath(".//*[text() = 'Да']");

    final By ordered = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]");

    public void setColor(String color) {
        By findColor = By.xpath(String.format(".//*[text() = '%s']", color));
        driver.findElement(findColor).click();
    }
    public String passingArendPage(String date, String due, String color, String comment) {
        driver.findElement(findDate).sendKeys(date);
        driver.findElement(findDate).sendKeys(Keys.RETURN);
        driver.findElement(findPeriod).click();
        By findDue = lookForDue(due);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(findDue));
        driver.findElement(findDue).click();
        setColor(color);
        driver.findElement(findComment).sendKeys(comment);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(orderButton));
        driver.findElement(orderButton).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(yesButton));
        driver.findElement(yesButton).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(driver.findElement(ordered)));
        return driver.findElement(ordered).getText();
    }
    public void cookieCloser(){
        driver.findElement(mainPage.cookieButton).click();
    }

    public By lookForDue(String due){
        return By.xpath(String.format(".//*[text() = '%s']", due));
    }



}
