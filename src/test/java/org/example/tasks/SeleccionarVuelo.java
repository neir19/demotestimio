package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaDestinos;
import org.example.ui.PaginaInicio;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarVuelo implements Task {
    private final String destino;

    public SeleccionarVuelo(String destino) {
        this.destino = destino;
    }

    public static SeleccionarVuelo disponible(String destino) {
        return new SeleccionarVuelo(destino);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(PaginaInicio.BOTON_DESTINATION),
            WaitUntil.the(PaginaDestinos.BOTON_LOAD_MORE, isVisible()).forNoMoreThan(10).seconds(),
            Scroll.to(PaginaDestinos.BOTON_LOAD_MORE),
            Click.on(PaginaDestinos.BOTON_LOAD_MORE),
            WaitUntil.the(PaginaDestinos.LINK_DESTINO.of(destino), isVisible()).forNoMoreThan(10).seconds(),
            Scroll.to(PaginaDestinos.LINK_DESTINO.of(destino)),
            Click.on(PaginaDestinos.LINK_DESTINO.of(destino))
        );
    }
}
