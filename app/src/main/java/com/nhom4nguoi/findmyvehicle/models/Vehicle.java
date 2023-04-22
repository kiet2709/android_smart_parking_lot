package com.nhom4nguoi.findmyvehicle.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vehicle implements Serializable {
    @SerializedName("licencePlate")
    @Expose
    private String id;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("locate")
    @Expose
    private String locate;
    private String cardNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Vehicle(String id, String imageUrl, String locate, String cardNumber) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.locate = locate;
        this.cardNumber = cardNumber;
    }

    public Vehicle(String id, String imageUrl, String locate) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.locate = locate;
    }

    public Vehicle(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
