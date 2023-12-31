package processing;

import entities.AccountRecord;
import enums.AssetType;
import processing.analisys.BalanceSheet;
import processing.analisys.LiquidAssets;
import processing.analisys.Profitability;
import processing.analisys.StatementIncome;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FinancialDataProcessor {

    private Set<AccountRecord> accountRecords;
    private LocalDate startDate;
    private final LocalDate endDate;

    public FinancialDataProcessor(Set<AccountRecord> accountRecords, LocalDate startDate, LocalDate endDate) {
        this.accountRecords = accountRecords;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Profitability getProfitability() {
        var mapAccountRecords = getConvertedMapAccountRecords();

        BigDecimal totalIncome = calculateTotalActivesAmount(mapAccountRecords);

        return new Profitability(
                totalIncome.subtract(calculateTotalPassivesAmount(mapAccountRecords)),
                totalIncome
        );
    }

    public BalanceSheet getBalanceSheet() {
        return new BalanceSheet(getConvertedMapAccountRecords());
    }

    public LiquidAssets getLiquidAssets() {
        var mapRecords =  getConvertedMapAccountRecords();

        return new LiquidAssets(calculateAmountByAssetType(
                mapRecords, AssetType.ACTIVE_CURRENT),
                calculateAmountByAssetType(mapRecords, AssetType.PASSIVE_CURRENT)
        );
    }

    public StatementIncome getStatementIncome() {
        var mapAccountRecord = getConvertedMapAccountRecords();

        return new StatementIncome(
                calculateTotalActivesAmount(mapAccountRecord),
                calculateTotalPassivesAmount(mapAccountRecord)
        );
    }

    private Set<AccountRecord> getFilteredAccountRecords() {
        return accountRecords.stream()
                .filter(record ->
                        !record.getData().isBefore(this.startDate) &&
                                !record.getData().isAfter(this.endDate))
                .collect(Collectors.toSet());
    }

    private Map<AssetType, Set<AccountRecord>> getConvertedMapAccountRecords() {
        return getFilteredAccountRecords().stream()
                .collect(Collectors.groupingBy(
                        record -> record.getConceptType().getParentType(),
                        Collectors.toSet()
                ));
    }

    public static BigDecimal calculateTotalActivesAmount(Map<AssetType, Set<AccountRecord>> recordMap) {
        return calculateAmountByAssetType(recordMap, AssetType.ACTIVE_CURRENT)
                .add(calculateAmountByAssetType(recordMap, AssetType.FIXED_ACTIVE));
    }

    public static BigDecimal calculateTotalPassivesAmount(Map<AssetType, Set<AccountRecord>> recordMap) {
        return calculateAmountByAssetType(recordMap, AssetType.PASSIVE_CURRENT)
                .add(calculateAmountByAssetType(recordMap, AssetType.PASSIVE_LONG_TERM));
    }

    public static BigDecimal calculateAmountByAssetType(Map<AssetType, Set<AccountRecord>> recordMap, AssetType assetType) {
        return getSetByAssetType(recordMap, assetType).stream()
                .map(AccountRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Set<AccountRecord> getSetByAssetType(Map<AssetType, Set<AccountRecord>> recordMap, AssetType assetType) {
        return recordMap.getOrDefault(assetType, new HashSet<>());
    }
}
