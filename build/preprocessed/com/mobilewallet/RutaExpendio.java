/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mobilewallet;

import java.util.Vector;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author Admin
 */
public class RutaExpendio {

    private String sMessages;

    private String Cobrador, Zona, Fecha;
    public Vector Puntos = null;
    private String sJSON;


    public RutaExpendio(String json_data) {
        this.sJSON = json_data;
        Puntos = new Vector();
        ProcessJSON(this.sJSON);
    }

    private void ProcessJSON(String str_json) {
        try {
            JSONObject jsonobject = new JSONObject(str_json);
            if (jsonobject != null) {
                this.Cobrador = jsonobject.getString("COBRADOR");
                this.Zona = jsonobject.getString("ZONA");
                this.Fecha = jsonobject.getString("FECHA");

                JSONArray japuntos = jsonobject.getJSONArray("puntos");
                if (japuntos != null) {
                    //anArray = new String[ja.length()];
                    for (int i = 0; i < japuntos.length(); i++) {
                        JSONObject jopunto = japuntos.getJSONObject(i);
                        PuntoExpendio puntoexpendio = new PuntoExpendio(jopunto.getString("ID"), jopunto.getString("NOMBRE"), jopunto.getString("FECHA"), jopunto.getString("ENTR DEV"), jopunto.getString("VALOR UNITARIO"), jopunto.getString("VALOR TOTAL"));
                        Puntos.addElement(puntoexpendio);
                    }
                }
            }
        } catch (JSONException jsonex) {
            SetMessages(jsonex.toString());
            jsonex.printStackTrace();
        } catch (Exception ex) {
            SetMessages(ex.toString());
            ex.printStackTrace();
        }
    }


    public String GetMessages() {
        return this.sMessages;
    }

    public void SetMessages(String msg) {
        this.sMessages = msg;
    }

}
