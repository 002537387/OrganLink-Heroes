package Business.OrganTypes;

public enum OrganType {
    KIDNEY("Kidney"),
    LIVER("Liver"),
    HEART("Heart"),
    LUNG("Lung"),
    PANCREAS("Pancreas"),
    INTESTINE("Intestine"),
    CORNEA("Cornea"); // Example, other tissues might be added

    private final String value;

    private OrganType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
