package org.example.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import org.example.ui.PaginaDestinos;


import static net.serenitybdd.screenplay.ensure.Ensure.that;
import java.util.List;

public class ValidarValores implements Interaction {
    private  int valor;

    public ValidarValores(String valor) {
        this.valor = Integer.parseInt(valor);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> elementos = PaginaDestinos.CAMPO_VALOR.resolveAllFor(actor);
        for (WebElementFacade elemento : elementos) {
            System.out.println("elemento "+elemento);
            double precio = Double.parseDouble(
                    elemento.getText()
                            .replace("$", "")
                            .replace(",", "")
                            .trim()
            );

            System.out.println("Valor: "+precio+" debe ser menor que o igual que "+valor);






            if (precio >valor) {
                throw new AssertionError(
                        "Se encontró un valor mayor"
                );
            }

      actor.attemptsTo(Ensure);


        }
    }
    public static Performable de(String valor){
        return Tasks.instrumented(ValidarValores.class,valor);
    }
}
