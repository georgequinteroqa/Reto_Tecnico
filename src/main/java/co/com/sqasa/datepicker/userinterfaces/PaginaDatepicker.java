/*
 * @(#) PaginaDatepicker.java 1.0 22/11/2026
 *
 * Copyright 2026 SQA S.A. Todos los derechos reservados.
 */
package co.com.sqasa.datepicker.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Vista principal de https://jqueryui.com/datepicker/: lista de ejemplos de la página.
 *
 * @autor George Quintero
 * @Fecha: 22/11/2026
 */
public final class PaginaDatepicker {

    public static final Target ENLACE_EJEMPLO = Target.the("enlace del ejemplo {0}")
            .locatedBy("//div[contains(@class,'demo-list')]//a[normalize-space()='{0}']");

    private PaginaDatepicker() {
    }
}
