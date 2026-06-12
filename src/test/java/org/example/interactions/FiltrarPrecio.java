package org.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.example.ui.PaginaDestinos;
import org.openqa.selenium.interactions.Actions;

public class FiltrarPrecio implements Interaction {
    private final int precioMaximo;

    public FiltrarPrecio(int precioMaximo) {
        this.precioMaximo = precioMaximo;
    }

    public static FiltrarPrecio conMaximo(int precioMaximo) {
        return new FiltrarPrecio(precioMaximo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        var driver = BrowseTheWeb.as(actor).getDriver();
        var slider = PaginaDestinos.PRICE_SLIDER_HANDLE.resolveFor(actor);

        // Calculamos el desplazamiento necesario (esto depende del ancho del slider)
        // Movemos el slider hacia la izquierda para reducir el precio
        new Actions(driver)
                .dragAndDropBy(slider, -50, 0) // El valor -50 debe ajustarse mediante cálculo o prueba
                .perform();
    }
}
