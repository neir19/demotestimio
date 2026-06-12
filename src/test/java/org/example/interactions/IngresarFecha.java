package org.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.example.Utils.Utils;
import org.example.ui.PaginaInicio;

import java.time.LocalDate;
import java.time.YearMonth;

public class IngresarFecha implements Interaction {
    private final LocalDate fecha;
    private final Target campo;

    public IngresarFecha(String fecha, Target campo) {
        this.fecha = Utils.parseFecha(fecha);
        this.campo = campo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Utils.validarFecha(fecha);

        String anio = String.valueOf(fecha.getYear());
        String dia = String.valueOf(fecha.getDayOfMonth());
        YearMonth mesObjetivo = YearMonth.from(fecha);

        actor.attemptsTo(
                Click.on(campo),
                Click.on(PaginaInicio.CAMPO_ANO_CALENDARIO),
                Click.on(PaginaInicio.ITEM_LIST_CALENDARIO_ANO.of(anio)),
                NavegarAlMesEnCalendario.hacia(mesObjetivo),
                Click.on(PaginaInicio.BOTON_DIA.of(dia)),
                Click.on(PaginaInicio.BOTON_OK)
        );
    }

    public static Performable de(String fecha, Target campo) {
        return Tasks.instrumented(IngresarFecha.class, fecha, campo);
    }
}
