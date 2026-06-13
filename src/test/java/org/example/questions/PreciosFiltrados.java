package org.example.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

public class PreciosFiltrados implements Question<List<Integer>> {
    private final Target campo;

    public PreciosFiltrados(Target campo) {
        this.campo = campo;
    }

    public static PreciosFiltrados obtenidos(Target campo) {
        return new PreciosFiltrados(campo);
    }

    @Override
    public List<Integer> answeredBy(Actor actor) {
        return campo.resolveAllFor(actor).stream()
                .map(WebElementFacade::getText)
                .filter(text -> !text.isBlank())
                .map(text -> text.replace("$", "").replace(",", "").trim())
                .filter(text -> text.matches("\\d+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

