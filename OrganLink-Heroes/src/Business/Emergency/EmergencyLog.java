/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Emergency;
import Business.UserAccount.UserAccount;
import java.util.Date;
/**
 *
 * @author jim.hsieh
 */
public class EmergencyLog {
     private Date timestamp;
    private String actionType;
    private UserAccount performedBy;
    private String description;
    
    public EmergencyLog(String actionType, UserAccount performedBy) {
        this.timestamp = new Date();
        this.actionType = actionType;
        this.performedBy = performedBy;
        this.description = "";
    }
    
    public EmergencyLog(String actionType, UserAccount performedBy, String description) {
        this.timestamp = new Date();
        this.actionType = actionType;
        this.performedBy = performedBy;
        this.description = description;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public String getActionType() {
        return actionType;
    }
    
    public UserAccount getPerformedBy() {
        return performedBy;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return timestamp + " - " + actionType + " by " + 
               (performedBy != null ? performedBy.getUsername() : "System");
    }
}
