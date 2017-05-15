///*
// * Copyright (c) 2016, Codename One
// *
// * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
// * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
// * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
// * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
// *
// * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
// * of the Software.
// *
// * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
// * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
// * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
// * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
// * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
// * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
// */
//
//package com.codename1.views;
//
//import com.codename1.components.FloatingHint;
//import com.codename1.components.SpanLabel;
//import com.codename1.components.ToastBar;
//import com.codename1.entities.Offre;
//import com.codename1.io.CharArrayReader;
//import com.codename1.io.ConnectionRequest;
//import com.codename1.io.JSONParser;
//import com.codename1.io.NetworkEvent;
//import com.codename1.io.NetworkManager;
//import com.codename1.messaging.Message;
//import com.codename1.ui.Button;
//import com.codename1.ui.Container;
//import com.codename1.ui.Display;
//import com.codename1.ui.Form;
//import com.codename1.ui.Label;
//import com.codename1.ui.TextField;
//import com.codename1.ui.Toolbar;
//import com.codename1.ui.events.ActionListener;
//import com.codename1.ui.layouts.BorderLayout;
//import com.codename1.ui.layouts.BoxLayout;
//import com.codename1.ui.layouts.FlowLayout;
//import com.codename1.ui.util.Resources;
//import com.codename1.uikit.cleanmodern.BaseForm;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * Account activation UI
// *
// * @author Shai Almog
// */
//public class ActivateForm extends BaseForm {
//public static Offre userCon;
//public static int Prix_total;
//
//    public ActivateForm(Resources res ,String title) {
//         
//        super(new BorderLayout());
//        
//        TextField code = new TextField("", "Entrer Nbr d'heureCode", 20, TextField.CENTER);
//        TextField conduite = new TextField("", "Entrer Nbr d'heureConduite", 20, TextField.CENTER);
//        
//        
//        
//        
//        code.addActionListener(e->{
//            
//            
//        ConnectionRequest req = new ConnectionRequest();
//         req.setUrl("http://localhost/cno/RechercherOffreByNom.php?nom=" +title);
//         
//         
//          req.addResponseListener(new ActionListener<NetworkEvent>() {
//
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                
//                byte[] data = (byte[]) evt.getMetaData();
//                        String s = new String(data);
//                
//                       userCon = getOffre(s);
//                       System.out.println(userCon.prix_ucode);
//                
//            }
//          
//              
//          });
//           NetworkManager.getInstance().addToQueue(req);
//          
//       });   
//         
//         
//        
//       
//        
//        
//        
//        
//        
//        Toolbar tb = new Toolbar(true);
//        setToolbar(tb);
//        tb.setUIID("Container");
//        getTitleArea().setUIID("Container");
//        Form previous = Display.getInstance().getCurrent();
//        tb.setBackCommand("", e -> previous.showBack());
//        setUIID("Activate");
//        
//        add(BorderLayout.NORTH, 
//                BoxLayout.encloseY(
//                        new Label(res.getImage("smily.png"), "LogoLabel"),
//                        new Label(title, "LogoLabel")
//                )
//        );
//        
//        
//        code.setSingleLineTextArea(false);
//        Button facture = new Button("Voir Facture");
//     
//      
//        
//      
//   
//        
//        Container content = BoxLayout.encloseY(
//                new FloatingHint(code),
//                createLineSeparator(),
//                new FloatingHint(conduite),
//                createLineSeparator(),
//                new SpanLabel("Veuillez Saisir Nombre d'heure de code et de conduite Souhaitee", "CenterLabel"),
//                
//                facture
//               
//        );
//        content.setScrollableY(true);
//        add(BorderLayout.SOUTH, content);
//        facture.requestFocus();
//           
//        
//        facture.addActionListener(e->{
//             int hc=0;
//                int hb=0;
//                
//     
//                      
//if (verifOnlyNumber(code.getText())== true && verifOnlyNumber(conduite.getText()))
//{
//                hc = userCon.getPrix_ucode();
//                hb = userCon.getPrix_uconduite();
//                
//                
//                 int nbrHc = Integer.parseInt(code.getText()) ;
//                 int nbrHb = Integer.parseInt(conduite.getText()) ;
//                 
//                Prix_total=(((hc*nbrHc) + (nbrHb*hb)));
//                
//                
//                System.out.println(Prix_total);
//                
//                new ReservationOffreForm(res, Prix_total , userCon,nbrHc,nbrHb).toString();
//}
//else
//{
//    ToastBar.Status status = ToastBar.getInstance().createStatus();
//                            status.setMessage("sauf des heurs entre 8h et 40h");
//                            status.showDelayed(30); 
//}
//        });
//        
//       
//    }
//    
//     public Offre getOffre(String json) {
//        ArrayList<Offre> listOffre = new ArrayList<>();
//
//        try {
//
//            JSONParser j = new JSONParser();
//
//            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
//
//            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("offre");
//
//            for (Map<String, Object> obj : list) {
//                Offre u = new Offre();
//                System.out.println("aaaaaaaaaaaaaaaaaaaaaa"+Integer.parseInt(obj.get("prix_ucode").toString()));
//                u.setId(Integer.parseInt(obj.get("id").toString()));
//                u.setNom(obj.get("nom").toString());
//                u.setPrix_ucode(Integer.parseInt(obj.get("prix_ucode").toString()));  
//                u.setPrix_uconduite(Integer.parseInt(obj.get("prix_uconduite").toString()));
//               
//                listOffre.add(u);
//                
//
//            }
//
//        } catch (IOException ex) {
//        }
//       
//        return listOffre.get(0);
//
//    }
//     public boolean verifOnlyNumber(String chaine) {
//        try{
//             int h =Integer.parseInt(chaine);
//             if(h>8 && h<40)
//             {
//                 return true;
//             }
//             else
//             {
//                return false; 
//             }
//            
//        }
//        catch (Exception e)
//        {
//            return false;
//        }
//          
//    }
//    
//}
