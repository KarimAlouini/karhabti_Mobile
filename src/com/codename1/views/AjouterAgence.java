/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.views;

import com.codename1.components.ToastBar;
import com.codename1.controllers.AgenceController;
import com.codename1.controllers.CoursController;
import com.codename1.googlemaps.MapContainer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.maps.Coord;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.BaseForm;

/**
 *
 * @author USER
 */
public class AjouterAgence extends BaseForm{
    
    
      private MapContainer.MapObject marker;

       private Coord latLng;
       public void geoCode(){
        String url = ("https://maps.googleapis.com/maps/api/geocode/json"
                + "?latlng="+latLng.getLatitude()+","+latLng.getLongitude()
                + "&key=AIzaSyDUiPfabJtrpjjj1Ix1vBsl1fKG_kzmeMw");
        ConnectionRequest request= new ConnectionRequest(url);
        request.setPost(false);
        request.addResponseListener((evt)->{
            System.out.println(new String(request.getResponseData()));
        });
        NetworkManager.getInstance().addToQueue(request);
    }


    public AjouterAgence(Resources res) {
       
        super("Insert", BoxLayout.y());
         Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Newsfeed");
       
       
        getContentPane().setScrollVisible(false);
        
        
         
        TextField tfName = new TextField("", "nom");
        TextField tfAdresse = new TextField("", "adresse");
        ComboBox tville = new ComboBox("Tunis","Mannouba","Kairouan","Sousse","Nabeul","Tozeur","Gabès","Le Kef","Mednine",
        "Gafssa","Gassrine","Sidi Bouzid","Siliana","Jandouba","Beja","Bizert","Mahdia","Ben arous","Tataouine");
        TextField tfCode_postal = new TextField("", "code_postal");
        TextField tfNum_fiscal = new TextField("", "num_fiscal");
        TextField tfNum = new TextField("", "telephone");
        ComboBox ouverture = new ComboBox("Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi");
        ComboBox fermeture = new ComboBox("Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi");
         add(tfName);
         add(tville);
         add(tfAdresse);
         add(tfCode_postal);
         add(tfNum);
         add(tfNum_fiscal);
         add(ouverture);
         add(fermeture);
         
//         final MapContainer cnt = new MapContainer();
//        Style s = new Style();
//        s.setFgColor(0xff0000);
//        s.setBgTransparency(0);
//        FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(3));
//        cnt.addTapListener(e -> {
//            if (marker!=null){
//                cnt.removeMapObject(marker);
//            }
//            latLng=cnt.getCoordAtPosition(e.getX(), e.getY());
//            geoCode();
//            marker= cnt.addMarker(
//                    EncodedImage.createFromImage(markerImg, false),
//                    cnt.getCoordAtPosition(e.getX(), e.getY()),
//                    "",
//                    "",
//                    e3 -> {
//                        ToastBar.showMessage("You clicked " + "", FontImage.MATERIAL_PLACE);
//                    }
//            );
//
//        });
final MapContainer cnt = new MapContainer();
        Style s = new Style();
        s.setFgColor(0xff0000);
        s.setBgTransparency(0);
        FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(3));
        cnt.addTapListener(e -> {
            if (marker!=null){
                cnt.removeMapObject(marker);
            }
            latLng=cnt.getCoordAtPosition(e.getX(), e.getY());
            geoCode();
            marker= cnt.addMarker(
                    EncodedImage.createFromImage(markerImg, false),
                    cnt.getCoordAtPosition(e.getX(), e.getY()),
                    "",
                    "",
                    e3 -> {
                        ToastBar.showMessage("You clicked " + "", FontImage.MATERIAL_PLACE);
                    }
            );

        });

        Container root = LayeredLayout.encloseIn(
                BorderLayout.center(cnt)
        );
        add(root);
         Button btnValider = new Button("Ajouter");
         add(btnValider);
      btnValider.addActionListener(new ActionListener() {
       
          
    

            public void actionPerformed(ActionEvent evt) {
 
                Double talt = latLng.getLatitude();
                Double tlong = latLng.getLongitude();
                ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/karhabti/wala/insert.php?nom=" + tfName.getText() + "&ville="+tville.getSelectedItem()+ "&adresse=" + tfAdresse.getText()+ "&code_postal=" + tfCode_postal.getText()+ "&telephone=" + tfNum.getText() +"&num_fiscal=" + tfNum_fiscal.getText() +"&Ouverture="+ouverture.getSelectedItem()+"&Fermeture=" + fermeture.getSelectedItem() + "&mail="+"wala.dhibi@esprit.tn"+  "&altitude=" + talt +"&longitude=" + tlong + "");

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);

                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "ajout ok", "Ok", null);
                        }
                        Message msg  = new  Message("agence ajoutée");
                        Display.getInstance().sendMessage(new String[] {"wala.dhibi@esprit.tn"}, "Subject of message", msg);
                        
                    }
                    
                });
                
                NetworkManager.getInstance().addToQueue(req);
                
              
            }
 });

        
//           Button btnAjouter = new Button("Ajouter");
//         add(btnAjouter);
//        AgenceController agencesc = new AgenceController();
//
//        btnAjouter.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//         agencesc.insertAgence(tfName,tville,tfAdresse,tfCode_postal,tfNum,tfNum_fiscal,ouverture,fermeture,res);
//                new AfficherAgence(res);            }
//            
//        });
    }
    
    
}
