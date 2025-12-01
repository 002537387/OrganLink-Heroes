package Business.OrganTypes;

public enum OrganStatus {
    AVAILABLE("Available"),
    ALLOCATED("Allocated"),
    IN_TRANSIT("In Transit"),
    TRANSPLANTED("Transplanted"),
    DISCARDED("Discarded"),
    RETRIEVED("Retrieved"); // Added for explicit retrieved state

    private final String value;

    OrganStatus(String value) {
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
