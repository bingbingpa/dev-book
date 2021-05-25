package com.bingbingpa.ch10;

import com.bingbingpa.ch10.model.Order;
import com.bingbingpa.ch10.model.Tax;

import java.util.function.DoubleUnaryOperator;

import static com.bingbingpa.ch10.MixedBuilder.*;

public class TaxCalculator {

    public static double calculate(Order order, boolean useRegional, boolean useGeneral, boolean useSurcharge) {
        double value = order.getValue();
        if (useRegional) {
            value = Tax.regional(value);
        }
        if (useGeneral) {
            value = Tax.general(value);
        }
        if (useSurcharge) {
            value = Tax.surcharge(value);
        }
        return value;
    }

    private boolean useRegional;
    private boolean useGeneral;
    private boolean useSurcharge;

    public TaxCalculator withTaxRegional() {
        useRegional = true;
        return this;
    }

    public TaxCalculator withTaxGeneral() {
        useGeneral= true;
        return this;
    }

    public TaxCalculator withTaxSurcharge() {
        useSurcharge = true;
        return this;
    }

    public double calculate(Order order) {
        return calculate(order, useRegional, useGeneral, useSurcharge);
    }

    public DoubleUnaryOperator taxFunction = d -> d;

    public TaxCalculator with(DoubleUnaryOperator f) {
        taxFunction = taxFunction.andThen(f);
        return this;
    }

    public double calculateF(Order order) {
        return taxFunction.applyAsDouble(order.getValue());
    }

    public static void main(String[] args) {
        Order order =
                forCustomer("BigBank",
                        buy(t -> t.quantity(80)
                                .stock("IBM")
                                .on("NYSE")
                                .at(125.00)),
                        sell(t -> t.quantity(50)
                                .stock("GOOGLE")
                                .on("NASDAQ")
                                .at(125.00)));

        double value = TaxCalculator.calculate(order, true, false, true);
        System.out.printf("Boolean arguments: %.2f%n", value);

        value = new TaxCalculator().withTaxRegional()
                .withTaxSurcharge()
                .calculate(order);
        System.out.printf("Method chaining: %.2f%n", value);

        value = new TaxCalculator().with(Tax::regional)
                .with(Tax::surcharge)
                .calculateF(order);
        System.out.printf("Method references: %.2f%n", value);
    }

}
