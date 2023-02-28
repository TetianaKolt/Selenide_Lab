package ui;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static framework.pages.StringFaker.generateFakeEmail;
import static framework.pages.StringFaker.generateFakeFirstName;
import static framework.pages.StringFaker.generateFakeLastName;
import static framework.pages.StringFaker.generateFakePassword;

import com.codeborne.selenide.Condition;
import framework.pages.MainPage;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {


  private final MainPage mainPage = new MainPage();

  @Test
  public void registerTest() {

    open("/");
    mainPage.clickMyAccount()
        .clickRegister()
        .enterFirstName(generateFakeFirstName())
        .enterLastName(generateFakeLastName())
        .enterEmail(generateFakeEmail())
        .enterPassword(generateFakePassword())
        .agreeWithPrivacyPolicy()
        .clickContinue();

    $(title()).shouldBe(Condition.name("Welcome"));

  }
}
