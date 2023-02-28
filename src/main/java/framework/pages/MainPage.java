package framework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static framework.helpers.Helpers.chooseCurrency;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import framework.enums.CurrencyOptions;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class MainPage {

  private final SelenideElement myAccount = $x(
      ".//i[@class='fas fa-user']/parent::a[@class='dropdown-toggle']");
  private final SelenideElement register = $x(
      "//ul[@class='dropdown-menu dropdown-menu-right show']/li[1]/a");

  private final SelenideElement brandsLocator =
      $(By.xpath("//li/a[contains(text(),'Brands')]"));

  private final SelenideElement desktopsButton = $(By.xpath(
      "//li/a[contains(text(),'Desktops')]/parent::li"));
  private final SelenideElement camerasButton = $(By.xpath(
      "//li[@class='nav-item']//a[@class='nav-link' and contains(text(),'Cameras')]"));

  private final SelenideElement dropDownListSeeAllDesktopsLocator = $(By.xpath(
      "//ul[@class='nav navbar-nav']/li[1]//a[@class='see-all']"));

  private static final By currencySymbol = By.xpath("//*[@id='form-currency']/div/a/strong");

  private final By products = By.xpath("//h4/a");

  public MainPage clickMyAccount() {
    myAccount.click();
    return this;
  }

  public RegisterPage clickRegister() {
    register.click();
    return new RegisterPage();
  }

  public MainPage goToTheFooter() {
    brandsLocator.scrollTo();
    return this;
  }

  public BrandsPage clickBrands() {
    brandsLocator.click();
    return new BrandsPage();
  }

  public DesktopPage clickOnShowAllDesktops() {
    dropDownListSeeAllDesktopsLocator.click();
    return new DesktopPage();
  }
  public CamerasPage clickOnShowAllCameras() {
    camerasButton.click();
    return new CamerasPage();
  }



  // Check the currency by Default
  public String checkCurrencySymbolChangeIfNot(CurrencyOptions defaultSymbol) {
    SelenideElement actualSymbol = $(currencySymbol);
    if (!actualSymbol.text().equals(defaultSymbol.name())) {
      actualSymbol.click();
      chooseCurrency(defaultSymbol);
    }
    return actualSymbol.getText();
  }


  public void findProductByName(String nameToSearch) {
    ElementsCollection productList = $$(products);
    productList.filter(Condition.text(nameToSearch)).get(0).click();
  }

}