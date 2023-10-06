package enums;

public enum ConceptType {


    CURRENT_MONEY(AssetType.ACTIVE_CURRENT),
    BILL_TO_RECEIVE(AssetType.ACTIVE_CURRENT),
    STOCK(AssetType.ACTIVE_CURRENT),

    // ATIVO FIJO
    PROPERTY(AssetType.FIXED_ACTIVE),
    TEAM(AssetType.FIXED_ACTIVE),
    DEFERRED_ASSETS(AssetType.FIXED_ACTIVE),

    // PASSIVO CORRIENTE
    TAX(AssetType.PASSIVE_CURRENT),
    BILL_TO_PAY(AssetType.PASSIVE_CURRENT),
    RESERVE_PROVISION(AssetType.PASSIVE_CURRENT),

    // PASSIVO A LARGO PLAZO
    BONUSES(AssetType.PASSIVE_LONG_TERM),
    FINANCE_LEASES(AssetType.PASSIVE_LONG_TERM),
    LONG_TERM_LOAN(AssetType.PASSIVE_LONG_TERM);

    private AssetType parentType;

    ConceptType(AssetType parentType) {
        this.parentType = parentType;
    }

    public AssetType getParentType() {
        return parentType;
    }
}
