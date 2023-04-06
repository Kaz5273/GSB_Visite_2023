package com.example.mygsbvisite.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Visite implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("dateVisite")
    private Date dateVisite;
    @SerializedName("commentaire")
    private String commentaire;

    public int getId() {
        return id;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public String getCommentaire() {
        return commentaire;
    }
}
