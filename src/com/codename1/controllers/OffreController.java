/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.controllers;

import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.codename1.entities.Offre;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.codename1.views.AfficherCours;

/**
 *
 * @author USER
 */
public class OffreController {

    public void insertOffre(TextField tfnom, TextField tfpcode, TextField tfpconduite, TextField tfdes, Resources res) {
       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codenameone/insert.php?nom=" + tfnom.getText() + "&prix_ucode=" + tfpcode.getText()+ "&prix_uconduite=" + tfpconduite.getText() + "&description=" + tfdes.getText() +"");
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
        
    

    public void deletecours(Offre o) {
        ConnectionRequest con = new ConnectionRequest();
       con.setUrl("http://localhost/karhabti/islem/remove.php?nom=" +o.getNom()+""  );
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
