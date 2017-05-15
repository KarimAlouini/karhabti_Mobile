/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.entities;

import com.codename1.ui.events.ActionListener;

/**
 *
 * @author islem
 */
public class Offre {

   
    private int id ;
    
    private String nom;
    public int prix_ucode;
    private int prix_uconduite;
    private String description;
    
     public Offre() {
    }
     

    public Offre(String nom, int prix_ucode, int prix_uconduite, String description) {
       
        this.nom = nom;
        this.prix_ucode = prix_ucode;
        this.prix_uconduite = prix_uconduite;
        this.description = description;
    }
     

     

    public Offre(int id, String nom, int prix_ucode, int prix_uconduite, String description) {
        this.id = id;
      
        this.nom = nom;
        this.prix_ucode = prix_ucode;
        this.prix_uconduite = prix_uconduite;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Offre{" + "nom=" + nom + ", prix_ucode=" + prix_ucode + ", prix_uconduite=" + prix_uconduite + ", description=" + description + '}';
    }

    
   

    
}
