package ui;

import static com.codeborne.selenide.Selenide.open;
import static framework.enums.SortByOptions.MODEL_A_Z;
import static framework.enums.SortByOptions.PRICE_LOW_HIGH;
import static framework.helpers.Helpers.getAllProducts;
import static framework.helpers.Helpers.sortCollection;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import framework.pages.DesktopPage;
import framework.pages.MainPage;
import java.util.List;
import org.testng.annotations.Test;

public class DesktopTest extends BaseTest {

  private MainPage mainPage = new MainPage();

  @Test
  public void desktopTest() {
    open("/");

    mainPage.getDesktopsButton().hover();
    DesktopPage desktopPage = mainPage.clickOnShowAllDesktops();

    SelenideElement actualFirstValueInShow = desktopPage.getFirstValueFromShowQuantity();
    String expectedFirstValueInShow = "10";
    //Check that value in Show dropdown is 10
    actualFirstValueInShow.shouldBe(Condition.text(expectedFirstValueInShow));

    SelenideElement actualFirstValueInSortBy = desktopPage.getFirstValueFromSortBy();
    String expectedFirstValueInSortBy = "Default";
    //Check that value in Sort By is Default
    actualFirstValueInSortBy.shouldBe(Condition.text(expectedFirstValueInSortBy));

    ElementsCollection actualProductQuantity = getAllProducts(
        desktopPage.getProductNameLocator());
    int expectedProductQuantity = 10;
    //Check that 10 products display on page
    actualProductQuantity.shouldHave(CollectionCondition.size(expectedProductQuantity));

    //Select 25 from Show dropdown
    String selectQuantity = "25";
    desktopPage.selectValueInShowQuantity(selectQuantity);
    ElementsCollection actualQuantityShown = getAllProducts(
        desktopPage.getProductNameLocator());
    expectedProductQuantity = 12;
    // Check that 12 products now displayed
    actualQuantityShown.shouldHave(CollectionCondition.size(expectedProductQuantity));

    SelenideElement textOnTheBottom = desktopPage.getTextShownOnTheBottom();
    String expectedTextOnTheBottom = "Showing 1 to 12 of 12 (1 Pages)";
    //Check that text 'Showing 1 to 12 of 12 (1 Pages)' displays on the bottom of the page
    textOnTheBottom.shouldBe(Condition.exactText(expectedTextOnTheBottom));

    //Test #3
    //Select 'Name (A - Z)' from Sort by dropdown
    desktopPage.selectValueInSortBy(MODEL_A_Z);
    ElementsCollection actualSortedList = getAllProducts(
        desktopPage.getProductNameLocator());
    List<String> expectedNamesList = sortCollection(actualSortedList);

    //Check that products were sorted correctly (from A to Z)
    actualSortedList.shouldBe(CollectionCondition.texts(expectedNamesList));

    //Select 'Price (Low > High)' from Sort by dropdown
    desktopPage.selectValueInSortBy(PRICE_LOW_HIGH);
    actualSortedList = getAllProducts(
        desktopPage.getProductNameLocator());
    expectedNamesList = sortCollection(actualSortedList);

    //Check that products were sorted correctly
    actualSortedList.shouldBe(CollectionCondition.texts(expectedNamesList));

  }


}
