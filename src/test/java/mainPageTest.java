import drivers.driverSelection;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.mainPage;
import drivers.driverSelection;

    @RunWith(Parameterized.class)
    public class mainPageTest {
        private WebDriver driver;
        private final String checkText;
        private final String buttonForClick;


        public mainPageTest(String checkText, String buttonForClick) {
            this.checkText = checkText;
            this.buttonForClick = buttonForClick;
        }
        @Parameterized.Parameters
        public static Object[][] textPairs() {
            return new Object[][]{
                    {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "Сколько это стоит? И как оплатить?"},
                    {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "Хочу сразу несколько самокатов! Так можно?"},
                    {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "Как рассчитывается время аренды?"},
                    {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.","Можно ли заказать самокат прямо на сегодня?"},
                    {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.","Можно ли продлить заказ или вернуть самокат раньше?"},
                    {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.","Вы привозите зарядку вместе с самокатом?"},
                    {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.","Можно ли отменить заказ?"},
                    {"Да, обязательно. Всем самокатов! И Москве, и Московской области.","Я жизу за МКАДом, привезёте?"},
            };
        }


        @Test
        public void checkFAQ() {
            // драйвер для браузера Chrome
            driverSelection drvrSelectObj = new driverSelection();
            driver = drvrSelectObj.chromeSession();
            mainPage objLoginPage = new mainPage(driver);
            String result = objLoginPage.takingTextAfterClickFromFaq(buttonForClick);
            Assert.assertEquals(checkText, result);
        }

        @After
        public void quitChrome(){
            driver.quit();
        }


    }

