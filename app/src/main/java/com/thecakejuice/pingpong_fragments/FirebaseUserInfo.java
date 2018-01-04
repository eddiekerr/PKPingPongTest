package com.thecakejuice.pingpong_fragments;

/**
 * Created by eddiekerr on 30/12/17.
 */

public class FirebaseUserInfo {
    public static String name;
    public static String emailAddress;
    public static String uId;

    public FirebaseUserInfo(){
        //Default constructor
    }

    public FirebaseUserInfo(String firstName, String email, String userId) {
        name = firstName;
        emailAddress = email;
        uId = userId;
    }
}