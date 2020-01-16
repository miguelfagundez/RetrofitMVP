package com.devproject.fagundezdev.recyclerviewimages.model;

/*
 * Class name: Friend
 * Model class for handling values for recyclerview
 * @author Miguel Fagundez
 * @version 1.0
 * @since January 2020
 * */
public class Friend {

    private String fName;
    private String lName;
    private String url;


    /*
    * Constructor
    * */
    public Friend(String fName, String lName, String url) {
        this.fName = fName;
        this.lName = lName;
        this.url = url;
    }

    /*
    * Getters and Setters
    * */
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
