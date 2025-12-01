package Business.Requests;

public enum DonationType {
    LIVING_DONATION("Living Donation"),
    POST_MORTEM_DONATION("Post-mortem Donation");

    private final String value;

    DonationType(String value) {
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
