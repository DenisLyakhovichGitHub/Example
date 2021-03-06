import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecordsTest {
  protected static WebDriver driver;
  private Logger logger = LogManager.getLogger(VideoRecordsTest.class);

  private ScreenRecorder screenRecorder;              // Рекордер видео
  private GraphicsConfiguration gc;                   // Конфигурация графики
  private final String RECORD_DIRECTORY = "temp/";   // Путь до каталога с выходным файлом

  @BeforeEach
  public void setUp() {
    driver = WebDriverFactory.getDriver("chrome");
    logger.info("Драйвер стартовал!");
    // Конфигурация графики
    GraphicsConfiguration gc = GraphicsEnvironment
        .getLocalGraphicsEnvironment()
        .getDefaultScreenDevice()
        .getDefaultConfiguration();

    try {
      File dir = new File(RECORD_DIRECTORY);
      screenRecorder = new ScreenRecorder(
          // Конфигурация графики
          gc,
          // Формат выходного файла
          new Format(
              MediaTypeKey, MediaType.FILE,
              MimeTypeKey, MIME_AVI),
          // Формат видео кадра
          new Format(
              MediaTypeKey, MediaType.VIDEO,
              EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
              CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
              DepthKey, 24,
              FrameRateKey, Rational.valueOf(15),
              QualityKey, 1.0f,
              KeyFrameIntervalKey, 15 * 60),
          // Формат курсора мыши
          new Format(
              MediaTypeKey, MediaType.VIDEO,
              EncodingKey, "black",
              FrameRateKey, Rational.valueOf(30)),
          // Формат аудио
          null);
      screenRecorder.start(); // Старт записи видео
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void monteVideoRecorderTest() {
    // Открыть страницу https://www.dns-shop.ru/
    driver.manage().window().maximize();
    driver.get("https://www.dns-shop.ru/");
    logger.info("Открыта страница dns-shop.ru - https://www.dns-shop.ru/");
    // Нажать на ссылку "Да"
    By linkYesXPath = By.xpath("//a[text()=\"Да\"]");
    WebElement linkYes = driver.findElement(linkYesXPath);
    linkYes.click();
    logger.info("Нажата ссылка \"Да\"");
    // Нажать на ссылку "Бытовая техника"
    By linkBTXPath = By.xpath("//div/a[text()=\"Бытовая техника\"]");
    WebElement linkBT = driver.findElement(linkBTXPath);
    linkBT.click();
    logger.info("Нажата ссылка \"Бытовая техника\"");
  }

  @AfterEach
  public void setDown() {
    try {
      screenRecorder.stop(); // Стоп записи видео
      // Сохранение файла под заданным именем
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
      File newFileName = new File(String.format("%s %s.avi", RECORD_DIRECTORY, dateFormat.format(new Date())));
      screenRecorder.getCreatedMovieFiles().get(0).renameTo(newFileName);
    } catch (Exception e) {
      System.out.println(e);
    }

    if (driver != null) {
      driver.quit();
      logger.info("Драйвер остановлен!");
    }
  }
}
