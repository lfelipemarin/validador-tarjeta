/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.tarjeta;

import java.util.Date;
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

    @WebMethod(operationName = "validarTarjeta")
    public Boolean validarTarjeta(@WebParam(name = "tarjeta") String tarjeta, @WebParam(name = "cvv") String cvv, @WebParam(name = "tipo") String tipo, @WebParam(name = "fecha") Date fecha) {
        if (validarLongitudDigitos(tarjeta)) {
            String ffd = "";
            for (int i = 0; i < 4; i++) {
                ffd += tarjeta.charAt(i);
            }
            if (tipo.equals(validarTipoTar(Integer.parseInt(ffd)))) {
                if (validarCVV(cvv, tipo)) {
                    System.out.println("Todo OK!");
                    return esFechaValida(fecha);
                }
            }
        }
        return false;
    }

    /**
     * Web service operation
     *
     * @param cvv
     * @param tipoTarjeta
     * @return
     */
    @WebMethod(operationName = "validarCVV")
    public Boolean validarCVV(@WebParam(name = "cvv") String cvv, @WebParam(name = "tipoTarjeta") String tipoTarjeta) {
        if (cvv.length() == 3 && tipoTarjeta.equals("MasterCard")) {
            return true;
        } else if (cvv.length() == 3 && tipoTarjeta.equals("Visa")) {
            return true;
        } else if (cvv.length() == 4 && tipoTarjeta.equals("American Express")) {
            return true;
        } else {
            return cvv.length() == 4 && tipoTarjeta.equals("Dinners");
        }
    }

    /**
     * Web service operation
     *
     * @param fechaExp
     * @return
     */
    @WebMethod(operationName = "esFechaValida")
    public Boolean esFechaValida(@WebParam(name = "fechaExp") Date fechaExp) {
        if (fechaExp.after(new Date())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Web service operation
     *
     * @param primeros4Digitos
     * @return
     */
    @WebMethod(operationName = "validarTipoTar")
    public String validarTipoTar(@WebParam(name = "digitos") Integer primeros4Digitos
    ) {
        if (primeros4Digitos <= 2999) {
            return "MasterCard";
        } else if (primeros4Digitos > 2999 && primeros4Digitos <= 5999) {
            return "American Express";
        } else if (primeros4Digitos > 5999 && primeros4Digitos <= 8999) {
            return "Dinners";
        } else if (primeros4Digitos > 8999 && primeros4Digitos <= 9999) {
            return "Visa";
        } else {
            return null;
        }
    }

}
