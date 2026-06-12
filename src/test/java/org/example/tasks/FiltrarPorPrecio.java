package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.example.interactions.FiltrarPrecio;
import org.example.interactions.ScrollUp;
import org.example.ui.PaginaDestinos;
import org.openqa.selenium.Keys;

public class FiltrarPorPrecio implements Task {
    private final String rangoPrecio;

    public FiltrarPorPrecio(String rangoPrecio) {

        this.rangoPrecio = rangoPrecio;
    }

    public static FiltrarPorPrecio conRango(String rangoPrecio) {
        return new FiltrarPorPrecio(rangoPrecio);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(FiltrarPrecio.conMaximo(40));
//        actor.attemptsTo(
//                ScrollUp.toTheTop()
//
//        );
//        actor.attemptsTo(Scroll.to(PaginaDestinos.FILTRO_PRECIO_MAX));
//        actor.attemptsTo(Click.on(PaginaDestinos.FILTRO_PRECIO_MAX),
//                Clear.field(PaginaDestinos.FILTRO_PRECIO_MAX));
//        actor.attemptsTo(Enter.theValue(rangoPrecio).into(PaginaDestinos.FILTRO_PRECIO_MAX));
//        actor.attemptsTo(Enter.keyValues(Keys.ENTER).into(PaginaDestinos.FILTRO_PRECIO_MAX));
    }
}
