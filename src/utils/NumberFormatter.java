package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatter {

    public static NumberFormat getNumberFormatter() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
            numberFormat.setMinimumFractionDigits(2);
            numberFormat.setMaximumFractionDigits(2);

        return numberFormat;
    }
}
