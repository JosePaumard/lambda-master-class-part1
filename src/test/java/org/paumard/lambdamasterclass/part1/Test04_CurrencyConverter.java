package org.paumard.lambdamasterclass.part1;

import org.assertj.core.data.Offset;
import org.junit.Test;
import org.paumard.lambdamasterclass.part1.util.CurrencyConverter;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class Test04_CurrencyConverter {

    /**
     * Implement the Currency converter using lambdas so that
     * the following code compiles and executes correctly
     * given the CurrencyConverter interface.
     */
    @Test
    public void currencyConverter_1() {

        LocalDate date = LocalDate.of(2018, 11, 5);
        CurrencyConverter converter =
                CurrencyConverter.of(date).from("EUR").to("GBP");

        double euros = 1d;
        double convertedEuros = converter.convert(euros);
        double gbps = 0.87749d;
        assertThat(convertedEuros).isEqualTo(gbps, Offset.offset(1e-4d));
    }

    @Test
    public void currencyConverter_2() {

        LocalDate date = LocalDate.of(2018, 11, 5);
        CurrencyConverter converter =
                CurrencyConverter.of(date).from("NOK").to("EUR");

        double norwegianKrown = 1d;
        double convertedKrown = converter.convert(norwegianKrown);
        double euros = 0.10507d;
        assertThat(convertedKrown).isEqualTo(euros, Offset.offset(1e-4d));
    }

    @Test
    public void currencyConverter_3() {

        LocalDate date = LocalDate.of(2018, 11, 5);
        CurrencyConverter converter =
                CurrencyConverter.of(date).from("CHF").to("CAD");

        double swissFrancs = 10d;
        double convertedSwissFrancs = converter.convert(swissFrancs);
        double canadianDollars = 13.0665d;
        assertThat(convertedSwissFrancs).isEqualTo(canadianDollars, Offset.offset(1e-4d));
    }
}
