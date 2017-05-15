/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.entities;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Client {
    private int id;
    private Moniteur moniteur_id;
    private User user_id;
    private String civilite ;
    private String nom;
    private String prenom ;
    private String adresse;
    private String ville;
    private int codePostal;
    private int telephone;
    private Date dateNaissance;
    private String villeNaissance;
    private Boolean etatCode;
    private Agence agence_id ;

    public Client(String civilite, String nom, String prenom) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Moniteur getMoniteur_id() {
        return moniteur_id;
    }

    public void setMoniteur_id(Moniteur moniteur_id) {
        this.moniteur_id = moniteur_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVilleNaissance() {
        return villeNaissance;
    }

    public void setVilleNaissance(String villeNaissance) {
        this.villeNaissance = villeNaissance;
    }

    public Boolean getEtatCode() {
        return etatCode;
    }

    public void setEtatCode(Boolean etatCode) {
        this.etatCode = etatCode;
    }

    public Agence getAgence_id() {
        return agence_id;
    }

    public void setAgence_id(Agence agence_id) {
        this.agence_id = agence_id;
    }

    public Client(int id, Moniteur moniteur_id, User user_id, String civilite, String nom, String prenom, String adresse, String ville, int codePostal, int telephone, Date dateNaissance, String villeNaissance, Boolean etatCode, Agence agence_id) {
        this.id = id;
        this.moniteur_id = moniteur_id;
        this.user_id = user_id;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.villeNaissance = villeNaissance;
        this.etatCode = etatCode;
        this.agence_id = agence_id;
    }

    public Client(Moniteur moniteur_id, User user_id, String civilite, String nom, String prenom, String adresse, String ville, int codePostal, int telephone, Date dateNaissance, String villeNaissance, Boolean etatCode, Agence agence_id) {
        this.moniteur_id = moniteur_id;
        this.user_id = user_id;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.villeNaissance = villeNaissance;
        this.etatCode = etatCode;
        this.agence_id = agence_id;
    }

    public Client() {
    }

    @Override
    public String toString() {
        return  nom +" "+ prenom ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
