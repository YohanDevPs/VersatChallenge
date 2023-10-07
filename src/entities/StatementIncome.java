package entities;

import java.math.BigDecimal;
import java.util.Date;

public class StatementIncome {
    private Date startDate = new Date();
    private Date endDate = new Date();
    private BigDecimal totalIncome;
    private BigDecimal totalExpenses;
    private BigDecimal netProfit;

    public StatementIncome(Date startDate,
                           Date endDate,
                           BigDecimal totalIncome,
                           BigDecimal totalExpenses,
                           BigDecimal netProfit) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.netProfit = netProfit;
    }

    public StatementIncome() {

    }

    @Override
    public String toString() {
        return String.format("\n\nESTATO DE RESULTADO" +
                        "\nComprende el periodo %s al %s" +
                        "\nIngressos totales: $ %.2f" +
                        "\nGastos totales: $ %.2f" +
                        "\nBeneficio neto: $ %.2f",
                startDate.toString(),
                endDate.toString(),
                totalIncome,
                totalExpenses,
                netProfit);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }
}
