package framework.pages;

import static framework.helpers.Helpers.getAllProducts;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

public class CamerasPage {

  private final By camerasListLocator = By.xpath("//div[@id='product-list']/div");

  public ElementsCollection getAllCameras(){
    return getAllProducts(camerasListLocator);
  }

}
