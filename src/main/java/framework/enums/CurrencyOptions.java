package framework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CurrencyOptions {
  EURO("€ Euro", "EUR"),
  US_DOLLAR("$ US Dollar", "USD"),
  POUND_STERLING("£ Pound Sterling", "GBP");

  private final String currency;
  private final String href;

}
