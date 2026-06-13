package org.example.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TextoAleatorio implements Question<String> {

    private final Target elementos;

    public TextoAleatorio(Target elementos) {
        this.elementos = elementos;
    }

    public static TextoAleatorio de(Target elementos) {
        return new TextoAleatorio(elementos);
    }

    @Override
    public String answeredBy(Actor actor) {

        List<String> textos = elementos.resolveAllFor(actor)
                .stream()
                .map(WebElementFacade::getText)
                .filter(texto -> !texto.isBlank())
                .collect(Collectors.toList());

        return textos.get(new Random().nextInt(textos.size()));
    }
}
