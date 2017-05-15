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
public class Permis {
    private int id;
    private int agence_id;
    private String type;

    public Permis() {
    }

    public Permis(int id, String type) {
        this.id = id;
        this.type = type;
    }
    
    

    public Permis(int id) {
        this.id = id;
    }

    public Permis(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgence_id() {
        return agence_id;
    }

    public void setAgence_id(int agence_id) {
        this.agence_id = agence_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final Permis other = (Permis) obj;
        return true;
    }

   
    

    @Override
    public String toString() {
        return type;
    }
     
    
    
}
