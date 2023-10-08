package entities;

import enums.AssetType;
import enums.ConceptType;
import processing.FinancialDataProcessor;
import utils.NumberFormater;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

import static utils.NumberFormater.getNumberFormater;

public class BalanceSheet {

    private final Map<AssetType, Set<AccountRecord>> recordMap;

    public BalanceSheet(Map<AssetType, Set<AccountRecord>> recordMap) {
        this.recordMap = Optional.ofNullable(recordMap).orElse(Collections.emptyMap());
    }

    public BigDecimal getTotalActivesAmount() {
        return FinancialDataProcessor.calculateTotalActivesAmount(recordMap);
    }

    public BigDecimal getTotalPassivesAmount() {
        return FinancialDataProcessor.calculateTotalPassivesAmount(recordMap);
    }

    public BigDecimal getAmountByAssetType(AssetType assetType) {
        return getSetByAssetType(assetType).stream()
                .map(AccountRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Set<AccountRecord> getSetByAssetType(AssetType assetType) {
        return recordMap.getOrDefault(assetType, new HashSet<>());
    }

    public void showBalanceSheet() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---- BALANCE GENERAL ---- \n");
        appendCategoryDetails(stringBuilder, AssetType.ACTIVE_CURRENT);
        appendCategoryDetails(stringBuilder, AssetType.FIXED_ACTIVE);
        stringBuilder.append(String.format("TOTAL ACTIVOS: $ %s%n%n", getNumberFormater().format(getTotalActivesAmount())));
        appendCategoryDetails(stringBuilder, AssetType.PASSIVE_CURRENT);
        appendCategoryDetails(stringBuilder, AssetType.PASSIVE_LONG_TERM);
        stringBuilder.append(String.format("TOTAL PASSIVO: $ %s%n", getNumberFormater().format(getTotalPassivesAmount())));

        System.out.println(stringBuilder);
    }

    private void appendCategoryDetails(StringBuilder stringBuilder, AssetType assetType) {
        stringBuilder.append(assetType.getDescription()).append("\n");
        Set<ConceptType> processedConceptTypes = new HashSet<>();
        for (AccountRecord record : getSetByAssetType(assetType)) {
            ConceptType conceptType = record.getConceptType();
            if (processedConceptTypes.add(conceptType)) {
                stringBuilder.append(conceptType.getDescription())
                        .append(": $ ")
                        .append(getNumberFormater()
                                .format(getTotalAmountForConceptType(conceptType))
                        )
                        .append("\n");
            }
        }
        stringBuilder.append(String.format("Total %s: $ %s %n%n", assetType.getDescription(), getNumberFormater().format(getAmountByAssetType(assetType))));
        processedConceptTypes.clear();
    }

    private BigDecimal getTotalAmountForConceptType(ConceptType conceptType) {
        return getSetByAssetType(conceptType.getParentType()).stream()
                .filter(record -> record.getConceptType().equals(conceptType))
                .map(AccountRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
