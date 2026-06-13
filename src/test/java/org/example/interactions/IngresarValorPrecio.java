package org.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import org.example.ui.PaginaDestinos;
import org.openqa.selenium.Keys;

public class IngresarValorPrecio implements Interaction {
    private  String valor;

    public IngresarValorPrecio(String valor) {
        this.valor = valor;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(PaginaDestinos.FILTRO_PRECIO_MAX));
        actor.attemptsTo(Click.on(PaginaDestinos.FILTRO_PRECIO_MAX));
        actor.attemptsTo(SendKeys.of(Keys.CONTROL,"a").into(PaginaDestinos.FILTRO_PRECIO_MAX));
        actor.attemptsTo(SendKeys.of(Keys.DELETE).into(PaginaDestinos.FILTRO_PRECIO_MAX));
       actor.attemptsTo(Enter.theValue(valor).into(PaginaDestinos.FILTRO_PRECIO_MAX));
        actor.attemptsTo(Enter.keyValues(Keys.ENTER).into(PaginaDestinos.FILTRO_PRECIO_MAX));
    }

    public static Performable con(String valor){
        return Tasks.instrumented(IngresarValorPrecio.class,valor);
    }
}
