/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.components.SpanLabel;
import com.codename1.controllers.AvisController;
import com.codename1.controllers.CoursController;
import com.codename1.entities.Avis_agence;
import com.codename1.entities.Cours;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.codename1.uikit.cleanmodern.ProfileForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class AfficherAvis extends BaseForm {

    public AfficherAvis(Resources res,String nom_agence ) {
        super("Gestion des Avis", BoxLayout.y());
        
         Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Gestion de cours");
        getContentPane().setScrollVisible(false);
        
//        super.addSideMenu(res);
//        tb.addSearchCommand(e -> {});
        
        AvisController avis = new AvisController();
        Container ctn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        add(ctn);
       
          Image img = res.getImage("profile-background.jpg");
          img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);

         ctn.add(img);
           super.addSideMenu(res);
        tb.addCommandToRightBar("Back",res.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new AjouterAvis(res).showBack();
            }
        });
                 ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/karhabti/wala/getAvisByNom.php?nom_agence= '"+nom_agence+"'");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                
             if (!getListAVis(new String(con.getResponseData())).equals("{}"))
             {
                 System.out.println("---------------- liste n est pas vide ");
             }
      for (Avis_agence a : getListAVis(new String(con.getResponseData())))
                 {
                     Container c1 = new Container(BoxLayout.x());
                     Container c2 = new Container(BoxLayout.y());
                      Label nom = new Label("nom : "+a.getNom());
                       Label mail = new Label("mail : "+a.getMail());
                       Label comment = new Label(" commentaire : "+a.getComment());
                       Label sep = new Label("______________________________");
                    add(nom)
                           .add(mail).add(comment).add(sep);
                  
                 }  
            }
        });
        NetworkManager.getInstance().addToQueue(con);
    }

    
    
    public ArrayList<Avis_agence> getListAVis(String json) {
        ArrayList<Avis_agence> listAvis = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();
            Map<String, Object> avisAgences = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) avisAgences.get("avis_agence");
           for (Map<String, Object> obj : list) {
                Avis_agence a = new Avis_agence();
              a.setNom(obj.get("nom").toString());
              a.setMail(obj.get("mail").toString());
              a.setComment(obj.get("comment").toString());
                
                listAvis.add(a);
            }

        } catch (IOException ex) {
         }
        return listAvis;
     
    }
    
    }
    
    

