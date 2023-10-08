import entities.AccountRecord;
import mocks.MockAccountingRecord;
import processing.FinancialDataProcessor;
import service.TotalBalanceService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        var records = MockAccountingRecord.accountRecordList();

        for (AccountRecord accountRecord : records) {
            System.out.println(accountRecord);
        }
        System.out.println("---------------------------------------------------------------------------");

        var recordsProcessed  = new FinancialDataProcessor(records, LocalDate.of(2020, 10, 8), LocalDate.of(2023, 10, 8));
        System.out.println(recordsProcessed.getBalanceSheet());
    }
}