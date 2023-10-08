package processing;

import entities.AccountRecord;
import entities.BalanceSheet;
import enums.AssetType;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FinancialDataProcessor {

    private Set<AccountRecord> accountRecords;
    private LocalDate startDate;
    private LocalDate endDate;

    public FinancialDataProcessor(Set<AccountRecord> accountRecords, LocalDate startDate, LocalDate endDate) {
        this.accountRecords = accountRecords;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private Set<AccountRecord> getFilteredAccountRecords() {
        return accountRecords.stream()
                .filter(record ->
                        !record.getData().toLocalDate().isBefore(this.startDate) &&
                                !record.getData().toLocalDate().isAfter(this.endDate))
                .collect(Collectors.toSet());
    }

    private Map<AssetType, Set<AccountRecord>> getConvertedMapAccountRecords() {
        return getFilteredAccountRecords().stream()
                .collect(Collectors.groupingBy(
                        record -> record.getConceptType().getParentType(),
                        Collectors.toSet()
                ));
    }

    public BalanceSheet getBalanceSheet() {
        return new BalanceSheet(getConvertedMapAccountRecords());
    }
}
