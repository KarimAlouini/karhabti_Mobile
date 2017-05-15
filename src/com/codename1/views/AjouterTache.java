/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.entities.Client;
import com.codename1.entities.Marque;
import com.codename1.entities.Modele;
import com.codename1.entities.Moniteur;
import com.codename1.entities.Type_v;
import com.codename1.entities.Vehicule;
import com.codename1.controllers.ClientService;
import com.codename1.controllers.MarqueService;
import com.codename1.controllers.ModeleService;
import com.codename1.controllers.MoniteurService;
import com.codename1.controllers.Type_vService;
import com.codename1.controllers.VehiculeService;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
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
import com.codename1.uikit.cleanmodern.BaseForm;
import java.util.List;

/**
 *
 * @author USER
 */
public class AjouterTache extends BaseForm {
    Form ajouterTache;
    Image img;

    public AjouterTache(Resources theme) {

        UIBuilder ui = new UIBuilder();
        //ajouterTache = new Form("Ajouter Vehicule", BoxLayout.y());
        Toolbar.setGlobalToolbar(true);
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        img = theme.getImage("back.png");
        Image img1 = img.scaled(16, 16);
        ajouterTache.getToolbar().addCommandToLeftBar("", img1, (e) -> {
            ListeVehicule l1 = new ListeVehicule(theme);
            l1.show();
        });

        img = theme.getImage("logout.png");
        Image img2 = img.scaled(16, 16);
//        //ajouterTache.getToolbar().addCommandToOverflowMenu("Logout", img2, new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//              //  LoginForm login = new LoginForm(theme);
//              //  login.getF().showBack();
//            }
//        });

        Picker pdat = new Picker();

        ComboBox cbcli = new ComboBox();
        ClientService cs = new ClientService();
        List<Client> ls = cs.getAll();
        
        for (Client cl : ls) {
            cbcli.addItem(cl.getNom());
        }

        

        ComboBox cbmon = new ComboBox();
        MoniteurService mos = new MoniteurService();
        List<Moniteur> lsmo = mos.getAll();
        
        for (Moniteur mon : lsmo) {
            cbmon.addItem(mon.getNom());
        }
        
//        ComboBox cbvec = new ComboBox();
//        VehiculeService vehi = new VehiculeService();
//        List<Vehicule> lstv = vehi.getAll1();
//        
//        for (Vehicule vec : lstv) {
//            cbvec.addItem(vec.getMatricule());
//        }

        

        Label typ = new Label("Client");
        add(typ);
        add(cbcli);
        //typ.setUIID("LabesGras");

        Label mar = new Label("Moniteur");
        add(mar);
        add(cbmon);
      //  mar.setUIID("LabesGras");

//        Label mod = new Label("Vehicule");
//        ajouterTache.add(mod);
//        ajouterTache.add(cbvec);
//        mod.setUIID("LabesGras");

        Label dat = new Label("Date ");
        add(dat);
        add(pdat);
        //dat.setUIID("LabesGras");

        Button btnValider = new Button("Ajouter");
        add(btnValider);
        btnValider.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                ConnectionRequest req = new ConnectionRequest();
//                MarqueService mars = new MarqueService();
//                Marque m = mars.findByNom(cbmar.getSelectedItem().toString());
//
//                ModeleService mods = new ModeleService();
//                Modele mode = mods.findByNom(cbmod.getSelectedItem().toString());
//
//                Type_vService tpvs = new Type_vService();
//                Type_v tp = tpvs.findByNom(cbtpv.getSelectedItem().toString());
                req.setUrl("http://localhost/KarhabtyService/Tache/insertTache.php?vehicule_id="
                        + 4
                        + "&client_id=" + 1
                        + "&moniteur_id=" + 1
                        + "&date=" + pdat.getDate()+ "");

                System.out.println("");
                ToastBar.showErrorMessage("Une Tache a ete ajouter avec succus !!!");
                ListeTaches l1 = new ListeTaches(theme);
                l1.show();
//              

                NetworkManager.getInstance().addToQueue(req);

            }

        });

  

//    }
//
//    public Form getAjouterVehicule() {
//        return ajouterTache;
//    }
//
//    public void setAjouterVehicule(Form ajouterTache) {
//        this.ajouterTache = ajouterTache;
//    }
//
//    public void show() {
//
//        ajouterTache.show();
//    }
    }  
}
