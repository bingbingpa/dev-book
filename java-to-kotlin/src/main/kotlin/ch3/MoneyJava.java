package ch3;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

import static java.math.BigDecimal.ZERO;

public class MoneyJava {
    private final BigDecimal amount;
    private final Currency currency;

    private MoneyJava(BigDecimal amount, Currency currency) { // <1>
        this.amount = amount;
        this.currency = currency;
    }

    public static MoneyJava of(BigDecimal amount, Currency currency) { // <1>
        return new MoneyJava(
                amount.setScale(currency.getDefaultFractionDigits()),
                currency);
    }


    public static MoneyJava of(String amountStr, Currency currency) { // <2>
        return MoneyJava.of(new BigDecimal(amountStr), currency);
    }

    public static MoneyJava of(int amount, Currency currency) {
        return MoneyJava.of(new BigDecimal(amount), currency);
    }

    public static MoneyJava zero(Currency userCurrency) {
        return MoneyJava.of(ZERO, userCurrency);
    }


    public BigDecimal getAmount() { // <2>
        return amount;
    }

    public Currency getCurrency() { // <3>
        return currency;
    }

    @Override
    public boolean equals(Object o) { // <3>
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyJava money = (MoneyJava) o;
        return amount.equals(money.amount) &&
                currency.equals(money.currency);
    }

    @Override
    public int hashCode() { // <3>
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() { // <4>
        return amount.toString() + " " + currency.getCurrencyCode();
    }

    public MoneyJava add(MoneyJava that) { // <5>
        if (!this.currency.equals(that.currency)) {
            throw new IllegalArgumentException(
                    "cannot add Money values of different currencies");
        }

        return new MoneyJava(this.amount.add(that.amount), this.currency);
    }
}
