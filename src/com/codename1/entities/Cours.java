/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.entities;


import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author USER
 */
public class Cours {
    private int id;
    private String titre;
    public String contenue;
    private Date dateajout;
    private Permis permis_id;
    private String permis;


    public Cours() {
    }


    public Cours(String titre, String contenue,String permis) {
        this.titre = titre;
        this.contenue = contenue;
        this.permis = permis;
        
        
    }

    public Cours(int id, String titre, String contenue, Date dateajout, String permis) {
        this.id = id;
        this.titre = titre;
        this.contenue = contenue;
        this.dateajout = dateajout;
        this.permis = permis;
    }

    public Cours(String titre, String contenue,Date dateajout,Permis permis_id) {
        this.titre = titre;
        this.contenue = contenue;
        this.dateajout = dateajout;
        this.permis_id = permis_id;
    }

  
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
  
       this.id=id;
               
      
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }
    
  

    public Date getDateajout() {
        return dateajout;
    }

    public void setDateajout(String dateajout) {
      String DATE_FORMAT_NOW = "yyyy-MM-dd";
     DateFormat df=new SimpleDateFormat(DATE_FORMAT_NOW);
        
        try {
            this.dateajout = df.parse(dateajout);
        } catch (ParseException ex) {
            System.out.println("Error Parsing");
        }
    
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

//    public String getPermis_id() {
//        return permis_id;
//    }
//
//    public void setPermis_id(String permis_id) {
//        this.permis_id = permis_id;
//    }
//    


  
    

    
    
    @Override
    public String toString() {
        return "Cours{" + "id=" + id + ", titre=" + titre + ", contenue=" + contenue + ", dateajout=" + dateajout + '}';
    }

   
      
    
}
