/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.managed;

import com.udea.classes.TarjetaCredito;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.WebServiceRef;
import ws.tarjeta.Tarjeta;

/**
 *
 * @author toughbook
 */
@ManagedBean
@RequestScoped
public class wsManagedBean implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TarjetaServer/Tarjeta.wsdl")
    private Tarjeta service;

    private TarjetaCredito tarjetaClase;
    private Map<String, Map<String, String>> data = new HashMap<>();
    private Map<String, String> bancos;
    private Map<String, String> tarjetas;
    private String banco;
    private String tarjeta;

    /**
     * Creates a new instance of wsManagedBean
     */
    public wsManagedBean() {
    }

    @PostConstruct
    public void init() {
        tarjetaClase = new TarjetaCredito();
        bancos = new HashMap<>();
        tarjetas = new HashMap<>();
        bancos.put("Bancolombia", "Bancolombia");
        bancos.put("Citybank", "Citybank");
        bancos.put("Davivienda", "Davivienda");
        bancos.put("Banco de Bogota", "Banco de Bogota");
        bancos.put("Bancolchon", "Bancolchon");
        bancos.put("BBVA", "BBVA");
        bancos.put("Banco Santander", "Banco Santander");

        tarjetas.put("MasterCard", "MasterCard");
        tarjetas.put("Visa", "Visa");
        tarjetas.put("American Express", "American Express");
        tarjetas.put("Dinners", "Dinners");
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

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }

    public Map<String, String> getBancos() {
        return bancos;
    }

    public void setBancos(Map<String, String> bancos) {
        this.bancos = bancos;
    }

    public Map<String, String> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(Map<String, String> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public TarjetaCredito getTarjetaClase() {
        return tarjetaClase;
    }

    public void setTarjetaClase(TarjetaCredito tarjetaClase) {
        this.tarjetaClase = tarjetaClase;
    }

    private Boolean validarTarjeta(java.lang.String tarjeta, java.lang.String cvv, java.lang.String tipo, javax.xml.datatype.XMLGregorianCalendar fecha) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.tarjeta.TarjetaWS port = service.getTarjetaWSPort();
        return port.validarTarjeta(tarjeta, cvv, tipo, fecha);
    }

    public Boolean validar() throws DatatypeConfigurationException {
        if (validarTarjeta(tarjetaClase.getNumeroTarjeta(), tarjetaClase.getCvv(), tarjetaClase.getTipoTarjeta(),
                tarjetaClase.dateToCalendar(tarjetaClase.getFechaVencimiento()))) {
            FacesMessage msg;

            msg = new FacesMessage("Numero de tarjeta " + tarjetaClase.getNumeroTarjeta() + ", tipo de tarjeta "
                    + tarjetaClase.getTipoTarjeta() + " con fecha de vencimiento " + tarjetaClase.getFechaVencimiento()
                    + " es valida para el banco " + banco);

            FacesContext.getCurrentInstance().addMessage(null, msg);
            return true;
        } else {
            FacesMessage msg;

            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Tarjeta no valida, por favor verifique"
                    + "los datos");

            FacesContext.getCurrentInstance().addMessage(null, msg);
            return false;
        }
    }

}
