package entities;

import utils.NumberFormater;

import java.math.BigDecimal;

import static utils.NumberFormater.getNumberFormater;

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

    public void showStatementIncome() {
        System.out.printf("\n----- ESTATO DE RESULTADO -----" +
                        "\nIngressos totales: $ %s" +
                        "\nGastos totales: $ %s" +
                        "\nBeneficio neto: $ %s%n",
                getNumberFormater().format(getTotalIncome()),
                getNumberFormater().format(getTotalExpenses()),
                getNumberFormater().format(getNetProfit()));
    }
}
