/*
 * @(#) FechaIncorrectaException.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.exceptions;

/**
 * Falla de negocio: el campo o el calendario no muestran la fecha esperada.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public class FechaIncorrectaException extends AssertionError {

    public static final String FECHA_NO_REFLEJADA = "La fecha seleccionada no se reflejó en el campo con el formato esperado";
    public static final String FECHA_FUERA_DE_RANGO_SELECCIONABLE = "Una fecha fuera del rango permitido se pudo seleccionar";
    public static final String FECHA_DENTRO_DE_RANGO_NO_SELECCIONABLE = "Una fecha dentro del rango permitido no se pudo seleccionar";
    public static final String CAMPO_MODIFICADO = "El campo de fecha cambió aunque la fecha no era seleccionable";
    public static final String CALENDARIO_NO_VISIBLE = "El calendario emergente no apareció al hacer clic en el campo";

    public FechaIncorrectaException(String strMensaje, Throwable causa) {
        super(strMensaje, causa);
    }
}
