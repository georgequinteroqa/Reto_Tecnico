/*
 * @(#) CalendarioEmergente.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Campo de fecha y calendario emergente dentro del marco del ejemplo.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public final class CalendarioEmergente {

    public static final Target CAMPO_FECHA = Target.the("campo de fecha").locatedBy("#datepicker");
    public static final Target CALENDARIO = Target.the("calendario emergente").locatedBy("#ui-datepicker-div");
    public static final Target MES_VISIBLE = Target.the("mes visible").locatedBy("#ui-datepicker-div .ui-datepicker-month");
    public static final Target ANIO_VISIBLE = Target.the("año visible").locatedBy("#ui-datepicker-div .ui-datepicker-year");
    public static final Target BOTON_MES_SIGUIENTE = Target.the("botón mes siguiente")
            .locatedBy("#ui-datepicker-div a.ui-datepicker-next");
    public static final Target BOTON_MES_ANTERIOR = Target.the("botón mes anterior")
            .locatedBy("#ui-datepicker-div a.ui-datepicker-prev");
    /** Día seleccionable: {0} mes de 0 a 11, {1} año, {2} día. */
    public static final Target DIA_SELECCIONABLE = Target.the("día {2} del mes {0} de {1}")
            .locatedBy("//div[@id='ui-datepicker-div']//td[@data-handler='selectDay' and @data-month='{0}' and @data-year='{1}']/a[normalize-space()='{2}']");
    /** Celda del día {0} del mes visible, esté habilitada o no. */
    public static final Target CELDA_DIA = Target.the("celda del día {0}")
            .locatedBy("//div[@id='ui-datepicker-div']//table[contains(@class,'ui-datepicker-calendar')]//td[not(contains(@class,'ui-datepicker-other-month'))][normalize-space()='{0}']");

    private CalendarioEmergente() {
    }
}
