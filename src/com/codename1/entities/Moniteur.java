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
public class Moniteur {
     private int id;
    private Agence agence_id;
    private User user_id;
    private String civilite ;
    private String nom;
    private String prenom ;
    private String adresse;
    private String mail;
    private String ville;
    private int codePostal;
    private String telephone;
    private Date dateNaissance;
    private String lieuNaissance;

    public Moniteur(String civilite, String nom, String prenom) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
    }
    

    public Moniteur() {
    }

    public Moniteur(int id, Agence agence_id, User user_id, String civilite, String nom, String prenom, String adresse, String mail, String ville, int codePostal, String telephone, Date dateNaissance, String lieuNaissance) {
        this.id = id;
        this.agence_id = agence_id;
        this.user_id = user_id;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
    }

    public Moniteur(Agence agence_id, User user_id, String civilite, String nom, String prenom, String adresse, String mail, String ville, int codePostal, String telephone, Date dateNaissance, String lieuNaissance) {
        this.agence_id = agence_id;
        this.user_id = user_id;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Agence getAgence_id() {
        return agence_id;
    }

    public void setAgence_id(Agence agence_id) {
        this.agence_id = agence_id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    @Override
    public String toString() {
        return  civilite + " " + nom;
    }

    
    
    
    
}
