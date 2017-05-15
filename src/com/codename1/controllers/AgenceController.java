/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.controllers;

import com.codename1.entities.Agence;
import com.codename1.entities.Cours;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.views.AfficherCours;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class AgenceController {
    
     public void insertAgence(TextField nom, ComboBox ville,TextField adresse,TextField code_postal,TextField telephone,TextField num_fiscal,ComboBox ouverture,ComboBox fermeture, Resources res) {
        ConnectionRequest con = new ConnectionRequest();
         con.setUrl("http://localhost/karhabti/insert_agence.php?nom=" + nom.getText() + "&ville="+ville.getSelectedItem()+ "&adresse=" + adresse.getText()+ "&code_postal=" + code_postal.getText()+ "&telephone=" + telephone.getText() +"&num_fiscal=" + num_fiscal.getText() +"&Ouverture="+ouverture.getSelectedItem()+"&Fermeture=" + fermeture.getSelectedItem()); 
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);

                if (s.equals("success")) {
                    new AfficherCours(res).showBack();

                }
            }
        });
        NetworkManager.getInstance().addToQueue(con);
    }
    
      public void deleteAgence(Agence a) {
       ConnectionRequest con = new ConnectionRequest();
       con.setUrl("http://localhost/karhabti/delete_Agence.php?id=" +a.getId()+""  );
        con.addResponseListener(new ActionListener<NetworkEvent>() {
           @Override
           public void actionPerformed(NetworkEvent evt) {
               byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);

                if (s.equals("success")) {
                    Dialog.show("Suppression", "Agences supprmié avec succes", "Ok", null);
                   
                }
           }
       });
         NetworkManager.getInstance().addToQueue(con);
         
        
    }

  

    
    

}
