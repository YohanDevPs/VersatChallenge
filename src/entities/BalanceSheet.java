package entities;

import enums.AssetType;
import enums.ConceptType;

import java.math.BigDecimal;
import java.util.*;

public class BalanceSheet {

    private Map<AssetType, Set<AccountRecord>> recordMap;
    private BigDecimal totalActives;
    private BigDecimal totalPassives;

    public BalanceSheet(Map<AssetType, Set<AccountRecord>> recordMap) {
        this.recordMap = Optional.ofNullable(recordMap).orElse(Collections.emptyMap());
    }

    public BigDecimal getTotalActivesAmount() {
        return getAmountByAssetType(AssetType.ACTIVE_CURRENT)
                .add(getAmountByAssetType(AssetType.FIXED_ACTIVE));
    }

    public BigDecimal getTotalPassivesAmount() {
        return getAmountByAssetType(AssetType.PASSIVE_CURRENT)
                .add(getAmountByAssetType(AssetType.PASSIVE_LONG_TERM));
    }

    public BigDecimal getAmountByAssetType(AssetType assetType) {
        return getSetByAssetType(assetType).stream()
                .map(AccountRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Set<AccountRecord> getSetByAssetType(AssetType assetType) {
        return recordMap.getOrDefault(assetType, new HashSet<>());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---- BALANCE GENERAL ---- \n");
        appendCategoryDetails(stringBuilder, AssetType.ACTIVE_CURRENT);
        appendCategoryDetails(stringBuilder, AssetType.FIXED_ACTIVE);
        stringBuilder.append(String.format("----- TOTAL ACTIVOS: %.2f -----%n%n", getTotalActivesAmount()));
        appendCategoryDetails(stringBuilder, AssetType.PASSIVE_CURRENT);
        appendCategoryDetails(stringBuilder, AssetType.PASSIVE_LONG_TERM);
        stringBuilder.append(String.format("----- TOTAL PASSIVO: %.2f -----%n", getTotalPassivesAmount()));
        return stringBuilder.toString();
    }

    private void appendCategoryDetails(StringBuilder stringBuilder, AssetType assetType) {
        stringBuilder.append(assetType.getDescription()).append("\n");
        Set<ConceptType> processedConceptTypes = new HashSet<>();
        for (AccountRecord record : getSetByAssetType(assetType)) {
            ConceptType conceptType = record.getConceptType();
            if (processedConceptTypes.add(conceptType)) {
                BigDecimal totalAmount = getTotalAmountForConceptType(conceptType);
                stringBuilder.append(conceptType.getDescription())
                        .append(": ")
                        .append(totalAmount)
                        .append("\n");
            }
        }
        stringBuilder.append(String.format("Total %s: %.2f%n%n", assetType.getDescription(), getAmountByAssetType(assetType)));
        processedConceptTypes.clear();
    }

    private BigDecimal getTotalAmountForConceptType(ConceptType conceptType) {
        return getSetByAssetType(conceptType.getParentType()).stream()
                .filter(record -> record.getConceptType().equals(conceptType))
                .map(AccountRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}