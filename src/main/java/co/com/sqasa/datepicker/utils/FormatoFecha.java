/*
 * @(#) FormatoFecha.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

import static co.com.sqasa.datepicker.utils.ConstantesDatepicker.FORMATO_FECHA_CAMPO;

/**
 * Convierte fechas entre el formato del campo, el encabezado del calendario y LocalDate.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public final class FormatoFecha {

    private static final DateTimeFormatter FORMATO_CAMPO = DateTimeFormatter.ofPattern(FORMATO_FECHA_CAMPO);

    private FormatoFecha() {
    }

    /**
     * Escribe la fecha como la muestra el campo del datepicker, por ejemplo 01/15/2027.
     *
     * @param dteFecha fecha a escribir
     * @return la fecha en formato MM/dd/yyyy
     */
    public static String formatearParaCampo(LocalDate dteFecha) {
        return dteFecha.format(FORMATO_CAMPO);
    }

    /**
     * Interpreta el encabezado del calendario (mes en inglés y año), por ejemplo "January" y "2027".
     *
     * @param strMes nombre del mes en inglés
     * @param strAnio año con cuatro dígitos
     * @return el mes y el año que muestra el calendario
     */
    public static YearMonth leerMesVisible(String strMes, String strAnio) {
        Month mesVisible = Arrays.stream(Month.values())
                .filter(mes -> mes.getDisplayName(TextStyle.FULL, Locale.ENGLISH).equalsIgnoreCase(strMes.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Mes no reconocido en el calendario: " + strMes));
        return YearMonth.of(Integer.parseInt(strAnio.trim()), mesVisible);
    }
}
