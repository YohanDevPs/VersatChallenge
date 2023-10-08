package entities;

import java.math.BigDecimal;
import java.util.Date;

public class StatementIncome {
    private BigDecimal totalIncome;
    private BigDecimal totalExpenses;
    private BigDecimal netProfit;

    public StatementIncome(BigDecimal totalIncome, BigDecimal totalExpenses, BigDecimal netProfit) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.netProfit = netProfit;
    }

    @Override
    public String toString() {
        return String.format("\n\nESTATO DE RESULTADO" +
                        "\nIngressos totales: $ %.2f" +
                        "\nGastos totales: $ %.2f" +
                        "\nBeneficio neto: $ %.2f",
                totalIncome,
                totalExpenses,
                netProfit);
    }
}
