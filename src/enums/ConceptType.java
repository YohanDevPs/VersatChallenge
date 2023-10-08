package enums;

public enum ConceptType {
    CURRENT_MONEY(AssetType.ACTIVE_CURRENT, "Current Money"),
    BILL_TO_RECEIVE(AssetType.ACTIVE_CURRENT, "Bill to Receive"),
    EFECTIVO(AssetType.ACTIVE_CURRENT, "Efectivo"),

    PROPERTY(AssetType.FIXED_ACTIVE, "Property"),
    TEAM(AssetType.FIXED_ACTIVE, "Team"),
    DEFERRED_ASSETS(AssetType.FIXED_ACTIVE, "Deferred Assets"),

    TAX(AssetType.PASSIVE_CURRENT, "Tax"),
    BILL_TO_PAY(AssetType.PASSIVE_CURRENT, "Bill to Pay"),
    RESERVE_PROVISION(AssetType.PASSIVE_CURRENT, "Reserve Provision"),

    BONUSES(AssetType.PASSIVE_LONG_TERM, "Bonuses"),
    FINANCE_LEASES(AssetType.PASSIVE_LONG_TERM, "Finance Leases"),
    LONG_TERM_LOAN(AssetType.PASSIVE_LONG_TERM, "Long Term Loan");

    private final AssetType parentType;
    private final String description;

    ConceptType(AssetType parentType, String description) {
        this.parentType = parentType;
        this.description = description;
    }

    public AssetType getParentType() {
        return parentType;
    }

    public String getDescription() {
        return description;
    }
}
