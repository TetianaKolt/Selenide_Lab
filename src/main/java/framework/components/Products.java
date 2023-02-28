package framework.components;

import static com.codeborne.selenide.Selenide.$;
import static framework.helpers.Helpers.productPriceAsDouble;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

  @Getter
  public class Products {

    private SelenideElement productImage;
    private SelenideElement productNameWE;
    private String productName;
    private String description;
    private String productPriceCurrent;
    private Double productPriceCurrentAsDouble;
    private String productPriceOld;
    private double productPriceOldAsDouble;
    private String productTax;
    private Double productTaxAsDouble;
    private SelenideElement addToCartButton;
    private SelenideElement addToWishListButton;
    private SelenideElement compareThisProductButton;

    public Products(WebElement container) {
      this.productImage = $(
          By.xpath(".//div[@class='image']//img[@class='img-fluid']"));
      this.productNameWE = $(By.xpath(".//div[@class='description']//a"));
      this.productName = productNameWE.getText();
      this.description = $(By.xpath(".//div[@class='description']//p")).getText();
      this.productPriceCurrent = $(".//div[@class='price']//span[@class='price-new']").getText();
      this.productPriceCurrentAsDouble = productPriceAsDouble(productPriceCurrent);

      try {
        this.productPriceOld = $(
            By.xpath(".//div[@class='price']//span[@class='price-old']")).getText();
      } catch (NoSuchElementException e) {
        this.productPriceOld = null;
      }

      try {
        this.productPriceOldAsDouble = productPriceAsDouble(productPriceOld);
      } catch (Exception e) {
        this.productPriceOldAsDouble = 0;
      }

      this.productTax = $(
          By.xpath(".//div[@class='price']//span[@class='price-tax']")).getText();
      try {
        this.productTaxAsDouble = productPriceAsDouble(productTax);
      } catch (Exception e) {
        this.productTaxAsDouble = (double) 0;
      }

      this.addToCartButton = $(
          By.xpath(".//div[@class='button-group']//button[@data-bs-original-title='Add to Cart']"));
      this.addToWishListButton = $(By.xpath(
          ".//div[@class='button-group']//button[@data-bs-original-title='Add to Wish List']"));
      this.compareThisProductButton = $(By.xpath(
          ".//div[@class='button-group']//button[@data-bs-original-title='Compare this Product']"));
    }

  }
