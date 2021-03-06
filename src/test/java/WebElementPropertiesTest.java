import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

public class WebElementPropertiesTest {
  protected static WebDriver driver;
  private Logger logger = LogManager.getLogger(WebElementPropertiesTest.class);

  @BeforeEach
  public void setUp(){
    driver = WebDriverFactory.getDriver("chrome");
    logger.info("Драйвер стартовал!");
  }

  @Test
  public void getTagNameTest() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().window().maximize();
    driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    logger.info("Открыта страница demosite.executeautomation.com - " +
            "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    WebElement element = driver.findElement(By.id("FirstName"));

    //получение имени тега элемнта
    String tagName = element.getTagName();
    logger.info("Tag Name: <" + tagName + ">");
    Assertions.assertTrue(tagName.equals("input"),"Значение tagNme != input");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void getAttributeTest() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().window().maximize();
    driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    logger.info("Открыта страница demosite.executeautomation.com - " +
        "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    WebElement element = driver.findElement(By.id("FirstName"));
    // Получение значения атрибута элемента
    String attributeValue = element.getAttribute("name");
    logger.info("Attribute Value: name = " + attributeValue);
    Assertions.assertTrue(attributeValue.equals("FirstName"), "Значение attributeValue != FirstName!");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void  getSizeTest() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().window().maximize();
    driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    logger.info("Открыта страница demosite.executeautomation.com - " +
        "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    WebElement element = driver.findElement(By.id("FirstName"));
   Dimension size = element.getSize();
   int height = size.getHeight();
   int width = size.getWidth();
   logger.info("Size: height = " + height + " width = " + width);
   Assertions.assertTrue(height == 21, "Значение height != 21!");
   Assertions.assertTrue(width == 128, "Значение width != 128!");

   try {
     Thread.sleep(10000);
   } catch (InterruptedException e) {
     e.printStackTrace();
   }
  }

  @Test
  public void getLocationTest() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().window().maximize();
    driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    logger.info("Открыта страница demosite.executeautomation.com - " +
        "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    WebElement element = driver.findElement(By.id("FirstName"));
    // Получение положения верхнего левого угла (значения координат x, y) элемента
    Point location = element.getLocation();
    int x = location.getX();
    int y = location.getY();
    logger.info("Location: x = " + x + " y = " + y);
    Assertions.assertTrue(x == 136, "Значение x != 136!");
    Assertions.assertTrue(y == 276, "Значение y != 276!");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void getRectTest() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().window().maximize();
    driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    logger.info("Открыта страница demosite.executeautomation.com - " +
        "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    WebElement element = driver.findElement(By.id("FirstName"));
    // Получение размеров и положения верхнего левого угла элемента
    Rectangle rect = element.getRect();

    Dimension size = rect.getDimension();
    int height = size.getHeight();
    int width = size.getWidth();
    logger.info("Size: height = " + height + " width = " + width);
    Assertions.assertTrue(height == 21, "Значение height != 21!");
    Assertions.assertTrue(width == 128, "Значение width != 128!");

    Point location = rect.getPoint();
    int x = location.getX();
    int y = location.getY();
    logger.info("Location: x = " + x + " y = " + y);
    Assertions.assertTrue(x == 136, "Значение x != 136!");
    Assertions.assertTrue(y == 276, "Значение y != 276!");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e){
      e.printStackTrace();
    }
  }

  @Test
  public void isDisplayedTest() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().window().maximize();
    driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    logger.info("Открыта страница demosite.executeautomation.com - " +
        "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    WebElement element = driver.findElement(By.id("FirstName"));
    boolean isDiaspayed = element.isDisplayed();
    logger.info("Is displayed:" + isDiaspayed);
    Assertions.assertTrue(isDiaspayed, "Не оттображается!");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void isEnabledTest() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().window().maximize();
    driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    logger.info("Открыта страница demosite.executeautomation.com - " +
        "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    WebElement element = driver.findElement(By.id("FirstName"));
    // Проверка доступности элемента
    boolean isEnabled = element.isEnabled();
    logger.info("Is Enabled: " + isEnabled);
    Assertions.assertTrue(isEnabled, "Не доступна!");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void isSelectedTest() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().window().maximize();
    driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    logger.info("Открыта страница demosite.executeautomation.com - " +
        "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    WebElement element = driver.findElement(By.id("FirstName"));
    // Проверка выбора элемента
    boolean isSelected = element.isSelected();
    logger.info("Is Selected: " + isSelected);
    Assertions.assertFalse(isSelected, "Выбрана!");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void getTextTest() {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().window().maximize();
    driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    logger.info("Открыта страница demosite.executeautomation.com - " +
        "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    WebElement element = driver.findElement(By.tagName("h1"));
    // Получение текстового содержимого элемента
    String text = element.getText();
    logger.info("Text: " + text);
    Assertions.assertTrue(text.contains("Selenium"), "Значение text не содержит Selenium!");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void getCssValueTest(){
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().window().maximize();
    driver.get("https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    logger.info("Открыта страница demosite.executeautomation.com - " +
        "https://demosite.executeautomation.com/index.html?UserName=&Password=&Login=Login");
    WebElement element = driver.findElement(By.id("FirstName"));
    // Получение значения CSS элемента
    String cssValue = element.getCssValue("width");
    logger.info("Css Value: width = " + cssValue);
    Assertions.assertTrue(cssValue.equals("120px"), "Значение cssValue != 120px!");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @AfterEach
  public void setDown(){
    if (driver != null) {
      driver.quit();
      logger.info("Драйвер выключен!");
    }
  }
}
