package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import static org.openqa.selenium.By.xpath;

public class forWhoPage {
    private WebDriver driver;
    public forWhoPage(WebDriver driver){
        this.driver = driver;
    }
    final By findName = By.xpath(".//*[@placeholder = '* Имя']");
    final By findSurname =  By.xpath(".//*[@placeholder = '* Фамилия']");
    final By findAddress = By.xpath(".//*[@placeholder = '* Адрес: куда привезти заказ']");
    final By findMetro = By.xpath(".//*[@placeholder = '* Станция метро']");
    final By findPhone = By.xpath(".//*[@placeholder = '* Телефон: на него позвонит курьер']");
    final By nextButton = By.xpath(".//*[text() = 'Далее']");

    public void passingForWhoPage(String name, String surname, String address, String metro, String phone){

        driver.findElement(findName).sendKeys(name);
        driver.findElement(findSurname).sendKeys(surname);
        driver.findElement(findAddress).sendKeys(address);
        driver.findElement(findMetro).click();
        findingStation(metro);
        driver.findElement(findPhone).sendKeys(phone);
        driver.findElement(nextButton).click();
    }
    public void findingStation(String metro) {
        By findStation = xpath(String.format(".//*[text() = '%s']", metro));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(findStation));
        driver.findElement(findStation).click();
    }


}
