package com.example.mygsbvisite.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Visiteurs implements Serializable {
    @SerializedName("hydra:member")
    private ArrayList<Visiteur> visiteurs;

    public ArrayList<Visiteur> getVisiteurs() {
        return visiteurs;
    }
}
