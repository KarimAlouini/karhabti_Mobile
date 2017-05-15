/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.entities;

import java.util.List;

/**
 *
 * @author USER
 */
public class Marque {
    private int id ;
    private String libelle_ma;
   
    private List<Modele> modeles;

    public Marque() {
    }

    public Marque(int id, String libelle_ma) {
        this.id = id;
        this.libelle_ma = libelle_ma;
    }

    public Marque(String libelle_ma) {
        this.libelle_ma = libelle_ma;
    }
    

    public Marque(int id, String libelle_ma, List<Modele> modeles) {
        this.id = id;
        this.libelle_ma = libelle_ma;
        this.modeles = modeles;
    }
    
    public int getId() {
        return id;
    }

    public String getLibelle_ma() {
        return libelle_ma;
    }

    public List<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(List<Modele> modeles) {
        this.modeles = modeles;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle_ma(String libelle_ma) {
        this.libelle_ma = libelle_ma;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Marque other = (Marque) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  libelle_ma ;
    }
    
   
   
    
}
