package entities;

import java.math.BigDecimal;
import java.util.Date;

public class StatementIncome {
    private BigDecimal totalIncome;
    private BigDecimal totalExpenses;

    public StatementIncome(BigDecimal totalIncome, BigDecimal totalExpenses) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
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
