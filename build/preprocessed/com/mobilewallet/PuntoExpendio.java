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
    private int state = 1;  //1: Pendiente, 2: Diligenciado


    public PuntoExpendio(int id, String nombre, String fecha, String entrdev, int valorunitario, int valortotal, int state) {
        SetId(id);
        SetNombre(nombre);
        SetFecha(fecha);
        SetEntrDev(entrdev);
        SetValorUnitario(valorunitario);
        SetValorTotal(valortotal);
        SetState(state);
    }


    public int GetId() {
        return this.Id;
    }

    public void SetId(int id) {
        this.Id = id;
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

    public void SetValorUnitario(int valor_unitario) {
        this.ValorUnitario = valor_unitario;
    }


    public int GetValorTotal() {
        return this.ValorTotal;
    }

    public void SetValorTotal(int valor_total) {
        this.ValorTotal = valor_total;
    }


    public int GetState() {
        return this.state;
    }

    public void SetState(int stat) {
        this.state = stat;
    }

}
