/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.managed;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;
import ws.tarjeta.Tarjeta;

/**
 *
 * @author toughbook
 */
@ManagedBean
@RequestScoped
public class wsManagedBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TarjetaServer/Tarjeta.wsdl")
    private Tarjeta service;
    
    private List<String> tarjetas;
    private String banco;
    private String tarjeta;
    private List<String> bancos;

    @PostConstruct
    public void init() {
        bancos = new ArrayList<>();
        tarjetas = new ArrayList<>();

        tarjetas.add("MasterCard");
        tarjetas.add("Visa");
        tarjetas.add("American Express");
        tarjetas.add("Dinners");
        bancos.add("Bancolombia");
        bancos.add("Citybank");
        bancos.add("Davivienda");
        bancos.add("Banco de Bogota");
        bancos.add("Bancolchon");
        bancos.add("BBVA");
        bancos.add("Banco Santander");

    }

    /**
     * Creates a new instance of wsManagedBean
     */
    public wsManagedBean() {
    }

    public List<String> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<String> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<String> getBancos() {
        return bancos;
    }

    public void setBancos(List<String> bancos) {
        this.bancos = bancos;
    }

    private Boolean esFechaValida(javax.xml.datatype.XMLGregorianCalendar fechaExp) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.tarjeta.TarjetaWS port = service.getTarjetaWSPort();
        return port.esFechaValida(fechaExp);
    }

    private Boolean validarCVV(java.lang.String cvv, java.lang.String tipoTarjeta) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.tarjeta.TarjetaWS port = service.getTarjetaWSPort();
        return port.validarCVV(cvv, tipoTarjeta);
    }

    private Boolean validarLongitudDigitos(java.lang.String digitos) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.tarjeta.TarjetaWS port = service.getTarjetaWSPort();
        return port.validarLongitudDigitos(digitos);
    }

    private Boolean validarTarjeta(java.lang.String tarjeta, java.lang.String cvv, java.lang.String tipo, javax.xml.datatype.XMLGregorianCalendar fecha) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.tarjeta.TarjetaWS port = service.getTarjetaWSPort();
        return port.validarTarjeta(tarjeta, cvv, tipo, fecha);
    }

    private String validarTipoTar(java.lang.Integer digitos) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.tarjeta.TarjetaWS port = service.getTarjetaWSPort();
        return port.validarTipoTar(digitos);
    }

}
