/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Notifications.Notification;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Ing-Ruei
 */
public class UserAccount {
     private String username;
     private String password;
    private Employee employee;
    private Role role;
    private ArrayList<WorkRequest> workQueue;
    private ArrayList<Notification> notificationList; // New field for notifications

    public UserAccount() {
        workQueue = new ArrayList();
        notificationList = new ArrayList<>(); // Initialize notificationList
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for employee
    public Employee getEmployee() {
        return employee;
    }

    // Setter for employee
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // Getter for role
    public Role getRole() {
        return role;
    }

    // Setter for role
    public void setRole(Role role) {
        this.role = role;
    }

    // Getter for workQueue
    public ArrayList<WorkRequest> getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(ArrayList<WorkRequest> workQueue) {
        this.workQueue = workQueue;
    }

    public ArrayList<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(ArrayList<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    // Override toString method to return username
    @Override
    public String toString() {
        return username;
    }
}
