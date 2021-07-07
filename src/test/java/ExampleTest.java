import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExampleTest {

  protected static WebDriver driver;
  private final Logger logger = LogManager.getLogger(ExampleTest.class);

  //читаем передаваемый праметр browser по ключ-значению
  String env = System.getProperty("browser", "chrome");

  @BeforeEach
  public void setUp() {
    logger.info("env = " + env);
    driver = WebDriverFactory.getDriver(env.toLowerCase());
    logger.info("Драйвер стартовал");
    //WebDriverManager.chromedriver().setup();
    //driver = new ChromeDriver();
    //logger.info("Драйвер стартовал!");
  }

  @Test
  public void openPage() {
    driver.get("https://yandex.ru/");
    logger.info("Открыта страница Yandex - " + "https://yandex.ru/");

    //выводим заголовлок страцицы  методом .getTitle()
    String title = driver.getTitle();
    logger.info("Title - ", title.toString());

    //вывод URL методом .getCurrentUrl()
    String currentURL = driver.getCurrentUrl();
    logger.info("CurrentURL - ", currentURL.toString());

    //ввод текста для строки поиска
    String searchInputPath = ".//input[@class='input__control input__input mini-suggest__input']";
    WebElement searchInput = driver.findElement(By.xpath(searchInputPath));
    String searchText = "QA Automation";
    searchInput.sendKeys(searchText);

    //нажатие кнопки найти
    String searchButtonXpath = ".//button[@class='button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']";
    WebElement searchButton = driver.findElement(By.xpath(searchButtonXpath));
    searchButton.click();

    //задержка выполнения для отслеживания результата
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    ;
  }

  @AfterEach
  public void setDown() {
    if (driver != null) {
      driver.quit();
      logger.info("Драйвер остановлен!");
    }
  }
}

