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
public class Tache {
    private int id ;
    private Vehicule vehicule;
//    private Time heure_debut;
//    private Time heure_fin;    
    private Client client;   
    private Moniteur moniteur;
    private Date date;
    private Agence agence_id;

    public Tache() {
    }

    public Tache(Vehicule vehicule, Client client, Moniteur moniteur, Date date) {
        this.vehicule = vehicule;
        this.client = client;
        this.moniteur = moniteur;
        this.date = date;
    }
 


    public int getId() {
        return id;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }


    public Client getClient() {
        return client;
    }

    public Moniteur getMoniteur() {
        return moniteur;
    }

    public Date getDate() {
        return date;
    }

    public Agence getAgence_id() {
        return agence_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

//    public void setHeure_debut(Time heure_debut) {
//        this.heure_debut = heure_debut;
//    }
//
//    public void setHeure_fin(Time heure_fin) {
//        this.heure_fin = heure_fin;
//    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setMoniteur(Moniteur moniteur) {
        this.moniteur = moniteur;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAgence_id(Agence agence_id) {
        this.agence_id = agence_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tache other = (Tache) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tache{" + "vehicule=" + vehicule + ", client=" + client + ", moniteur=" + moniteur + '}';
    }

    
    

    
}
