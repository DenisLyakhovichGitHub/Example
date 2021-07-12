import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.CapabilityType;

public class WebDriverFactory {

  private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

  public static WebDriver getDriver(String browserName) {
    switch (browserName) {

      case "chrome":
        WebDriverManager.chromedriver().setup();
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
        optionsChrome.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
        optionsChrome.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);
        optionsChrome.setAcceptInsecureCerts(false);
        optionsChrome.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        // Добавление аргументов запуска Google Chrome
        optionsChrome.addArguments("--start-maximized");
        optionsChrome.addArguments("--incognito");

        logger.info("Драйвер для браузера Chrome");
        return new ChromeDriver(optionsChrome);

      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions optionsFireFox = new FirefoxOptions();
        optionsFireFox.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
        optionsFireFox.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
        optionsFireFox.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);
        optionsFireFox.setAcceptInsecureCerts(false);
        optionsFireFox.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        // Добавление аргументов запуска FireFox
        optionsFireFox.addArguments("--start-maximized");
        optionsFireFox.addArguments("--incognito");
        logger.info("Драйвер для браузера Firefox");
        return new FirefoxDriver(optionsFireFox);

      case "safari":
        logger.info("Драйвер для браузера Safari");
        return new SafariDriver();

      case "edge":
        WebDriverManager.edgedriver().setup();
        logger.info("Драйвер для браузера Edge");
        return new EdgeDriver();

      case "opera":
        WebDriverManager.operadriver().setup();
        OperaOptions optionsOpera = new OperaOptions();
        optionsOpera.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
        optionsOpera.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
        optionsOpera.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);

        optionsOpera.addArguments("--start-maximized");
        optionsOpera.addArguments("--incognito");

        logger.info("Драйвер для браузера Opera");
        return new OperaDriver(optionsOpera);
      default:
        throw new RuntimeException("Incorrect browser name");
    }
  }
}
