/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.entities.Client;
import com.codename1.uikit.cleanmodern.SignInForm;

import com.codename1.entities.Marque;
import com.codename1.entities.Modele;
import com.codename1.entities.Moniteur;
import com.codename1.entities.Type_v;
import com.codename1.entities.Vehicule;
import com.codename1.controllers.MarqueService;
import com.codename1.controllers.ModeleService;
import com.codename1.controllers.MoniteurService;
import com.codename1.controllers.Type_vService;
import com.codename1.controllers.VehiculeService;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.util.List;

/**
 *
 * @author USER
 */
public class AjouterVehicule {

    Form ajouterVehicule;
    Image img;

    public AjouterVehicule(Resources theme) {

        UIBuilder ui = new UIBuilder();
        ajouterVehicule = new Form("Ajouter Vehicule", BoxLayout.y());
        Toolbar.setGlobalToolbar(true);
        Container c = (Container) ui.findByName("container", ajouterVehicule);

        img = theme.getImage("back.png");
        Image img1 = img.scaled(16, 16);
        ajouterVehicule.getToolbar().addCommandToLeftBar("", img1, (e) -> {
            ListeVehicule l1 = new ListeVehicule(theme);
            l1.show();
        });

        img = theme.getImage("logout.png");
        Image img2 = img.scaled(16, 16);
        ajouterVehicule.getToolbar().addCommandToOverflowMenu("Logout", img2, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                SignInForm login = new SignInForm(theme);
                login.showBack();
            }
        });

        TextField tfMatricule = new TextField("", "matricule");
        Picker pdExp_assurance = new Picker();
        Picker pdExp_vignette = new Picker();
        Picker pdExp_visite = new Picker();

        ComboBox cbmar = new ComboBox();
        MarqueService ms = new MarqueService();
        List<Marque> ls = ms.getAll();
        for (Marque m : ls) {
            cbmar.addItem(m.getLibelle_ma());
        }

        ComboBox cbmod = new ComboBox();
        cbmod.setHint("Modele");
        cbmar.addActionListener((evt) -> {
            DefaultListModel dlm = (DefaultListModel) cbmod.getModel();
            dlm.removeAll();

            String marque = cbmar.getSelectedItem().toString();
            MarqueService vs1 = new MarqueService();

            Marque nv = ms.findByNom(marque);

            ModeleService mos = new ModeleService();
            List<Modele> ls1 = mos.findBynv(nv);

            for (Modele mod : ls1) {
                cbmod.addItem(mod.getLibelle_mo());

            }

        });

        ComboBox cbtpv = new ComboBox();
        Type_vService tps = new Type_vService();
        List<Type_v> lstv = tps.getAll();
        for (Type_v tp : lstv) {
            cbtpv.addItem(tp.getLibelle_t());
        }

        Label mat = new Label("Matricule");
        ajouterVehicule.add(mat);
        ajouterVehicule.add(tfMatricule);
        mat.setUIID("LabesGras");

        Label typ = new Label("Type Vehicule");
        ajouterVehicule.add(typ);
        ajouterVehicule.add(cbtpv);
        typ.setUIID("LabesGras");

        Label mar = new Label("Marque");
        ajouterVehicule.add(mar);
        ajouterVehicule.add(cbmar);
        mar.setUIID("LabesGras");

        Label mod = new Label("Modele");
        ajouterVehicule.add(mod);
        ajouterVehicule.add(cbmod);
        mod.setUIID("LabesGras");

        Label assur = new Label("Date expiration assurance");
        ajouterVehicule.add(assur);
        ajouterVehicule.add(pdExp_assurance);
        assur.setUIID("LabesGras");

        Label vign = new Label("Date expiration vignette");
        ajouterVehicule.add(vign);
        ajouterVehicule.add(pdExp_vignette);
        vign.setUIID("LabesGras");

        Label vis = new Label("Date expiration visite");
        ajouterVehicule.add(vis);
        ajouterVehicule.add(pdExp_visite);
        vis.setUIID("LabesGras");

        Button btnValider = new Button("Ajouter");
        ajouterVehicule.add(btnValider);
        btnValider.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                ConnectionRequest req = new ConnectionRequest();
                MarqueService mars = new MarqueService();
                Marque m = mars.findByNom(cbmar.getSelectedItem().toString());

                ModeleService mods = new ModeleService();
                Modele mode = mods.findByNom(cbmod.getSelectedItem().toString());

                Type_vService tpvs = new Type_vService();
                Type_v tp = tpvs.findByNom(cbtpv.getSelectedItem().toString());
                req.setUrl("http://localhost/KarhabtyService/Vehicule/insertVehicule.php?marque_id="
                        + 1
                        + "&modele_id=" + 1
                        + "&matricule=" + tfMatricule.getText()
                        + "&dExp_assurance=" + pdExp_assurance.getDate()
                        + "&dExp_vignette=" + pdExp_vignette.getDate()
                        + "&dExp_visite=" + pdExp_visite.getDate()
                        + "&typeV_id=" + 1 + "");

                System.out.println("");
                ToastBar.showErrorMessage("Un vehicule a ete ajouter avec succus !!!");
                ListeVehicule l1 = new ListeVehicule(theme);
                l1.show();


                NetworkManager.getInstance().addToQueue(req);

            }

        });

        ajouterVehicule.show();

    }

    public Form getAjouterVehicule() {
        return ajouterVehicule;
    }

    public void setAjouterVehicule(Form ajouterVehicule) {
        this.ajouterVehicule = ajouterVehicule;
    }

    public void show() {

        ajouterVehicule.show();
    }
}
