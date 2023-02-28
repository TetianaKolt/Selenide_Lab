package framework.pages;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

public class BrandsPage {

  private final By brandsListLocator = By.xpath(
      "//div[@id='product-manufacturer']//div[@class='col-sm-3']//a");

  public ElementsCollection getAllBrands() {
    return ($$(brandsListLocator));
  }

}

