/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.managed;

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

    /**
     * Creates a new instance of wsManagedBean
     */
    public wsManagedBean() {
    }

    private Boolean esFechaValida(javax.xml.datatype.XMLGregorianCalendar fechaExp) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.tarjeta.TarjetaWS port = service.getTarjetaWSPort();
        return port.esFechaValida(fechaExp);
    }

    private String validarCVV(java.lang.String cvv, java.lang.String tipoTarjeta) {
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

    private String validarTipoTar(java.lang.Integer digitos) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.tarjeta.TarjetaWS port = service.getTarjetaWSPort();
        return port.validarTipoTar(digitos);
    }

}
