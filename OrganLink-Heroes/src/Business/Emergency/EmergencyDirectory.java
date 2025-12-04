/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Emergency;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jim.hsieh
 */
public class EmergencyDirectory {
    private List<Emergency> emergencyList;
    
    public EmergencyDirectory() {
        this.emergencyList = new ArrayList<>();
    }
    
    public Emergency createEmergency(String type, String description, UserAccount reportedBy) {
        Emergency emergency = new Emergency(type, description, reportedBy);
        emergencyList.add(emergency);
        return emergency;
    }
    
    public List<Emergency> getAllEmergencies() {
        return emergencyList;
    }
    
    public List<Emergency> getActiveEmergencies() {
        List<Emergency> activeList = new ArrayList<>();
        for (Emergency e : emergencyList) {
            if (e.getStatus().equals("Active") || e.getStatus().equals("In Progress")) {
                activeList.add(e);
            }
        }
        return activeList;
    }
    
    public Emergency findEmergencyByID(String emergencyID) {
        for (Emergency e : emergencyList) {
            if (e.getEmergencyID().equals(emergencyID)) {
                return e;
            }
        }
        return null;
    }
    
    public List<Emergency> getEmergenciesNeedingReview() {
        List<Emergency> needReview = new ArrayList<>();
        for (Emergency e : emergencyList) {
            if (e.getStatus().equals("Resolved") && !e.isPostIncidentReviewCompleted()) {
                needReview.add(e);
            }
        }
        return needReview;
    }
}
