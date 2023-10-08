package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LiquidAssets {
    private BigDecimal currentAssets;
    private BigDecimal currentLiabilities;

    public LiquidAssets(BigDecimal currentAssets, BigDecimal currentLiabilities) {
        this.currentAssets = currentAssets;
        this.currentLiabilities = currentLiabilities;
    }

    public LiquidAssets() {
    }

    @Override
    public String toString() {
        return String.format("\n\nANÁLISE DE LIQUIDEZ%n" +
                "Liquidez Corrente: $%.2f",
                getCurrentRatio(currentAssets, currentLiabilities));
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

    public void setCurrentAssets(BigDecimal currentAssets) {
        this.currentAssets = currentAssets;
    }

    public BigDecimal getCurrentLiabilities() {
        return currentLiabilities;
    }

    public void setCurrentLiabilities(BigDecimal currentLiabilities) {
        this.currentLiabilities = currentLiabilities;
    }
}
