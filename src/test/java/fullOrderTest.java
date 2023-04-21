import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.arendPage;
import pom.forWhoPage;
import pom.mainPage;
import drivers.driverSelection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class fullOrderTest {
    private WebDriver driver;
    String entering;
    String name;
    String surname;
    String address;
    String metro;
    String phone;
    String date;
    String due;
    String color;
    boolean browser;
    String comment;
    public fullOrderTest(boolean browser, String entering, String name, String surname, String address, String metro, String phone, String date, String due, String color, String comment) {
        this.browser = browser;
        this.entering = entering;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.due = due;
        this.color=color;
        this.comment=comment;
    }
    @Parameterized.Parameters
      public static Object[][] testReferences() {
         return new Object[][]{
                  {true,"Button_Button__ra12g","ывапвапывпывап", "апрвапрвапрвап", "арывапвапва", "Кунцевская", "89999999999","22.04.2023" ,"двое суток" ,"чёрный жемчуг" ,"ЫЫЫ!" },
                  {false,"Button_Button__ra12g Button_Middle__1CSJM","ывапвапывпывап", "апрвапрвапрвап", "арывапвапва", "Кунцевская", "89999999999","22.04.2023" ,"двое суток" ,"чёрный жемчуг" ,"ЫЫЫ!" },

         };
      }


    @Test
    public void ordering(){
        System.out.println(browser);
        driverSelection drvrSelectObj = new driverSelection();
        if (browser){
            driver = drvrSelectObj.chromeSession();
        }else{
            driver = drvrSelectObj.firefoxSession();
        }
        mainPage mainPageObj = new mainPage(driver);
        mainPageObj.clickOrderButton(entering);
        forWhoPage whoPageObj = new forWhoPage(driver);
        whoPageObj.passingForWhoPage(name, surname, address, metro, phone);
        arendPage arendObj = new arendPage(driver);
        String result = arendObj.passingArendPage(date, due, color, comment);
        assertTrue(result.contains("Заказ оформлен"));
    }
    @After
    public void quitChrome(){
        driver.quit();
    }
}
