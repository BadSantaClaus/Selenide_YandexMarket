package tests.selenide;

import allure.selenide.CustomAllureSelenide;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
/**
 * Класс используется для задания настроек прохождения тестов
 *
 * @author Горячев Роман Юрьевич
 */
public class BaseTests {
    /**
     * Метод для подключения скриншотов после каждого действия
     *
     * @author Горячев Роман Юрьевич
     */
    @BeforeAll
    public static void setup(){
        SelenideLogger.addListener("AllureSelenide", new CustomAllureSelenide()
                .screenshots(true));
    }
    /**
     * Метод для задания параметров вебдрайвера
     *
     * @author Горячев Роман Юрьевич
     */
    @BeforeEach
    public void option(){
        Configuration.timeout=20000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions", "--start-maximized", "--remote-allow-origins=*", "webdriver.http.factory", "jdk-http-client"
                , "--no-sandbox", "disable-infobars", "--start-maximized", "--single-process'",
                "--disable-dev-shm-usage", "--disable-blink-features=AutomationControlled", "log-level=3");
        System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));
        WebDriver driver;
        driver = new ChromeDriver(options);
        setWebDriver(driver);
    }
}
