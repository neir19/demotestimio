package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.example.interactions.FiltrarPrecio;

public class FiltrarPorPrecio implements Task {
    private final String porcentaje;

    public FiltrarPorPrecio(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public static FiltrarPorPrecio conRango(String porcentaje) {
        return new FiltrarPorPrecio(porcentaje);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(FiltrarPrecio.alPorcentaje(Integer.parseInt(porcentaje)));
    }
}
