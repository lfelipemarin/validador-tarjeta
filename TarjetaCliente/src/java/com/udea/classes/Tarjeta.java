/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.classes;

import java.util.Date;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author toughbook
 */
@ManagedBean
public class Tarjeta {

    private String numeroTarjeta;
    private String cvv;
    private Banco banco;
    private String tipoTarjeta;
    private Date fechaVencimiento;
    private Usuario tarjetaHabiente;

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Usuario getTarjetaHabiente() {
        return tarjetaHabiente;
    }

    public void setTarjetaHabiente(Usuario tarjetaHabiente) {
        this.tarjetaHabiente = tarjetaHabiente;
    }

}
