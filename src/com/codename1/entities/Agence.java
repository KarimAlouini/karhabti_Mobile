/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.codename1.entities;

import javafx.collections.ObservableList;

/**
 *grave,,mfamech 7al??lezem fama hal , mouch 9a3ed ya9ra fil packages mtes les entités eyh 
 * @author smart
 */
public class Agence {
    private String email;
    private String mdp;
    private int id;

   
    private String nom;
    private String ville;

 
    private String adresse;
    private int code_postal;
    private double avis;
    private int newAvis;
    private String telephone;
    private String num_fiscal;
    private String Ouverture;
    private String Fermeture;
    private int nbVote ;
    
    

    public Agence(int id, String nom, String ville, String adresse, int code_postal, double avis, int newAvis, String telephone, String num_fiscal, String ouverture ,String fermeture,int nbVote) {
        this.id = id;
        this.ville = ville;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.avis = avis;
        this.newAvis = newAvis;
        this.telephone = telephone;
        this.num_fiscal = num_fiscal;
        this.Ouverture = ouverture;
        this.Fermeture = fermeture;
        this.nbVote=nbVote;
    }

    public Agence() {
    }

    public Agence(String nom, String ville, String adresse, int code_postal, String telephone, String num_fiscal, String ouverture, String fermeture) {
        this.nom = nom;
        this.ville = ville;
        this.adresse = adresse;
        this.code_postal = code_postal;
        
        this.telephone = telephone;
        this.num_fiscal = num_fiscal;
        this.Ouverture = ouverture;
        this.Fermeture = fermeture;
    }
    public Agence(int id,String nom, String ville, String adresse, int code_postal, String telephone, String num_fiscal, String ouverture, String fermeture) {
       this.id=id;
        this.nom = nom;
        this.ville = ville;
        this.adresse = adresse;
        this.code_postal = code_postal;
        
        this.telephone = telephone;
        this.num_fiscal = num_fiscal;
        this.Ouverture = ouverture;
        this.Fermeture = fermeture;
    }
     public Agence(int id,String nom, String ville, String adresse, int code_postal, String telephone, String num_fiscal, String ouverture, String fermeture,int newAvis, int nbVote,double avis) {
       this.id=id;
        this.nom = nom;
        this.ville = ville;
        this.adresse = adresse;
        this.code_postal = code_postal;
        
        this.telephone = telephone;
        this.num_fiscal = num_fiscal;
        this.Ouverture = ouverture;
        this.Fermeture = fermeture;
        this.avis = avis;
        this.newAvis = newAvis;
        this.nbVote=nbVote;
    }

    public Agence(String email, String mdp, int id, String nom, String ville, String adresse, int code_postal, double avis, int newAvis, String telephone, String num_fiscal, String Ouverture, String Fermeture, int nbVote) {
        this.email = email;
        this.mdp = mdp;
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.avis = avis;
        this.newAvis = newAvis;
        this.telephone = telephone;
        this.num_fiscal = num_fiscal;
        this.Ouverture = Ouverture;
        this.Fermeture = Fermeture;
        this.nbVote = nbVote;
    }
    public Agence(double avis, int newAvis,int nbVote) {
        this.avis = avis;
        this.newAvis = newAvis;
        this.nbVote=nbVote;
    }
 public Agence(int id, String email, String mdp) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
    }
public Agence(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public Agence(int id) {
        this.id = id;
    }
    public Agence(String nom, String email, String mdp) {
        this.nom = nom;
      
        this.email = email;
        this.mdp = mdp;
    }
   

    public int getNbVote() {
        return nbVote;
    }

    public void setNbVote(int nbVote) {
        this.nbVote = nbVote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public double getAvis() {
        return avis;
    }

    public void setAvis(int avis) {
        this.avis = avis;
    }

    public int getNewAvis() {
        return newAvis;
    }

    public void setNewAvis(int newAvis) {
        this.newAvis = newAvis;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNum_fiscal() {
        return num_fiscal;
    }

    public void setNum_fiscal(String num_fiscal) {
        this.num_fiscal = num_fiscal;
    }

    public String getOuverture() {
        return Ouverture;
    }

    public void setOuverture(String Ouverture) {
        this.Ouverture = Ouverture;
    }

    public String getFermeture() {
        return Fermeture;
    }

    public void setFermeture(String Fermeture) {
        this.Fermeture = Fermeture;
    }
    
   public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


  

    

    
 public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAvis(double avis) {
        this.avis = avis;
    }

    public Agence(String ville) {
        this.ville = ville;
    }

   
 
    @Override
    public String toString() {
        return "Agence{" + "nom=" + nom + ", ville=" + ville + " adresse=" + adresse +"code_postal=" +code_postal + " telephone=" + telephone + " num_fiscal=" + num_fiscal + "ouverture=" + Ouverture + "fermeture=" + Fermeture +'}';
    }

   
    
}
