/*
 * @(#) NavegacionCalendarioException.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.exceptions;

/**
 * Falla técnica: el calendario no llegó al mes pedido.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class NavegacionCalendarioException extends RuntimeException {

    public NavegacionCalendarioException(String strMensaje) {
        super(strMensaje);
    }
}
