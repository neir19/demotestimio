package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.example.ui.PaginaFormulario;

public class AceptarTerminos implements Task {

    public static AceptarTerminos actuales() {
        return new AceptarTerminos();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Scroll.to(PaginaFormulario.LABEL_TERMINOS),
            Click.on(PaginaFormulario.LABEL_TERMINOS)
        );
    }
}
