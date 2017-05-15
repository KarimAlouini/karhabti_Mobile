/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.entities.Vehicule;
import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;

/**
 *
 * @author USER
 */
public class DetailVehicule {

    Form f;
    private Resources theme;

    public DetailVehicule(Vehicule v) {
        theme = UIManager.initFirstTheme("/theme");
        Image img;

        Container cimlis = new Container(BoxLayout.x());
        Container cveh = new Container(BoxLayout.y());
        Container cmodmar = new Container(BoxLayout.x());
        Container clis1 = new Container(BoxLayout.y());
        Container clis2 = new Container(BoxLayout.y());

        Label mar = new Label("Marque : ");
        mar.setUIID("textGras");
        Label mod = new Label("Modele : ");
        mod.setUIID("textGras");
        Label tv = new Label("Type vehicule : ");
        tv.setUIID("textGras");

        Label marque = new Label("" + v.getMarque().toString());
        Label modele = new Label("" + v.getModele().toString());
        Label matricule = new Label("" + v.getMatricule());
        matricule.setUIID("textCouleur");
        Label typev = new Label("" + v.getType_v());

        if ("Voiture".equals(v.getType_v().getLibelle_t())) {
            img = theme.getImage("car.png");
            Image img1 = img.scaled(128, 128);
            ImageViewer imgv = new ImageViewer(img1);
            cimlis.add(imgv);
        } else if ("Bus".equals(v.getType_v().getLibelle_t())) {
            img = theme.getImage("bus.png");
            Image img1 = img.scaled(128, 128);
            ImageViewer imgv = new ImageViewer(img1);
            cimlis.add(imgv);
        } else if ("Pois Lourd".equals(v.getType_v().getLibelle_t())) {
            img = theme.getImage("camion.png");
            Image img1 = img.scaled(128, 128);
            ImageViewer imgv = new ImageViewer(img1);
            cimlis.add(imgv);
        } else if ("Moto".equals(v.getType_v().getLibelle_t())) {
            img = theme.getImage("moto.png");
            Image img1 = img.scaled(128, 128);
            ImageViewer imgv = new ImageViewer(img1);
            cimlis.add(imgv);
        }

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MMMM-dd");

        String assurance = formatter1.format(v.getdExp_assurance());
        Label assur = new Label("Date Expiration assurance : ");
        assur.setUIID("textGras");
        Label dExp_assurance = new Label("" + assurance);

        String vignette = formatter1.format(v.getdExp_vignette());
        Label vign = new Label("Date Expiration vignette : ");
        vign.setUIID("textGras");
        Label dExp_vignette = new Label("" + vignette);

        String visite = formatter1.format(v.getdExp_visite());
        Label vis = new Label("Date Expiration visite : ");
        vis.setUIID("textGras");
        Label dExp_visite = new Label("" + visite);

        cveh.add(matricule);

        clis1.add(tv);
        clis1.add(mar);
        clis1.add(mod);

        clis2.add(typev);
        clis2.add(marque);
        clis2.add(modele);
        cmodmar.add(clis1).add(clis2);
        cveh.add(cmodmar);

        cveh.add(assur);
        cveh.add(dExp_assurance);
        cveh.add(vign);
        cveh.add(dExp_vignette);
        cveh.add(vis);
        cveh.add(dExp_visite);

        cimlis.add(cveh);

//        cimlis.setUIID("element");

        

        f.add(assur);
        f.refreshTheme();
//        f.setUIID("background");

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public void show() {

        f.show();
    }

}
