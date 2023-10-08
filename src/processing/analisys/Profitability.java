package processing.analisys;

import java.math.BigDecimal;

public class Profitability {

    private final BigDecimal netIncome;
    private final BigDecimal totalIncome;

    public Profitability(BigDecimal netIncome, BigDecimal totalIncome) {
        this.netIncome = netIncome;
        this.totalIncome = totalIncome;
    }

    public BigDecimal calculateNetProfitMargin() {
        if (this.totalIncome.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        } else {
            return this.netIncome.divide(this.totalIncome, 2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100));
        }
    }

    public void printProfitability() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n\n---- ANÁLISIS DE RENTABILIDAD ----\n");
        stringBuilder.append("Margem de benefício neto: ").append(calculateNetProfitMargin()).append("%");

        System.out.println(stringBuilder);
    }
}
