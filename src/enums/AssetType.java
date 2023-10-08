package enums;

public enum AssetType {
    ACTIVE_CURRENT("Activos Currientes"),
    FIXED_ACTIVE("Activos fijos"),
    PASSIVE_CURRENT("Passivos currientes"),
    PASSIVE_LONG_TERM("Passivos a largo plazo");

    private final String description;

    AssetType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
