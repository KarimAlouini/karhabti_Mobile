/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  com.codename1.entities;


import javafx.collections.ObservableList;

/**
 *
 * @author WALA
 */
public class Avis_agence {
     private int id;
     private int agence_id;


     private String nom_agence;
     private String nom;
     private String comment;
     private String mail;
     private int choix_avis;
     private int client_id;
  
     public Avis_agence(String nom_agence, int id, String nom, String comment, String mail ) {
        this.id = id;
        
        this. nom_agence =  nom_agence;
        this.nom = nom;
        this.comment =comment;
        this.mail = mail;
       }

    public Avis_agence () {
       
    }


    public Avis_agence(String nom_agence) {
        this.nom_agence = nom_agence;
    }

    public Avis_agence(String mail,String nom,String nom_agence,String comment, int choix_avis) {
        this.mail = mail;
        this.nom = nom;
        this.nom_agence = nom_agence;
        this.comment = comment;
        this.choix_avis = choix_avis;
    }
  public Avis_agence(String nom_agence, int choix_avis, String comment) {
        
        this.nom_agence = nom_agence;
        this.choix_avis = choix_avis;
        this.comment = comment;
        
    }

    public Avis_agence(String nom, String mail, String comment) {
        this.nom = nom;
        this.comment = comment;
        this.mail = mail;
    }

    public Avis_agence(  int choix_avis,String comment) {
          this.choix_avis = choix_avis;
        this.comment = comment;
      
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_agence() {
        return nom_agence;
    }

    public void setNom_agence(String nom_agence) {
        this.nom_agence = nom_agence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getChoix_avis() {
        return choix_avis;
    }

    public void setChoix_avis(int choix_avis) {
        this.choix_avis = choix_avis;
    }
  
    public int getAgence_id() {
        return agence_id;
    }

    public void setAgence_id(int agence_id) {
        this.agence_id = agence_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    

     
}
