package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaDestinos;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarDestino implements Task {
    private final String nombreDestino;

    public SeleccionarDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public static SeleccionarDestino llamado(String nombreDestino) {
        return new SeleccionarDestino(nombreDestino);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(PaginaDestinos.LINK_DESTINO.of(nombreDestino),isVisible()).forNoMoreThan(4).seconds());
        actor.attemptsTo(
            Scroll.to(PaginaDestinos.LINK_DESTINO.of(nombreDestino)),
            Click.on(PaginaDestinos.LINK_DESTINO.of(nombreDestino))
        );
        System.out.println("seleccione el destino "+nombreDestino);
    }
}
