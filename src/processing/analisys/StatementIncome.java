package processing.analisys;

import java.math.BigDecimal;

import static utils.NumberFormatter.getNumberFormatter;

public class StatementIncome {
    private final BigDecimal totalIncome;
    private final BigDecimal totalExpenses;

    public StatementIncome(BigDecimal totalIncome, BigDecimal totalExpenses) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
    }

    public BigDecimal getNetProfit() {
        return this.totalIncome.subtract(this.totalExpenses);
    }

    public void printStatementIncome() {
        System.out.printf("\n----- ESTATO DE RESULTADO -----" +
                        "\nIngressos totales: $ %s" +
                        "\nGastos totales: $ %s" +
                        "\nBeneficio neto: $ %s%n",
                getNumberFormatter().format(this.totalIncome),
                getNumberFormatter().format(this.totalExpenses),
                getNumberFormatter().format(getNetProfit()));
    }
}
