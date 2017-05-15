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
public class Vehicule {
    private int id ;
    private Marque marque;
    private Modele modele;
    private String matricule;
    private Date dExp_assurance;
    private Date dExp_vignette;
    private Date dExp_visite;
    private Type_v type_v;
    private Agence agence_id;
    private Boolean reserved; 

    public Vehicule(int id, String matricule) {
        this.id = id;
        this.matricule = matricule;
    }
    

    public Vehicule(int id, Marque marque, Modele modele, String matricule, Date dExp_assurance, Date dExp_vignette, Date dExp_visite, Type_v type_v, Agence agence_id, Boolean reserved) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.matricule = matricule;
        this.dExp_assurance = dExp_assurance;
        this.dExp_vignette = dExp_vignette;
        this.dExp_visite = dExp_visite;
        this.type_v = type_v;
        this.agence_id = agence_id;
        this.reserved = reserved;
    }

    public Vehicule(Marque marque, Modele modele, String matricule, Date dExp_assurance, Date dExp_vignette, Date dExp_visite, Type_v type_v, Agence agence_id, Boolean reserved) {
        this.marque = marque;
        this.modele = modele;
        this.matricule = matricule;
        this.dExp_assurance = dExp_assurance;
        this.dExp_vignette = dExp_vignette;
        this.dExp_visite = dExp_visite;
        this.type_v = type_v;
        this.agence_id = agence_id;
        this.reserved = reserved;
    }

    public Vehicule(Marque marque, Modele modele, String matricule, Date dExp_assurance, Date dExp_vignette, Date dExp_visite, Type_v type_v) {
        this.marque = marque;
        this.modele = modele;
        this.matricule = matricule;
        this.dExp_assurance = dExp_assurance;
        this.dExp_vignette = dExp_vignette;
        this.dExp_visite = dExp_visite;
        this.type_v = type_v;
    }
    

    public Vehicule(int id, Marque marque, Modele modele, String matricule, Date dExp_assurance, Date dExp_vignette, Date dExp_visite, Type_v type_v) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.matricule = matricule;
        this.dExp_assurance = dExp_assurance;
        this.dExp_vignette = dExp_vignette;
        this.dExp_visite = dExp_visite;
        this.type_v = type_v;
    }

    public Vehicule() {
    
    }
    

    public int getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public Date getdExp_assurance() {
        return dExp_assurance;
    }

    public Date getdExp_vignette() {
        return dExp_vignette;
    }

    public Date getdExp_visite() {
        return dExp_visite;
    }

    public Marque getMarque() {
        return marque;
    }

    public Modele getModele() {
        return modele;
    }

    public Type_v getType_v() {
        return type_v;
    }

    public Agence getAgence_id() {
        return agence_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setdExp_assurance(Date dExp_assurance) {
        this.dExp_assurance = dExp_assurance;
    }

    public void setdExp_vignette(Date dExp_vignette) {
        this.dExp_vignette = dExp_vignette;
    }

    public void setdExp_visite(Date dExp_visite) {
        this.dExp_visite = dExp_visite;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public void setType_v(Type_v type_v) {
        this.type_v = type_v;
    }

    public void setAgence_id(Agence agence_id) {
        this.agence_id = agence_id;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final Vehicule other = (Vehicule) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return matricule;
    }
    
   
}
