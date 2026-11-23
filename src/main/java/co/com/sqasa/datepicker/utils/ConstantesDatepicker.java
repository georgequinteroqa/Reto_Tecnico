/*
 * @(#) ConstantesDatepicker.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.utils;

/**
 * Constantes de la automatización del calendario emergente (jQuery UI Datepicker).
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public final class ConstantesDatepicker {

    /** Ruta de la página bajo prueba, relativa a webdriver.base.url de serenity.conf. */
    public static final String RUTA_DATEPICKER = "/datepicker/";
    /** Formato con el que el datepicker escribe la fecha en el campo (mm/dd/yy de jQuery UI). */
    public static final String FORMATO_FECHA_CAMPO = "MM/dd/yyyy";
    /** Tope de clics de navegación entre meses, para no quedar en un ciclo infinito. */
    public static final int MAXIMO_CLICS_NAVEGACION = 240;
    /** Segundos máximos de espera para que cargue el marco del ejemplo. */
    public static final int SEGUNDOS_ESPERA_MARCO = 20;
    /** Nombre del actor de los escenarios. */
    public static final String NOMBRE_ACTOR = "Usuario";
    /** Llave con la que el actor recuerda la fecha que seleccionó. */
    public static final String FECHA_SELECCIONADA = "fechaSeleccionada";

    private ConstantesDatepicker() {
    }
}
