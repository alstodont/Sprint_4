package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;


public class mainPage {
    private WebDriver driver;
    public mainPage(WebDriver driver){
        this.driver = driver;
    }
    final static By cookieButton = By.xpath(".//*[text() = 'да все привыкли']");
    //FAQ -- поля
    //By.id("accordion__heading-0")
    //By.id("accordion__heading-7")

    //FAQ -- Раскрытые


        public String takingTextAfterClickFromFaq(String buttonForClick) {
            By foundedOpenedAccordion = findOpenedAccordion(buttonForClick);
            By foundedClosedAccordion = findClosedAccordion(buttonForClick);
            cookieCloser();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(foundedClosedAccordion));
            driver.findElement(foundedClosedAccordion).click();
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.elementToBeClickable(foundedOpenedAccordion));
            return driver.findElement(foundedOpenedAccordion).getText();
        }

        public By findClosedAccordion (String buttonForClick){
           return xpath(String.format(".//*[text()='%s']", buttonForClick));



        }

    public By findOpenedAccordion (String buttonForClick){
        return xpath(String.format("//div[(.//*[text()='%s']) and (@class = 'accordion__item')]/div[@class = 'accordion__panel']/p", buttonForClick));


    }
    public By findTopOrderButton(String entering){
        return xpath(String.format(".//*[@class = '%s']", entering));



    }
    public void clickOrderButton(String entering){
        By startOfOrder = findTopOrderButton(entering);
        cookieCloser();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(startOfOrder));
        driver.findElement(startOfOrder).click();
    }
    public void cookieCloser(){
        System.out.println(driver.findElement(cookieButton).getText());
           driver.findElement(cookieButton).click();
    }

        //название сайта в хэдере
        //Кнопка "заказать"
        //Кнопка "Статус заказа"
        //"Самокат на пару дней"
        //"Как это работает"
        //Кнопка "заказать" N2
}



