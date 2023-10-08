import entities.AccountRecord;
import mocks.MockAccountingRecord;
import processing.FinancialDataProcessor;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        var records = MockAccountingRecord.accountRecordList();

        for (AccountRecord accountRecord : records) {
            System.out.println(accountRecord);
        }
        System.out.println("---------------------------------------------------------------------------");

        var recordsProcessed  = new FinancialDataProcessor(records, LocalDate.of(2020, 10, 8), LocalDate.of(2023, 10, 8));
        System.out.println(recordsProcessed.getBalanceSheet());
        System.out.println(recordsProcessed.getStatementIncome());
        System.out.println(recordsProcessed.getLiquidAssets());
        recordsProcessed.getProfitability().showProfitability();
    }
}