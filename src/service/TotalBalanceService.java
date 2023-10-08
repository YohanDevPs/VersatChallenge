package service;

import entities.AccountRecord;
import processing.FinancialDataProcessor;

import java.util.List;

public class TotalBalanceService {

    private List<AccountRecord> accountRecords;

    public TotalBalanceService(List<AccountRecord> accountRecords) {
        this.accountRecords = accountRecords;
    }

//    public FinancialDataProcessor getTotalBalance() {
//        FinancialDataProcessor financialDataProcessor = new FinancialDataProcessor();
////
////        for (AccountRecord record: accountRecords) {
////            switch (record.getConceptType().getParentType()) {
////                case ACTIVE_CURRENT ->  financialDataProcessor.getActiveCurrent().add(record);
////                case FIXED_ACTIVE -> financialDataProcessor.getFixedActive().add(record);
////                case PASSIVE_CURRENT -> financialDataProcessor.getPassiveCurrent().add(record);
////                case PASSIVE_LONG_TERM -> financialDataProcessor.getPassiveLongTerm().add(record);
////            }
////        }
//
//        return financialDataProcessor;
//    }
}
