package org.example.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.example.Utils.Utils;
import org.example.ui.PaginaInicio;

import java.time.YearMonth;

public class NavegarAlMesEnCalendario implements Interaction {
    private static final int MAX_AJUSTES = 12;

    private final YearMonth mesObjetivo;

    public NavegarAlMesEnCalendario(YearMonth mesObjetivo) {
        this.mesObjetivo = mesObjetivo;
    }

    public static NavegarAlMesEnCalendario hacia(YearMonth mesObjetivo) {
        return Instrumented.instanceOf(NavegarAlMesEnCalendario.class).withProperties(mesObjetivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String nombreMes = Utils.obtenerMes(mesObjetivo.getMonthValue());
        Target indicadorMes = PaginaInicio.CAMPO_MES_ANIO.of(nombreMes);

        if (indicadorMes.isVisibleFor(actor)) {
            return;
        }

        YearMonth mesInicial = Utils.mesVisibleInicial(mesObjetivo.getYear());
        navegarPorClics(actor, diferenciaEnMeses(mesInicial, mesObjetivo));

        if (!indicadorMes.isVisibleFor(actor)) {
            ajustarHastaMesVisible(actor, indicadorMes);
        }
    }

    private void navegarPorClics(Actor actor, int diferencia) {
        if (diferencia == 0) {
            return;
        }

        Target boton = diferencia > 0 ? PaginaInicio.BOTON_NEXT : PaginaInicio.BOTON_PREV;
        int clicks = Math.abs(diferencia);

        for (int i = 0; i < clicks; i++) {
            actor.attemptsTo(Click.on(boton));
        }
    }

    private void ajustarHastaMesVisible(Actor actor, Target indicadorMes) {
        for (int i = 0; i < MAX_AJUSTES; i++) {
            if (indicadorMes.isVisibleFor(actor)) {
                return;
            }
            actor.attemptsTo(Click.on(PaginaInicio.BOTON_NEXT));
        }

        throw new IllegalStateException(
                "No se pudo navegar al mes: " + Utils.obtenerMes(mesObjetivo.getMonthValue())
        );
    }

    private static int diferenciaEnMeses(YearMonth desde, YearMonth hasta) {
        return (hasta.getYear() - desde.getYear()) * 12
                + (hasta.getMonthValue() - desde.getMonthValue());
    }
}
