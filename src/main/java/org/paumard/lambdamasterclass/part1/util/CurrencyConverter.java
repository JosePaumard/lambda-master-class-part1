package org.paumard.lambdamasterclass.part1.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface CurrencyConverter {

    double convert(double amount);

    interface X {
        double convert(double amount, String toCurrency);

        default CurrencyConverter to(String toCurrency) {
            return amount -> convert(amount, toCurrency);
        }

    }

    interface TriFunction {
        double convert(double amount, String fromCurrency, String toCurrency);

        default X from(String fromCurrency) {
            return (amount, toCurrency) -> convert(amount, fromCurrency, toCurrency);
        }
    }

    static TriFunction of(LocalDate date) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("data/currency.txt"));
             Stream<String> lines = reader.lines();) {

            Pattern pattern = Pattern.compile("=");
            Map<String, Double> conversionMap = lines.skip(1).collect(
                    Collectors.toMap(
                            line -> pattern.split(line)[0],
                            line -> Double.parseDouble(pattern.split(line)[1])
                    )
            );

            return (fromAmount, fromCurrency, toCurrency) ->
                    fromAmount * (conversionMap.get(toCurrency)/conversionMap.get(fromCurrency));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
