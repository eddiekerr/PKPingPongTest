package com.thecakejuice.pingpong_fragments;

/**
 * Created by eddiekerr on 30/12/17.
 */

public class IsUserSignedIn {
    private static IsUserSignedIn mInstance= null;

    public boolean isUserSignedIn = false;

    protected IsUserSignedIn(){}

    public static synchronized IsUserSignedIn getInstance(){
        if(null == mInstance){
            mInstance = new IsUserSignedIn();
        }
        return mInstance;
    }

    public static boolean setUserSignedIn;{
        this.setUserSignedIn = isUserSignedIn;
    }
}
