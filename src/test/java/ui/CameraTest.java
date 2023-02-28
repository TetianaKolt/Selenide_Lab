package ui;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import framework.pages.MainPage;
import org.testng.annotations.Test;

public class CameraTest extends BaseTest {

  private MainPage mainPage = new MainPage();

  @Test
  public void checkCameras() {

    open("/");

    mainPage.getCamerasButton().hover();
    ElementsCollection camerasList = mainPage.clickOnShowAllCameras().getAllCameras();
    int expectedQuantity = 2;

    //Check that 2 cameras exist on page
    camerasList.shouldHave(CollectionCondition.size(expectedQuantity));

    String cameraNameToCheck = "Canon EOS 5D";
    //Check that Canon EOS 5D has old price 122.00
    camerasList.filterBy(Condition.ownText(cameraNameToCheck)).get(0)
        .shouldHave(Condition.attribute("class","price-old").text("122.00"));

    //Check that Canon EOS 5D has new price 98.00
    camerasList.filterBy(Condition.ownText(cameraNameToCheck)).get(0)
        .shouldHave(Condition.attribute("class","price-new").text("98.00"));

    //Check that Nikon D300 has ex.rate 80.00
    cameraNameToCheck = "Nikon D300";
    camerasList.filterBy(Condition.exactOwnText(cameraNameToCheck)).get(0)
        .shouldHave(Condition.attribute("class","price-tax").text("80.00"));
  }
}
