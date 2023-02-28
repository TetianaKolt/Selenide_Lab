package framework.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import framework.enums.SortByOptions;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class DesktopPage {

  private final By showingOnTheBottomTextLocator = By.xpath("//div[contains(text(),'Showing')]");
  private final By productNameLocator = By.xpath("//h4/a");
  private final By showQuantityContainerLocator = By.id("input-limit");
  private final By sortByContainerLocator = By.id("input-sort");


  // SORT BY DROPDOWN
  //// Check the value in the "Sort By" dropdown by default
  public SelenideElement getFirstValueFromSortBy() {
    SelenideElement select = $(sortByContainerLocator);
    return select.getSelectedOption();
  }
  //// Change the value in the "Sort By" dropdown
  public void selectValueInSortBy(SortByOptions sortByOptions) {
    SelenideElement select = $(sortByContainerLocator);
    select.selectOptionContainingText(sortByOptions.getValueName());
  }

  // SHOW DROPDOWN
  //// Check the value in the "Show" dropdown by default
  public SelenideElement getFirstValueFromShowQuantity() {
    SelenideElement select = $(showQuantityContainerLocator);
    return select.getSelectedOption();
  }

  //// Change the value in the "Show" dropdown
  public void selectValueInShowQuantity(String quantityToShow) {
    SelenideElement select = $(showQuantityContainerLocator);
    select.selectOptionContainingText(quantityToShow);
  }

  public SelenideElement getTextShownOnTheBottom() {
    SelenideElement text = $(showingOnTheBottomTextLocator);
    text.scrollTo();
    return text;
  }


}