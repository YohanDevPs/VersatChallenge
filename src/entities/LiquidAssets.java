package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LiquidAssets {
    private final BigDecimal currentAssets;
    private final BigDecimal currentLiabilities;

    public LiquidAssets(BigDecimal currentAssets, BigDecimal currentLiabilities) {
        this.currentAssets = currentAssets;
        this.currentLiabilities = currentLiabilities;
    }

    @Override
    public String toString() {
        var currentRatio = getCurrentRatio(currentAssets, currentLiabilities);

        return String.format("%n%n---- ANÁLISE DE LIQUIDEZ ----%n" +
                        "Liquidez Corrente: %.2f o %d%%",
                currentRatio, currentRatio.multiply(BigDecimal.valueOf(100)).intValue());
    }

    public BigDecimal getCurrentRatio(BigDecimal currentAssets, BigDecimal currentLiabilities) {
        if (currentLiabilities.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        } else {
            return currentAssets.divide(currentLiabilities, 2, RoundingMode.HALF_DOWN);
        }
    }

    public BigDecimal getCurrentAssets() {
        return currentAssets;
    }

    public BigDecimal getCurrentLiabilities() {
        return currentLiabilities;
    }
}
