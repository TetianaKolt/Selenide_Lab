package ui;

import static com.codeborne.selenide.Selenide.open;
import static framework.enums.CurrencyOptions.EURO;
import static framework.enums.CurrencyOptions.POUND_STERLING;
import static framework.enums.CurrencyOptions.US_DOLLAR;
import static framework.helpers.Helpers.chooseCurrency;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import framework.pages.MainPage;
import framework.pages.ProductPage;
import org.testng.annotations.Test;

public class CurrencyTest extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test //Test #4
  public void changeCurrencyTest() {
    ProductPage productPage = new ProductPage();
    open("/");

    String expectedCurrencySymbolByDefault = "$";

    // On the main page check that current currency is $ (change to $ if not)
    mainPage.checkCurrencySymbolChangeIfNot(US_DOLLAR);

    //Click on the Iphone and Check that price 123.20
    mainPage.findProductByName("iPhone");

    SelenideElement actualPrice = productPage.getPriceForProduct();
    String expectedPriceUSDoll = "123.20";

    actualPrice.shouldHave(Condition.exactText("$"+expectedPriceUSDoll));

    //Change currency to euro
    productPage.openCurrencyMenu();
    chooseCurrency(EURO);
    SelenideElement actualPriceEUR = productPage.getPriceForProduct();
    String expectedPriceEUR = "106.04";
    //Check that price 106.04
    actualPriceEUR.shouldHave(Condition.exactText(expectedPriceEUR+"€"));

    //Change currency to Pound Sterling
    productPage.openCurrencyMenu();
    chooseCurrency(POUND_STERLING);
    SelenideElement actualPricePound = productPage.getPriceForProduct();
    String expectedPricePounds = "95.32";
    //Check that price 95.32
    actualPricePound.shouldHave(Condition.exactText("£"+expectedPricePounds));
  }
}