/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codename1.controllers;

import com.codename1.entities.Tache;
import com.codename1.entities.Vehicule;
import com.codename1.controllers.ClientService;
import com.codename1.controllers.MoniteurService;
import com.codename1.controllers.VehiculeService;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class TacheService {
    ClientService clser = new ClientService();
    MoniteurService monser = new MoniteurService();
    VehiculeService vehser = new VehiculeService();
    Tache tach = new Tache();
    
    public ArrayList<Tache> getListTache(String json) throws ParseException {
        ArrayList<Tache> listTaches = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();
            Map<String, Object> taches = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) taches.get("tache");

            for (Map<String, Object> obj : list) {
                Tache t = new Tache();

                t.setClient(clser.findClientById(Integer.parseInt(obj.get("client_id").toString())));
                t.setMoniteur(monser.findMoniteurById(Integer.parseInt(obj.get("moniteur_id").toString())));
                t.setVehicule(vehser.findVehiculeById(Integer.parseInt(obj.get("vehicule_id").toString())));
                

                String phpDateString = obj.get("date").toString();
                Date javaDate = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//                String phpDateString1 = obj.get("dExp_vignette").toString();
//                Date javaDate1 = null;
//                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//
//                String phpDateString2 = obj.get("dExp_visite").toString();
//                Date javaDate2 = null;
//                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    javaDate = sdf.parse(phpDateString);
//                    javaDate1 = sdf1.parse(phpDateString1);
//                    javaDate2 = sdf2.parse(phpDateString2);

                } catch (ParseException ex) {
                    System.out.println("hi");
                }

                t.setDate(javaDate);
//                v.setdExp_vignette(javaDate1);
//                v.setdExp_visite(javaDate2);

                listTaches.add(t);
            }

        } catch (IOException ex) {
        }
        return listTaches;
    }
    
}
