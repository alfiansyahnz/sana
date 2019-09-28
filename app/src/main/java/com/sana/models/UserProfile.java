package com.sana.models;

/**
 * Created by Dheeraj_Kamath on 2/10/2018.
 */

public class UserProfile {
    public String userAddress;
    public String userEmail;
    public String userName;

    public UserProfile(){
    }

    public UserProfile(String userAddress, String userEmail, String userName) {
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAge(String userAge) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
