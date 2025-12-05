package Business.Notifications;

import java.util.Date;

public class Notification {
    private String message;
    private Date timestamp;
    private String recipientUserName; // Or UserAccount object, depending on how we want to identify
    private boolean isRead;

    public Notification(String message, String recipientUserName) {
        this.message = message;
        this.timestamp = new Date();
        this.recipientUserName = recipientUserName;
        this.isRead = false;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getRecipientUserName() {
        return recipientUserName;
    }

    public void setRecipientUserName(String recipientUserName) {
        this.recipientUserName = recipientUserName;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return message;
    }
}
