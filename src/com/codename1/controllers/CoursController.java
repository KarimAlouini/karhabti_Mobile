/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.controllers;

import com.codename1.entities.Cours;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.views.AfficherCours;
/**
 *
 * @author USER
 */
public class CoursController {
    
    
    public void insertCours(TextField titre, TextField contenue, ComboBox type, Resources res) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/karhabti/aicha/insert.php?titre=" + titre.getText()+"&permis="+type.getSelectedItem()+"&contenue=" + contenue.getText()+"");
        
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
    
    
    public void updateCours(TextField titre, TextField contenue, ComboBox type,Cours c) {
          ConnectionRequest con = new ConnectionRequest();
          
          con.setUrl("http://localhost/karhabti/aicha/update.php?titre=" +titre+"&contenue=" +contenue+"&permis="+type+"id=" +c.getId()+""  );
          
          con.addResponseListener(new ActionListener<NetworkEvent>() {
              @Override
              public void actionPerformed(NetworkEvent evt) {
                 byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);

                if (s.equals("success")) {
                    Dialog.show("Confirmation", "Cours modifié avec succes", "Ok", null);
                }
              }
          });
           NetworkManager.getInstance().addToQueue(con);
    }

  

    public void deletecours(Cours c) {
       ConnectionRequest con = new ConnectionRequest();
       con.setUrl("http://localhost/karhabti/aicha/remove.php?id=" +c.getId()+""  );
        con.addResponseListener(new ActionListener<NetworkEvent>() {
           @Override
           public void actionPerformed(NetworkEvent evt) {
               byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);

                if (s.equals("success")) {
                    Dialog.show("Suppression", "Cours supprmié avec succes", "Ok", null);
                   
                }
           }
       });
         NetworkManager.getInstance().addToQueue(con);
    }

   
}
