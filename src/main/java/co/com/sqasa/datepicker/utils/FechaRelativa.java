/*
 * @(#) FechaRelativa.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.utils;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Calcula fechas relativas a hoy para que los datos de prueba no venzan con el tiempo.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public final class FechaRelativa {

    private FechaRelativa() {
    }

    /**
     * Calcula el día indicado del mes que está a cierta cantidad de meses del actual.
     * Si el mes tiene menos días, usa el último día del mes.
     *
     * @param intMeses meses de diferencia con el mes actual (negativo hacia atrás)
     * @param intDia día del mes
     * @return la fecha calculada
     */
    public static LocalDate delMesRelativo(int intMeses, int intDia) {
        YearMonth ymMesObjetivo = YearMonth.now().plusMonths(intMeses);
        return ymMesObjetivo.atDay(Math.min(intDia, ymMesObjetivo.lengthOfMonth()));
    }

    /**
     * Calcula la fecha que está a cierta cantidad de días de hoy.
     *
     * @param intDias días de diferencia con hoy (negativo hacia atrás)
     * @return la fecha calculada
     */
    public static LocalDate aDiasDeHoy(int intDias) {
        return LocalDate.now().plusDays(intDias);
    }
}
