/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.controllers;

import com.codename1.entities.Marque;
import com.codename1.entities.Modele;
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
public class ModeleService {

    List<Modele> listModeles = new ArrayList();
    Modele mod = new Modele();

    public Modele findModById(Integer id) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Modele/SelectModeleById.php?id=" + id + "");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                mod = getOneModele(new String(con.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return mod;
    }
    
    public List<Modele> findBynv(Marque mar) {

        ConnectionRequest con = new ConnectionRequest();
        System.out.println(mar.getLibelle_ma());
        con.setUrl("http://localhost/KarhabtyService/Modele/SelectModeleByMarque.php?marque=" + mar.getId() + "");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    listModeles = getListModele(new String(con.getResponseData()));
                } catch (Exception e) {
                    mod = getOneModele(new String(con.getResponseData()));
                    listModeles.add(mod);
                }

            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return listModeles;

    }

    public Modele findByNom(String libelle_mo) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Modele/SelectModeleByNom.php?libelle_mo=" + libelle_mo + "");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                mod = getOneModele(new String(con.getResponseData()));

            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);

        return mod;
    }

    public ArrayList<Modele> getListModele(String json) {
        ArrayList<Modele> listModele = new ArrayList<Modele>();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> modeles = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) modeles.get("modele");

            for (Map<String, Object> obj : list) {
                Modele mo = new Modele();
                mo.setId(Integer.parseInt(obj.get("id").toString()));
                mo.setLibelle_mo(obj.get("libelle_mo").toString());

                listModele.add(mo);

            }

        } catch (Exception ex) {
            System.out.println("Pas de modele pour cette marque");

        }

        return listModele;

    }

    public Modele getOneModele(String json) {
        Modele mo = new Modele();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> modeles = j.parseJSON(new CharArrayReader(json.toCharArray()));
            Map<String, Object> obj = (Map<String, Object>) modeles.get("modele");

            mo.setId(Integer.parseInt(obj.get("id").toString()));
            mo.setLibelle_mo(obj.get("libelle_mo").toString());

        } catch (IOException ex) {
        }

        return mo;

    }

}
