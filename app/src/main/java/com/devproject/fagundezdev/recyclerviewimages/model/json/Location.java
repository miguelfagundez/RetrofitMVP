
package com.devproject.fagundezdev.recyclerviewimages.model.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("street")
    @Expose
    private Street street;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("coordinates")
    @Expose
    private Coordinates coordinates;
    @SerializedName("timezone")
    @Expose
    private Timezone timezone;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param country
     * @param city
     * @param street
     * @param timezone
     * @param postcode
     * @param coordinates
     * @param state
     */
    public Location(Street street, String city, String state, String country, String postcode, Coordinates coordinates, Timezone timezone) {
        super();
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postcode = postcode;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

}
