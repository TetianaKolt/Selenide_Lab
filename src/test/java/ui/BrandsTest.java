package ui;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import framework.pages.MainPage;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;

public class BrandsTest extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test
  public void testLabelsPresent() {
    List<String> expectedBrandsToSee = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC",
        "Palm", "Sony");

    open("/");

    ElementsCollection actualNames = mainPage.goToTheFooter()
        .clickBrands()
        .getAllBrands();

    actualNames.shouldHave(CollectionCondition.texts(expectedBrandsToSee));

  }

}
