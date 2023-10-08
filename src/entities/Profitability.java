package entities;

import java.math.BigDecimal;

public class Profitability {

    //  ganancia neta
    private BigDecimal netIncome;

    // ingressos totales
    private BigDecimal totalIncome;

    public Profitability(BigDecimal netIncome, BigDecimal totalIncome) {
        this.netIncome = netIncome;
        this.totalIncome = totalIncome;
    }

    public BigDecimal calculateNetProfitMargin() {
        if (totalIncome.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        } else {
            return netIncome.divide(totalIncome, 2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100));
        }
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(BigDecimal netIncome) {
        this.netIncome = netIncome;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void showProfitability() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n\n---- ANÁLISIS DE RENTABILIDAD ----\n");
        stringBuilder.append("Margem de benefício neto: ").append(calculateNetProfitMargin()).append("%");

        System.out.println(stringBuilder);
    }
}
