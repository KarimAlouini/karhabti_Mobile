/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.entities.Agence;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class listeAg extends BaseForm {

    public listeAg(Resources res,String nom ) {
        super("Gestion des Agences", BoxLayout.y());
        
         ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/code/getAgenceByName.php?nom= '"+nom+"'");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                
            
           for (Agence a : getListAgence(new String(con.getResponseData())))
                 {
                     
                        
                    Label nom = new Label("nom : "+a.getNom());
                        Label ville = new Label("ville : "+a.getVille());
                        Label adresse = new Label(" adresse : "+a.getAdresse());
                        Label code = new Label("code postal : "+a.getCode_postal());
                         Label tel = new Label("telephone : "+a.getTelephone());
                        Label num = new Label("numero fiscal : "+a.getNum_fiscal());
                        Label ouv = new Label(" Ouverture : "+a.getOuverture());
                        Label fer = new Label("Fermeture : "+a.getFermeture());
                         Label sep = new Label("______________________________");
                      add(nom).add(ville).add(adresse).add(code).add(tel).add(num).add(ouv).add(fer).add(sep);
               
               
                refreshTheme(); 
           
                 }  
            }
        });
        NetworkManager.getInstance().addToQueue(con);
    }

    
    
    public ArrayList<Agence> getListAgence(String json) {
        ArrayList<Agence> listAgences = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();
            Map<String, Object> agences = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) agences.get("agence");
           
            for (Map<String, Object> obj : list) {
                Agence a = new Agence();
                
               
                //e.setDatedebut(obj.get("datedebut"));
              // e.setDatefin((java.util.Date) obj.get("datefin"));
                a.setNom(obj.get("nom").toString());
                a.setVille(obj.get("ville").toString());
                a.setAdresse(obj.get("adresse").toString());
                a.setCode_postal(Integer.parseInt(obj.get("code_postal").toString()));
                a.setTelephone(obj.get("telephone").toString());
                a.setNum_fiscal(obj.get("num_fiscal").toString());
                a.setOuverture(obj.get("Ouverture").toString());
                a.setFermeture(obj.get("Fermeture").toString());
                listAgences.add(a);
            }

        } catch (IOException ex) {
         }
        return listAgences;
     }
    

    
 
    }
    
    

