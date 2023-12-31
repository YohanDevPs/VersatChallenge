package processing.analisys;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LiquidAssets {
    private final BigDecimal currentAssets;
    private final BigDecimal currentLiabilities;

    public LiquidAssets(BigDecimal currentAssets, BigDecimal currentLiabilities) {
        this.currentAssets = currentAssets;
        this.currentLiabilities = currentLiabilities;
    }

    public void printLiquidAssets() {
        var currentRatio = getCurrentRatio(currentAssets, currentLiabilities);

        System.out.println(String.format("%n%n---- ANÁLISE DE LIQUIDEZ ----%n" +
                        "Liquidez Corrente: %.2f o %d%%",
                currentRatio, currentRatio.multiply(BigDecimal.valueOf(100)).intValue()));
    }

    public BigDecimal getCurrentRatio(BigDecimal currentAssets, BigDecimal currentLiabilities) {
        if (currentLiabilities.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        } else {
            return currentAssets.divide(currentLiabilities, 2, RoundingMode.HALF_DOWN);
        }
    }
}
