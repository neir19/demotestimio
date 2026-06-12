package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.example.ui.PaginaDestinos;

public class CargarMasDestinos implements Task {

    public static CargarMasDestinos ahora() {
        return new CargarMasDestinos();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Scroll.to(PaginaDestinos.BOTON_LOAD_MORE),
            Click.on(PaginaDestinos.BOTON_LOAD_MORE)
        );
    }
}
