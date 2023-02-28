package framework.helpers;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import framework.enums.CurrencyOptions;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;

public class Helpers {

  private static final By currencyList = By.xpath("//ul[@class='dropdown-menu show']/li/a[@class='dropdown-item']");
//  private static final By currencyMenu = By.xpath("//form[@id='form-currency']");

  // Get list of products
  public static ElementsCollection getAllProducts(By locator) {
    return $$(locator);
  }

  // Sort Collection
  public static List<String> sortCollection(ElementsCollection collection){
    List<String> listOfNames = collection.texts();
    Collections.sort(listOfNames);
    return listOfNames;
  }

  //Choose currency
  public static void chooseCurrency(CurrencyOptions currencyEnum) {
    ElementsCollection currencyListElements = $$(currencyList);
    currencyListElements.filterBy(Condition.href(currencyEnum.getHref())).get(0).click();
  }

  // Get digits from String
  public static double productPriceAsDouble(String price) {
    StringBuilder number = new StringBuilder();
    for (int i = 0; i < price.length(); i++) {
      if (Character.isDigit(price.charAt(i)) || price.charAt(i) == '.') {
        number.append(price.charAt(i));
      }
    }
    return Double.parseDouble(String.valueOf(number));
  }

}
