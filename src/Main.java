import mocks.MockAccountingRecord;
import processing.FinancialDataProcessor;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        var records = MockAccountingRecord.generateAccountRecords();

        var financialProcessor  = new FinancialDataProcessor(records, LocalDate.of(2022, 10, 8), LocalDate.of(2023, 10, 8));

        financialProcessor.getBalanceSheet().printBalanceSheet();
        financialProcessor.getStatementIncome().printStatementIncome();
        financialProcessor.getLiquidAssets().printLiquidAssets();
        financialProcessor.getProfitability().printProfitability();
    }
}