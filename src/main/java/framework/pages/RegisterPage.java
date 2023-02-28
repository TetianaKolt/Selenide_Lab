package framework.pages;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


public class RegisterPage {

  private final SelenideElement firstNameField = $(By.id("input-firstname"));
  private final SelenideElement lastNameField = $(By.id("input-lastname"));
  private final SelenideElement emailField = $(By.id("input-email"));
  private final SelenideElement passwordInput = $(By.id("input-password"));
  private final SelenideElement agreeWithPrivacyPolicy = $(By.xpath("//input[@type='checkbox']"));
  private final SelenideElement continueButton = $(By.xpath("//button[@type='submit']"));

  public RegisterPage enterFirstName(String value){
    firstNameField.setValue(value);
    return this;
  }
  public RegisterPage enterLastName(String value){
    lastNameField.setValue(value);
    return this;
  }
  public RegisterPage enterEmail(String value){
    emailField.setValue(value);
    return this;
  }
  public RegisterPage enterPassword(String value){
    passwordInput.setValue(value);
    return this;
  }
  public RegisterPage agreeWithPrivacyPolicy(){
    agreeWithPrivacyPolicy.scrollTo().click();
    return this;
  }
  public void clickContinue(){
    continueButton.click();
  }



}
