import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import java.lang.Object;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowPropertiesTest {
  protected static WebDriver driver;
  private Logger logger = LogManager.getLogger(WindowPropertiesTest.class);
  String env = System.getProperty("browser", "chrome");

  @BeforeEach
  public void setUp() {
    logger.info("env = " + env);
    driver = WebDriverFactory.getDriver(env.toLowerCase());
    logger.info("Драйвер стартовал");
  }

  @Test
  public void fullScreenWindowTest() {
    // Открыть страницу https://devqa.io/
    driver.manage().window().fullscreen();
    driver.get("https://devqa.io/");
    logger.info("Открыта страница devqa.io - https://devqa.io/");

    // Установка полноэкранного режима окна браузера
    //driver.manage().window().fullscreen();
    logger.info("Окно переведено в полноэкранный режим");

    try {
      Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void getWindowPropertiesTest() {
    // Открыть страницу https://devqa.io/
    driver.get("https://devqa.io/");
    logger.info("Открыта страница devqa.io - https://devqa.io/");

    // Получить параметры окна
    // Координаты окна
    Point position = driver.manage().window().getPosition();
    logger.info("Координаты окна: [" + position.getX() + ", " + position.getY() + "]");
    // Размеры окна
    Dimension size = driver.manage().window().getSize();
    logger.info("Размеры окна: [" + size.getWidth() + ", " + size.getHeight() + "]");

    try {
      Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void setWindowPropertiesTest() {
    // Открыть страницу https://devqa.io/
    driver.get("https://devqa.io/");
    logger.info("Открыта страница devqa.io - https://devqa.io/");

    try {
      Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Получить исходные параметры окна
    logger.info("Исходные параметры окна");
    // Координаты окна
    Point positionBefore = driver.manage().window().getPosition();
    logger.info("Координаты окна: [" + positionBefore.getX() + ", " + positionBefore.getY() + "]");
    // Размеры окна
    Dimension sizeBefore = driver.manage().window().getSize();
    logger.info("Размеры окна: [" + sizeBefore.getWidth() + ", " + sizeBefore.getHeight() + "]");

    // Установить параметры окна
    // Координаты окна
    Point newPosition = new Point(200, 200);
    driver.manage().window().setPosition(newPosition);
    // Размеры окна
    Dimension newSize = new Dimension(1520, 680);
    driver.manage().window().setSize(newSize);

    try {
      Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Получить новые параметры окна
    logger.info("Новые параметры окна");
    // Координаты окна
    Point positionAfter = driver.manage().window().getPosition();
    logger.info("Координаты окна: [" + positionAfter.getX() + ", " + positionAfter.getY() + "]");
    // Размеры окна
    Dimension sizeAfter = driver.manage().window().getSize();
    logger.info("Размеры окна: [" + sizeAfter.getWidth() + ", " + sizeAfter.getHeight() + "]");
  }

  @Test
  public void maxMinWindowTest() {
    // Открыть страницу https://devqa.io/
    driver.get("https://devqa.io/");
    logger.info("Открыта страница devqa.io - https://devqa.io/");

    try {
      Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Получить исходные параметры окна
    logger.info("Исходные параметры окна");
    // Координаты окна
    Point positionBefore = driver.manage().window().getPosition();
    logger.info("Координаты окна: [" + positionBefore.getX() + ", " + positionBefore.getY() + "]");
    // Размеры окна
    Dimension sizeBefore = driver.manage().window().getSize();
    logger.info("Размеры окна: [" + sizeBefore.getWidth() + ", " + sizeBefore.getHeight() + "]");

    // Максимизация окна
    driver.manage().window().maximize();
    logger.info("Максимизация окна");

    try {
      Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Получить новые параметры окна
    logger.info("Параметры окна после максимизации");
    // Координаты окна
    Point positionAfterMaximize = driver.manage().window().getPosition();
    logger.info("Координаты окна: [" + positionAfterMaximize.getX() + ", " + positionAfterMaximize.getY() + "]");
    // Размеры окна
    Dimension sizeAfterMaximize = driver.manage().window().getSize();
    logger.info("Размеры окна: [" + sizeAfterMaximize.getWidth() + ", " + sizeAfterMaximize.getHeight() + "]");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Минимизация окна
    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    //driver.navigate().refresh();
    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    driver.manage().window().minimize();
    logger.info("Минимизация окна");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //driver.manage().window().setPosition(new Point(22,47));
   // driver.manage().window().setSize(new Dimension(1700,800));

    // Получить новые параметры окна
    logger.info("Параметры окна после минимизации");
    // Координаты окна
    Point positionAfterMinimize = driver.manage().window().getPosition();
    logger.info("Координаты окна: [" + positionAfterMinimize.getX() + ", " + positionAfterMinimize.getY() + "]");
    // Размеры окна
    Dimension sizeAfterMinimize = driver.manage().window().getSize();
    logger.info("Размеры окна: [" + sizeAfterMinimize.getWidth() + ", " + sizeAfterMinimize.getHeight() + "]");

    try {
      Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(10));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @AfterEach
  public void setDown() {
    if(driver != null) {
      driver.quit();
      logger.info("Драйвер остановлен!");
    }
  }
}