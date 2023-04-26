package com.example.mygsbvisite.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Visiteur implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("role")
    private String role;
    @SerializedName("password")
    private String password;
    @SerializedName("nom")
    private String nom;
    @SerializedName("prenom")
    private String prenom;
    @SerializedName("telephone")
    private String telephone;
    @SerializedName("mail")
    private String mail;
    @SerializedName("matricule")
    private String matricule;
    @SerializedName("praticien")
    private ArrayList<String>praticiensStr;



    public Visiteur(String unUsername, String unPassword){
        this.username = unUsername;
        this.password = unPassword;


    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


    public ArrayList<String> getPraticiensStr() {
        return praticiensStr;
    }

    public String formatUrlWithId(int id) {
        String baseUrl = "/api/visiteurs/";
        String formattedId = String.format("%s", id);
        return baseUrl + formattedId;
    }

}
