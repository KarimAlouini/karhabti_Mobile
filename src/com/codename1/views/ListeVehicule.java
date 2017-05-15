/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.entities.Vehicule;
import com.codename1.controllers.VehiculeService;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.controllers.AgenceController;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;

/**
 *
 * @author USER
 */
public class ListeVehicule extends BaseForm {

    //  Form f;
    EncodedImage enc1;
    Image img;

    public ListeVehicule(Resources theme) {
        super("Gestion des Agences", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Gestion de cours");
        getContentPane().setScrollVisible(false);

//        super.addSideMenu(res);
//        tb.addSearchCommand(e -> {});
        AgenceController agence = new AgenceController();
        Container ctn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        add(ctn);
        Image img = theme.getImage("profile-background.jpg");
        img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 2);

        ctn.add(img);
        super.addSideMenu(theme);

        //  UIBuilder ui = new UIBuilder();
        //  f = new Form("LISTE DES VEHICULES", BoxLayout.y());
        img = theme.getImage("profil.png");
        Image profil = img.scaled(16, 16);

        img = theme.getImage("offre.png");
        Image offre = img.scaled(16, 16);

        img = theme.getImage("vehicule.png");
        Image vehicule = img.scaled(16, 16);

        img = theme.getImage("moniteur.png");
        Image moniteur = img.scaled(16, 16);

        img = theme.getImage("tache.png");
        Image tache = img.scaled(16, 16);

        img = theme.getImage("exam.png");
        Image exam = img.scaled(16, 16);

        img = theme.getImage("contact.png");
        Image contact = img.scaled(16, 16);

        img = theme.getImage("video.png");
        Image video = img.scaled(16, 16);

        //  f.getToolbar().addCommandToSideMenu("   Profil", profil, null);
        //  f.getToolbar().addCommandToSideMenu("   Offre/Pack", offre, null);
//        f.getToolbar().addCommandToSideMenu("   Vehicules", vehicule, new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                ListeVehicule list = new ListeVehicule(theme);
//                list.getF().show();
//
//            }
//        });
        //  f.getToolbar().addCommandToSideMenu("   Moniteur", moniteur, null);
//        f.getToolbar().addCommandToSideMenu("   Planning", tache, new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                ListeTaches listtache = new ListeTaches(theme);
//                listtache.getF().show();
//
//            }
//        });
        // f.getToolbar().addCommandToSideMenu("   Cour/Examen", exam, null);
        img = theme.getImage("add.png");
        Image img1 = img.scaled(16, 16);
        img = theme.getImage("logout.png");
        Image img2 = img.scaled(16, 16);

//       
        SpanLabel sp = new SpanLabel();
        add(sp);

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Vehicule/selectVehicule.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                VehiculeService vs = new VehiculeService();

                try {
                    for (Vehicule v : vs.getListVehicule(new String(con.getResponseData()))) {

                        Container cimlis = new Container(BoxLayout.x());
                        Container cveh = new Container(BoxLayout.y());
                        Container cmodmar = new Container(BoxLayout.x());
                        Container clis1 = new Container(BoxLayout.y());
                        Container clis2 = new Container(BoxLayout.y());

                        Button btnSup = new Button("Supprimer");

                        Label mar = new Label("Marque : ");
                        Label mod = new Label("Modele : ");
                        Label tv = new Label("Type vehicule : ");

                        Label marque = new Label("" + v.getMarque().toString());
                        Label modele = new Label("" + v.getModele().toString());
                        Label matricule = new Label("" + v.getMatricule());
                        matricule.setUIID("textCouleur");
                        Label typev = new Label("" + v.getType_v());

                        if ("Voiture".equals(v.getType_v().getLibelle_t())) {
                            Image img = theme.getImage("car.png");
                            Image img1 = img.scaled(128, 128);
                            ImageViewer imgv = new ImageViewer(img1);
                            cimlis.add(imgv);
                        } else if ("Bus".equals(v.getType_v().getLibelle_t())) {
                            Image img = theme.getImage("bus.png");
                            Image img1 = img.scaled(128, 128);
                            ImageViewer imgv = new ImageViewer(img1);
                            cimlis.add(imgv);
                        } else if ("Pois Lourd".equals(v.getType_v().getLibelle_t())) {
                            Image img = theme.getImage("camion.png");
                            Image img1 = img.scaled(128, 128);
                            ImageViewer imgv = new ImageViewer(img1);
                            cimlis.add(imgv);
                        } else if ("Moto".equals(v.getType_v().getLibelle_t())) {
                            Image img = theme.getImage("moto.png");
                            Image img1 = img.scaled(128, 128);
                            ImageViewer imgv = new ImageViewer(img1);
                            cimlis.add(imgv);
                        }

                        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MMMM-dd");

                        String assurance = formatter1.format(v.getdExp_assurance());
                        Label assur = new Label("Date Expiration assurance : ");
                        Label dExp_assurance = new Label("" + assurance);

                        String vignette = formatter1.format(v.getdExp_vignette());
                        Label vign = new Label("Date Expiration vignette : ");
                        Label dExp_vignette = new Label("" + vignette);

                        String visite = formatter1.format(v.getdExp_visite());
                        Label vis = new Label("Date Expiration visite : ");
                        Label dExp_visite = new Label("" + visite);

                        SwipeableContainer sc = new SwipeableContainer(
                                null, GridLayout.encloseIn(1, btnSup),
                                cimlis);

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


//                        cimlis.addPointerDraggedListener(e -> {
//                            DetailVehicule l1 = new DetailVehicule(v);
//                            l1.getF().show();
//                        });
                        btnSup.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                ConnectionRequest req = new ConnectionRequest();
                                req.setUrl("http://localhost/KarhabtyService/Vehicule/deleteVehicule.php?matricule=" + v.getMatricule() + "");
                                NetworkManager.getInstance().addToQueue(req);

                                Dialog d = new Dialog();

                                if (Dialog.show("Confirmation", "Vehicule supprmier avec succes", "Ok", null)) {
                                    // new Supprimer().SuppVehicule(v);
                                } else {
                                    Dialog.show("ERROR", "DELETE FAILED", "Ok", null);
                                }
                            }
                        });

                        add(sc);
                        // refreshTheme();
                    }

                } catch (ParseException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueue(con);
    }

//    public Form getF() {
//        return f;
//    }
//
//    public void show() {
//
//        f.show();
//    }
}
