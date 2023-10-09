import processing.FinancialDataProcessor;

import java.time.LocalDate;

import static mocks.MockAccountingRecord.generateAccountRecords;

public class Main {
    public static void main(String[] args) {

        var records = generateAccountRecords(100000L);

        var financialProcessor  = new FinancialDataProcessor(records, LocalDate.of(2022, 10, 8), LocalDate.of(2023, 10, 8));

        financialProcessor.getBalanceSheet().printBalanceSheet();
        financialProcessor.getStatementIncome().printStatementIncome();
        financialProcessor.getLiquidAssets().printLiquidAssets();
        financialProcessor.getProfitability().printProfitability();
    }
}