/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.components.ToastBar;
import com.codename1.controllers.CoursController;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;

/**
 *
 * @author USER
 */
public class AjouterCours extends BaseForm {

    public AjouterCours(Resources res) {
        super("Insert", BoxLayout.y());
       
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Newsfeed");
       
       
        getContentPane().setScrollVisible(false);
        
//        super.addSideMenu(res);
//        tb.addSearchCommand(e -> {});
//        
        
          
        TextField tftitre = new TextField("", "titre");
        TextField tfcontenue = new TextField("", "contenue");
        ComboBox ctype = new ComboBox("", "Taxis" , "Autobus" , "Poids lourds" , "Voiture");
      
        add(tftitre);
        add(tfcontenue);
        add(ctype);
       
        Button btnAjouter = new Button("Ajouter");
         add(btnAjouter);
        CoursController coursc = new CoursController();

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
         coursc.insertCours(tftitre,tfcontenue,ctype,res);
                new AfficherCours(res);            }
            
        });
    }

    }


