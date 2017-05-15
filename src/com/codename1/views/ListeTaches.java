/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.controllers.TacheService;
import com.codename1.components.SpanLabel;
import com.codename1.controllers.AgenceController;
import com.codename1.entities.Tache;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.codename1.uikit.cleanmodern.BaseForm;

/**
 *
 * @author USER
 */
public class ListeTaches extends BaseForm {

    // Form f;
    EncodedImage encoded;
    Image img;

    public ListeTaches(Resources theme) {
        super("Gestion des Agences", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
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

        UIBuilder ui = new UIBuilder();
        // f = new Form("LISTE DES TACHES", BoxLayout.y());
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

        img = theme.getImage("logout.png");
        Image img2 = img.scaled(16, 16);

        img = theme.getImage("video.png");
        Image video = img.scaled(16, 16);

        img = theme.getImage("add.png");
        Image img1 = img.scaled(16, 16);

        SpanLabel sp = new SpanLabel();
        add(sp);

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Tache/selectTache.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                TacheService ts = new TacheService();

                try {
                    for (Tache t : ts.getListTache(new String(con.getResponseData()))) {
                        Container page = new Container(BoxLayout.y());
                        Container tachex = new Container(BoxLayout.x());
                        Container tache = new Container(BoxLayout.y());
                        Container tachelib = new Container(BoxLayout.y());
                        Label client = new Label("" + t.getClient());
                        Label moniteur = new Label("" + t.getMoniteur());
                        Label vehicule = new Label("" + t.getVehicule());

                        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MMMM-dd");

                        String date1 = formatter1.format(t.getDate());
                        Label date = new Label("" + date1);
                        Button btnSup = new Button("Supprimer");

                        Label cli = new Label("Client : ");
                        tachelib.add(cli);
                        tache.add(client);

                        Label mon = new Label("Moniteur : ");
                        tachelib.add(mon);
                        tache.add(moniteur);

                        Label veh = new Label("Vehicule : ");
                        tachelib.add(veh);
                        tache.add(vehicule);

                        Label dat = new Label("Date : ");
                        tachelib.add(dat);
                        tache.add(date);
                        tachex.add(tachelib).add(tache);

                        SwipeableContainer sc = new SwipeableContainer(
                                null, GridLayout.encloseIn(1, btnSup),
                                page);

                        page.add(tachex);
                        add(sc);
                        refreshTheme();
                    }
                } catch (ParseException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueue(con);
        
        
    }

}
