package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaConfirmacion {
    public static final Target MENSAJE_CONFIRMACION = Target.the("Mensaje de confirmacion de reserva")
        .locatedBy("#confirmation-message");
}
