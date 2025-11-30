package Business.Statuses;

public class RequestStatus {

    public enum DonorApplicationStatus {
        PENDING_REVIEW("Pending Review"),
        APPROVED("Approved"),
        REJECTED("Rejected"),
        ADDITIONAL_TESTING_REQUESTED("Additional Testing Requested"),
        ACTIVE_DONOR("Active Donor"),
        RETRIEVAL_SCHEDULED("Retrieval Scheduled"), // Added for DonorApplicationStatus
        PRE_SURGERY_COORDINATION("Pre-Surgery Coordination"); // Added for DonorApplicationStatus

        private final String value;

        DonorApplicationStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum PatientRequestStatus {
        PENDING_VERIFICATION("Pending Verification"),
        IN_PRIORITY_QUEUE("In Priority Queue"),
        MATCHED_AWAITING_ACCEPTANCE("Matched - Awaiting Acceptance"),
        MATCH_ACCEPTED("Match Accepted"),
        MATCH_DECLINED("Match Declined"),
        READY_FOR_TRANSPLANT("Ready for Transplant"),
        TRANSPLANTED("Transplanted"),
        REJECTED("Rejected");

        private final String value;

        PatientRequestStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum OrganLogisticsStatus {
        RETRIEVAL_SCHEDULED("Retrieval Scheduled"),
        RETRIEVAL_STARTED("Retrieval Started"),
        READY_FOR_TRANSPORT("Ready for Transport"),
        IN_TRANSIT("In Transit"),
        DELIVERED("Delivered"),
        STORAGE("In Storage"),
        COMPLETED("Completed"),
        CANCELLED("Cancelled");

        private final String value;

        OrganLogisticsStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum SurgeryStatus {
        SCHEDULED("Scheduled"),
        PRE_OP_PREPARATION("Pre-Op Preparation"),
        COMMENCED("Commenced"),
        COMPLETED("Completed"),
        COMPLICATIONS_NOTED("Complications Noted"),
        POST_OP_FOLLOWUP("Post-Op Follow-up");

        private final String value;

        SurgeryStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum EmergencyStatus {
        ISSUE_DETECTED("Issue Detected"),
        ALERT_ESCALATED("Alert Escalated"),
        COMMUNICATION_OPEN("Communication Open"),
        CONTINGENCY_DECIDED("Contingency Decided"),
        RESOLVED("Resolved");

        private final String value;

        EmergencyStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
