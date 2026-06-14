package org.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import org.example.Utils.Utils;
import org.example.ui.PaginaDestinos;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FiltrarPrecio implements Interaction {

    private final int porcentaje;

    public FiltrarPrecio(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public static Performable alPorcentaje(int porcentaje) {
        return Tasks.instrumented(FiltrarPrecio.class, porcentaje);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if(porcentaje>100){
            throw new IllegalStateException(
                    "Porcentaje no puede ser mayor que 100"
            );
        }
        int porcentajeValido = Math.max(0, Math.min(100, porcentaje));

        actor.attemptsTo(Scroll.to(PaginaDestinos.CONTAINER));

        WebElement barra = PaginaDestinos.BARRA_PROGRESO.resolveFor(actor);
        int ancho = barra.getSize().getWidth();
        int offsetX = (int) (ancho * (porcentajeValido / 100.0) - ancho / 2.0);

        new Actions(BrowseTheWeb.as(actor).getDriver())
                .moveToElement(barra, offsetX, 0)
                .click()
                .perform();
    }
}
