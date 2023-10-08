package entities;

import java.math.BigDecimal;

public class Profitability {

    //  ganancia neta
    private BigDecimal netIncome;

    // ingressos totales
    private BigDecimal totalIncome;


    public Profitability() {
        this.netIncome = netIncome;
        this.totalIncome = totalIncome;
    }

    public BigDecimal getNetProfitMargin() {
        if (netIncome.compareTo(BigDecimal.ZERO) != 0) {
            return netIncome.divide(totalIncome, 2, BigDecimal.ROUND_HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
        } else {
            System.out.println("Los ingresos totales son cero. No se puede calcular el margen de beneficio neto.");
            return BigDecimal.ZERO;
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

    @Override
    public String toString() {
        return String.format("\n\nBENEFICIO NETO%n" +
                "Margen de beneficio neto es: %.2f",
                getNetProfitMargin());
    }
}
