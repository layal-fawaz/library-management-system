package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class User {

 private String userName, password, email, phoneNumber, role;
 private StringProperty fullName=new SimpleStringProperty();
 private StringProperty profileImagePath=new SimpleStringProperty();
private int id;
 
    public User(String fullName, String userName, String password, String email, String phoneNumber, String role, String profileImagePath) {
        this.fullName.set(fullName);
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.profileImagePath.set(profileImagePath);
    }

     public User(int id,String fullName, String userName, String password, String email, String phoneNumber, String role, String profileImagePath) {
        this.fullName.set(fullName);
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.profileImagePath.set(profileImagePath);
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName.get();
    }

    
    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public StringProperty fullNameProperty(){
         return this.fullName;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the profileImagePath
     */
    public String getProfileImagePath() {
        return profileImagePath.get();
    }

    /**
     * @param profileImagePath the profileImagePath to set
     */
    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath.set(profileImagePath);
    }

       public StringProperty ProfileImagePathProperty(){
         return this.profileImagePath;
    }
}
