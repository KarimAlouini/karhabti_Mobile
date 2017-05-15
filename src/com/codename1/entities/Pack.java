/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.entities;

/**
 *
 * @author islem
 */
public class Pack {
    private int id ;
   
    private String nom;
    private int nbr_heure_code ;
    private int nbr_heure_conduite ;
    private int prix_ucode;
    private int prix_uconduite;
    private int prix_total;
    private String description;
    private int promotion;
    
    public Pack() {
    }

    public Pack(int id,String nom, int nbr_heure_code, int nbr_heure_conduite, int prix_ucode, int prix_uconduite, int prix_total, String description, int promotion) {
        this.id = id;
       
        this.nom = nom;
        this.nbr_heure_code = nbr_heure_code;
        this.nbr_heure_conduite = nbr_heure_conduite;
        this.prix_ucode = prix_ucode;
        this.prix_uconduite = prix_uconduite;
        this.prix_total = prix_total;
        this.description = description;
        this.promotion = promotion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbr_heure_code() {
        return nbr_heure_code;
    }

    public void setNbr_heure_code(int nbr_heure_code) {
        this.nbr_heure_code = nbr_heure_code;
    }

    public int getNbr_heure_conduite() {
        return nbr_heure_conduite;
    }

    public void setNbr_heure_conduite(int nbr_heure_conduite) {
        this.nbr_heure_conduite = nbr_heure_conduite;
    }

    public int getPrix_ucode() {
        return prix_ucode;
    }

    public void setPrix_ucode(int prix_ucode) {
        this.prix_ucode = prix_ucode;
    }

    public int getPrix_uconduite() {
        return prix_uconduite;
    }

    public void setPrix_uconduite(int prix_uconduite) {
        this.prix_uconduite = prix_uconduite;
    }

    public int getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(int prix_total) {
        this.prix_total = prix_total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "Pack{" + "id=" + id + ", nom=" + nom + ", nbr_heure_code=" + nbr_heure_code + ", nbr_heure_conduite=" + nbr_heure_conduite + ", prix_ucode=" + prix_ucode + ", prix_uconduite=" + prix_uconduite + ", prix_total=" + prix_total + ", description=" + description + ", promotion=" + promotion + '}';
    }

  

    
}
