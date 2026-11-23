/*
 * @(#) EjemploDatepicker.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.models;

/**
 * Ejemplos de la página de jQuery UI Datepicker que usa la automatización, con el texto de su enlace y el archivo que carga su marco.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public enum EjemploDatepicker {

    FUNCIONALIDAD_BASICA("Default functionality", "default.html"),
    RANGO_RESTRINGIDO("Restrict date range", "min-max.html");

    private final String strNombreEnlace;
    private final String strArchivoDemostracion;

    EjemploDatepicker(String strNombreEnlace, String strArchivoDemostracion) {
        this.strNombreEnlace = strNombreEnlace;
        this.strArchivoDemostracion = strArchivoDemostracion;
    }

    /**
     * Devuelve el archivo que carga el marco de la página para este ejemplo.
     *
     * @return el nombre del archivo de la demostración
     */
    public String getArchivoDemostracion() {
        return strArchivoDemostracion;
    }

    /**
     * Devuelve el texto del enlace del ejemplo en la lista "Examples" de la página.
     *
     * @return el nombre del enlace
     */
    public String getNombreEnlace() {
        return strNombreEnlace;
    }
}
