package com.example.firebaseuser.AccountActivity;

public class User {
        String username, email, id;

        public User(){

        }

        public User(String id, String username, String email) {
            this.id = id;
            this.username = username;
            this.email = email;
        }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

}
