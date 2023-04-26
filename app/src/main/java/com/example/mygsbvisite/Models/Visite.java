package com.example.mygsbvisite.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Visite implements Serializable {
    @SerializedName("dateVisite")
    private Date dateVisite;
    @SerializedName("commentaire")
    private String commentaire;
    @SerializedName("visiteur")
    private String visiteur;
    @SerializedName("praticien")
    private String praticien;


    public Visite( Date dateVisite, String commentaire, String visiteur, String praticien) {

        this.dateVisite = dateVisite;
        this.commentaire = commentaire;
        this.visiteur = visiteur;
        this.praticien = praticien;
    }




    public Date getDateVisite() {
        return dateVisite;
    }

    public String getCommentaire() {
        return commentaire;
    }
    public String getVisiteur() {
        return visiteur;
    }

    public String getPraticien() {
        return praticien;
    }
}
