/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.tarjeta;

import java.util.Calendar;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author toughbook
 */
@WebService(serviceName = "Tarjeta")
public class TarjetaWS {

    /**
     * This is a sample web service operation
     *
     * @param digitos
     * @return
     */
    @WebMethod(operationName = "validarLongitudDigitos")
    public Boolean validarLongitudDigitos(@WebParam(name = "digitos") String digitos) {
        if (digitos.length() == 16) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Web service operation
     *
     * @param cvv
     * @param tipoTarjeta
     * @return
     */
    @WebMethod(operationName = "validarCVV")
    public String validarCVV(@WebParam(name = "cvv") String cvv, @WebParam(name = "tipoTarjeta") String tipoTarjeta) {
        if (cvv.length() == 3 && tipoTarjeta.equals("MasterCard")) {
            return "MasterCard";
        } else if (cvv.length() == 3 && tipoTarjeta.equals("Visa")) {
            return "Visa";
        } else if (cvv.length() == 4 && tipoTarjeta.equals("American Express")) {
            return "American Express";
        } else if (cvv.length() == 4 && tipoTarjeta.equals("Dinners")) {
            return "Dinners";
        } else {
            return "Revise los digitos o tipo de tarjeta";
        }
    }

    /**
     * Web service operation
     *
     * @param fechaExp
     * @return
     */
    @WebMethod(operationName = "esFechaValida")
    public Boolean esFechaValida(@WebParam(name = "fechaExp") Calendar fechaExp) {
        return fechaExp.get(Calendar.DAY_OF_MONTH) > Calendar.DAY_OF_MONTH;
    }

    /**
     * Web service operation
     * @param primeros4Digitos
     * @return 
     */
    @WebMethod(operationName = "validarTipoTar")
    public String validarTipoTar(@WebParam(name = "digitos") Integer primeros4Digitos) {
        if (primeros4Digitos <= 2999) {
            return "MasterCard";
        } else if (primeros4Digitos > 2999 && primeros4Digitos <= 5999) {
            return "American Express";
        } else if (primeros4Digitos > 5999 && primeros4Digitos <= 8999) {
            return "Dinners";
        } else if (primeros4Digitos > 8999 && primeros4Digitos <= 9999) {
            return "Visa";
        } else {
            return "Algo malo paso";
        }
    }

}
