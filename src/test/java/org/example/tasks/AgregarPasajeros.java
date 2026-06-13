package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.model.DatosPasajero;
import org.example.ui.PaginaInicio;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarPasajeros implements Task {
    private final DatosPasajero dato;

    public AgregarPasajeros(DatosPasajero dato) {
        this.dato = dato;
    }

    public static AgregarPasajeros aLaReserva(DatosPasajero dato) {
        return new AgregarPasajeros(dato);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(PaginaInicio.CAMPO_ADULTOS),
            WaitUntil.the(PaginaInicio.ADULT_OPTION.of(String.valueOf(dato.cantidad())), isVisible()),
            Click.on(PaginaInicio.ADULT_OPTION.of(String.valueOf(dato.cantidad())))
        );
    }
}
