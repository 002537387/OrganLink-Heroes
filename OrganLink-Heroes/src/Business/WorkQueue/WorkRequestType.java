package Business.WorkQueue;

public enum WorkRequestType {
    DONOR_REQUEST("Donor Request"),
    PATIENT_REQUEST("Patient Request"),
    ANTITRAFFICKING_ALERT("Anti-Trafficking Alert");

    private final String value;

    WorkRequestType(String value) {
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
