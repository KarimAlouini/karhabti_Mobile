/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.entities;

/**
 *
 * @author USER
 */
public class Modele {
    private int id ;
    private String libelle_mo ;
    private Marque marque;

    public Modele() {
    }
    
    

    public Modele(int id, String libelle_mo, Marque marque) {
        this.id = id;
        this.libelle_mo = libelle_mo;
        this.marque = marque;
    }

    public Modele(String libelle_mo, Marque marque) {
        this.libelle_mo = libelle_mo;
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public String getLibelle_mo() {
        return libelle_mo;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle_mo(String libelle_mo) {
        this.libelle_mo = libelle_mo;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
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
        final Modele other = (Modele) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle_mo ;
    }
    
    
}
