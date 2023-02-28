package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

  @BeforeClass(alwaysRun = true)
  public static void setup() {
    WebDriverManager.chromedriver().setup();
    Configuration.browser = "chrome";
    Configuration.driverManagerEnabled = true;
    Configuration.startMaximized = true;
    Configuration.baseUrl = "https://demo.opencart.com";

  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    Selenide.closeWebDriver();
  }
}
