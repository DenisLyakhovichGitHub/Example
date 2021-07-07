import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

  private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

  public static WebDriver getDriver(String browserName) {
    switch (browserName) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        logger.info("Драйвер для браузера Chrome");
        return new ChromeDriver();
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        logger.info("Драйвер для браузера Firefox");
        return new FirefoxDriver();
      case "safari":
        logger.info("Драйвер для браузера Safari");
        return new SafariDriver();
      case "edge":
        WebDriverManager.edgedriver().setup();
        logger.info("Драйвер для браузера Edge");
        return new EdgeDriver();
      case "opera":
        WebDriverManager.operadriver().setup();
        logger.info("Драйвер для браузера Opera");
        return new OperaDriver();
      default:
        throw new RuntimeException("Incorrect browser name");
    }
  }
}
