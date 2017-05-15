/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.controllers;

import com.codename1.entities.Vehicule;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class VehiculeService {

    MarqueService marser = new MarqueService();
    ModeleService modser = new ModeleService();
    Type_vService typvser = new Type_vService();
    Vehicule veh = new Vehicule();
    List<Vehicule> listVehicules = new ArrayList();

    public ArrayList<Vehicule> getListVehicule(String json) throws ParseException {
        ArrayList<Vehicule> listVehicules = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();
            Map<String, Object> vehicules = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) vehicules.get("vehicule");

            for (Map<String, Object> obj : list) {
                Vehicule v = new Vehicule();

                v.setMarque(marser.findMarById(Integer.parseInt(obj.get("marque_id").toString())));
                v.setModele(modser.findModById(Integer.parseInt(obj.get("modele_id").toString())));
                v.setType_v(typvser.findTypById(Integer.parseInt(obj.get("typeV_id").toString())));
                v.setMatricule(obj.get("matricule").toString());

                String phpDateString = obj.get("dExp_assurance").toString();
                Date javaDate = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String phpDateString1 = obj.get("dExp_vignette").toString();
                Date javaDate1 = null;
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

                String phpDateString2 = obj.get("dExp_visite").toString();
                Date javaDate2 = null;
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    javaDate = sdf.parse(phpDateString);
                    javaDate1 = sdf1.parse(phpDateString1);
                    javaDate2 = sdf2.parse(phpDateString2);

                } catch (ParseException ex) {
                    System.out.println("hi");
                }
                
                
                v.setdExp_assurance(javaDate);
                v.setdExp_vignette(javaDate1);
                v.setdExp_visite(javaDate2);

                listVehicules.add(v);
            }

        } catch (IOException ex) {
        }
        return listVehicules;
    }

    public Vehicule findVehiculeById(Integer id) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Vehicule/SelectVehiculeById.php?id=" + id + "");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {

                veh = getOneVehicule(new String(con.getResponseData()));
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return veh;
    }

    public Vehicule getOneVehicule(String json) {
        Vehicule vec = new Vehicule();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> vehicules = j.parseJSON(new CharArrayReader(json.toCharArray()));
            Map<String, Object> obj = (Map<String, Object>) vehicules.get("vehicule");

            vec.setId(Integer.parseInt(obj.get("id").toString()));
            vec.setMatricule(obj.get("matricule").toString());

        } catch (IOException ex) {
        }

        return vec;

    }
    
    public Vehicule getOneVehicule1(String json) {
        Vehicule vec = new Vehicule();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> vehicules = j.parseJSON(new CharArrayReader(json.toCharArray()));
            Map<String, Object> obj = (Map<String, Object>) vehicules.get("vehicule");

            vec.setId(Integer.parseInt(obj.get("id").toString()));
            vec.setMatricule(obj.get("matricule").toString());

        } catch (IOException ex) {
        }

        return vec;

    }
    public List<Vehicule> getAll() {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Vehicule/SelectVehicule.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                try{
                listVehicules = getListVehicule1(new String(con.getResponseData()));
                }catch(Exception e){
                    veh = getOneVehicule(new String(con.getResponseData()));
                    listVehicules.add(veh);
                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVehicules;

    }
    
    public List<Vehicule> getAll1() {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/KarhabtyService/Vehicule/SelectVehicule.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                try{
                listVehicules = getListVehicule1(new String(con.getResponseData()));
                }catch(Exception e){
                    veh = getOneVehicule1(new String(con.getResponseData()));
                    listVehicules.add(veh);
                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVehicules;

    }
    
    public ArrayList<Vehicule> getListVehicule1(String json) {
        ArrayList<Vehicule> listVehicule = new ArrayList<Vehicule>();
        try {

            JSONParser j = new JSONParser();
            Map<String, Object> vehicules = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) vehicules.get("vehicule");

            for (Map<String, Object> obj : list) {
                Vehicule m = new Vehicule();
                m.setId(Integer.parseInt(obj.get("id").toString()));
                m.setMatricule(obj.get("matricule").toString());

                listVehicule.add(m);

            }

        } catch (IOException ex) {
        }

        return listVehicule;

    }

}
