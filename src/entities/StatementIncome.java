package entities;

import java.math.BigDecimal;

public class StatementIncome {
    private final BigDecimal totalIncome;
    private final BigDecimal totalExpenses;

    public StatementIncome(BigDecimal totalIncome, BigDecimal totalExpenses) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public BigDecimal getNetProfit() {
        return this.totalIncome.subtract(this.totalExpenses);
    }

    @Override
    public String toString() {
        return String.format("\n\n----- ESTATO DE RESULTADO -----" +
                        "\nIngressos totales: $ %.2f" +
                        "\nGastos totales: $ %.2f" +
                        "\nBeneficio neto: $ %.2f",
                getTotalIncome(),
                getTotalExpenses(),
                getNetProfit());
    }
}
