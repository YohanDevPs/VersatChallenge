package service;

import entities.AccountRecord;
import entities.TotalBalance;
import enums.AssetType;

import java.util.*;

public class TotalBalanceService {

    private List<AccountRecord> accountRecords;

    public TotalBalanceService(List<AccountRecord> accountRecords) {
        this.accountRecords = accountRecords;
    }

    public TotalBalance getTotalBalance() {
        TotalBalance totalBalance = new TotalBalance();

        for (AccountRecord record: accountRecords) {
            switch (record.getConceptType().getParentType()) {
                case ACTIVE_CURRENT ->  totalBalance.getActiveCurrent().add(record);
                case FIXED_ACTIVE -> totalBalance.getFixedActive().add(record);
                case PASSIVE_CURRENT -> totalBalance.getPassiveCurrent().add(record);
                case PASSIVE_LONG_TERM -> totalBalance.getPassiveLongTerm().add(record);
            }
        }

        return totalBalance;
    }



}
