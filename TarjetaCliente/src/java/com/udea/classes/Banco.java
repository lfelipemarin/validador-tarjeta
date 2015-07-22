/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.classes;

import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author toughbook
 */
@ManagedBean
public class Banco {

    private String nombreBanco;
    private List<String> tiposTarjeta;

    public Banco(String nombreBanco, List<String> tiposTarjeta) {
        this.nombreBanco = nombreBanco;
        this.tiposTarjeta = tiposTarjeta;
    }

    public List<String> getTiposTarjeta() {
        return tiposTarjeta;
    }

    public void setTiposTarjeta(List<String> tiposTarjeta) {
        this.tiposTarjeta = tiposTarjeta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

}
