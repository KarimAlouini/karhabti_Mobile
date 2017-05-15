/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.controllers;

import com.codename1.entities.Moniteur;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class MoniteurService {

    List<Moniteur> listMoniteurs = new ArrayList();
    Moniteur mon = new Moniteur();

    public Moniteur findMoniteurById(Integer id) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Moniteur/SelectMoniteurById.php?id=" + id + "");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                mon = getOneMoniteur(new String(con.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return mon;
    }

    public Moniteur getOneMoniteur(String json) {
        Moniteur moni = new Moniteur();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> moniteurs = j.parseJSON(new CharArrayReader(json.toCharArray()));
            Map<String, Object> obj = (Map<String, Object>) moniteurs.get("moniteur");

            moni.setId(Integer.parseInt(obj.get("id").toString()));
            moni.setNom(obj.get("nom").toString());

        } catch (IOException ex) {
        }

        return moni;

    }
    
    public List<Moniteur> getAll() {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Moniteur/SelectMoniteur.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                try{
                listMoniteurs = getListMoniteur(new String(con.getResponseData()));
                }catch(Exception e){
                    mon = getOneMoniteur(new String(con.getResponseData()));
                    listMoniteurs.add(mon);
                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return listMoniteurs;

    }
    
    public ArrayList<Moniteur> getListMoniteur(String json) {
        ArrayList<Moniteur> listMoniteur = new ArrayList<Moniteur>();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> moniteurs = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) moniteurs.get("moniteur");

            for (Map<String, Object> obj : list) {
                Moniteur m = new Moniteur();
                m.setId(Integer.parseInt(obj.get("id").toString()));
                m.setNom(obj.get("nom").toString());

                listMoniteur.add(m);

            }

        } catch (IOException ex) {
        }

        return listMoniteur;

    }

}
