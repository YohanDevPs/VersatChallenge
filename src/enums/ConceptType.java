package enums;

public enum ConceptType {
    CURRENT_MONEY(AssetType.ACTIVE_CURRENT, "Dinero actual"),
    BILL_TO_RECEIVE(AssetType.ACTIVE_CURRENT, "Cuentas para recibir"),
    EFECTIVO(AssetType.ACTIVE_CURRENT, "Efectivos"),

    PROPERTY(AssetType.FIXED_ACTIVE, "Propriedades"),
    TEAM(AssetType.FIXED_ACTIVE, "Equipos"),
    DEFERRED_ASSETS(AssetType.FIXED_ACTIVE, "Activos diferidos"),

    TAX(AssetType.PASSIVE_CURRENT, "Impuesto"),
    BILL_TO_PAY(AssetType.PASSIVE_CURRENT, "Factura para pagar"),
    RESERVE_PROVISION(AssetType.PASSIVE_CURRENT, "Provisión de reserva"),

    BONUSES(AssetType.PASSIVE_LONG_TERM, "Bonificaciones"),
    FINANCE_LEASES(AssetType.PASSIVE_LONG_TERM, "Arrendamientos financieros"),
    LONG_TERM_LOAN(AssetType.PASSIVE_LONG_TERM, "Préstamo a largo plazo");

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
