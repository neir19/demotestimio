package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.interactions.IngresarFecha;
import org.example.model.DatosReserva;
import org.example.ui.PaginaInicio;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgendarViaje implements Task {
    private final DatosReserva datos;

    public AgendarViaje(DatosReserva datos) {
        this.datos = datos;
    }

    public static AgendarViaje con(DatosReserva datos) {
        return new AgendarViaje(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                IngresarFecha.de(datos.fechaIda(), PaginaInicio.CAMPO_FECHA_IDA),
                IngresarFecha.de(datos.fechaRegreso(), PaginaInicio.CAMPO_FECHA_REGRESO),
                Click.on(PaginaInicio.CAMPO_ADULTOS),
                WaitUntil.the(PaginaInicio.ADULT_OPTION.of(datos.adultos()), isVisible()),
                Click.on(PaginaInicio.ADULT_OPTION.of(datos.adultos())),
                Click.on(PaginaInicio.CAMPO_NINOS),
                WaitUntil.the(PaginaInicio.NINO_OPTION.of(datos.ninos()), isVisible()),
                Click.on(PaginaInicio.NINO_OPTION.of(datos.ninos())),
                Click.on(PaginaInicio.BOTON_DESTINATION)
        );
    }
}
