package Business.Requests;

public enum MedicalUrgencyLevel {
    CRITICAL("Critical"),
    HIGH("High"),
    MEDIUM("Medium"),
    STANDARD("Standard");

    private final String value;

    MedicalUrgencyLevel(String value) {
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
