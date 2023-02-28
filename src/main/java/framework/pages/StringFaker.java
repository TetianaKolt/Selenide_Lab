package framework.pages;

import com.github.javafaker.Faker;

public class StringFaker {
  private static final Faker faker = new Faker();
  public static String generateFakeFirstName() {
    return faker.name().firstName();
  }

  public static String generateFakeLastName() {
    return faker.name().lastName();
  }

  public static String generateFakeEmail() {
    return faker.internet().emailAddress();
  }

  public static String generateFakePassword() {
    return faker.internet().password();
  }

}
