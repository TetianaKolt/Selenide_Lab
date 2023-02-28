package framework.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class ProductPage {

  private final By price = By.xpath("//h2/span[@class='price-new']");
  private final By menu = By.xpath("//span[@class='d-none d-md-inline' and contains(text(),'Currency')]");

  public SelenideElement getPriceForProduct(){
     return $(price);
  }

  public ProductPage openCurrencyMenu() {
    $(menu).click();
    return this;
  }

}
