/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mobilewallet;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class PuntoExpendio {

    private int Id;
    private String Nombre;
    private String Fecha;
    private String EntrDev;
    private int ValorUnitario;
    private int ValorTotal;


    public PuntoExpendio(String id, String nombre, String fecha, String entrdev, String valorunitario, String valortotal) {
        SetId(id);
        SetNombre(nombre);
        SetFecha(fecha);
        SetEntrDev(entrdev);
        SetValorUnitario(valorunitario);
        SetValorTotal(valortotal);
    }


    public int GetId() {
        return this.Id;
    }

    public void SetId(String id) {
        this.Id = Integer.parseInt(id);
    }


    public String GetNombre() {
        return this.Nombre;
    }

    public void SetNombre(String nombre) {
        this.Nombre = nombre;
    }


    public String GetFecha() {
        return this.Fecha;
    }

    public void SetFecha(String fecha) {
        this.Fecha = fecha;
    }


    public String GetEntrDev() {
        return this.EntrDev;
    }

    public void SetEntrDev(String entr_dev) {
        this.EntrDev = entr_dev;
    }


    public int GetValorUnitario() {
        return this.ValorUnitario;
    }

    public void SetValorUnitario(String valor_unitario) {
        this.ValorUnitario = Integer.parseInt(valor_unitario);
    }


    public int GetValorTotal() {
        return this.ValorTotal;
    }

    public void SetValorTotal(String valor_total) {
        this.ValorTotal = Integer.parseInt(valor_total);
    }

}
