/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.components.SpanLabel;
import com.codename1.controllers.AgenceController;
import com.codename1.entities.Agence;
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
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
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
public class rechercherAgence extends BaseForm {
       
    TextField  tfNom ;
    public rechercherAgence(Resources res, String nom) {
        super("rechercher", BoxLayout.y());
         Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Newsfeed");
         AgenceController agence = new AgenceController();
        Container ctn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        add(ctn);
       
          Image img = res.getImage("profile-background.jpg");
          img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
          
            
    TextField tfNom = new TextField("", "nom");
     
    Button btnOk = new Button("Rechercher");
    add(tfNom);
    add(btnOk);
     btnOk.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent evt) {
       listeAg agence = new listeAg(res, tfNom.getText());
        agence.show();
         }
     });
       
 }
  public TextField getTfNom() {
        return tfNom;
    }
  
}
        
    

   

    

