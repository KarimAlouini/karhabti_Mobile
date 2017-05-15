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
public class Type_v {
    private int id ;
    private String libelle_t ;

    public Type_v(int id, String libelle_t) {
        this.id = id;
        this.libelle_t = libelle_t;
    }

    public Type_v() {
    }

    public Type_v(String libelle_t) {
        this.libelle_t = libelle_t;
    }

    public int getId() {
        return id;
    }

    public String getLibelle_t() {
        return libelle_t;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle_t(String libelle_t) {
        this.libelle_t = libelle_t;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
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
        final Type_v other = (Type_v) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle_t ;
    }
    
    
}
