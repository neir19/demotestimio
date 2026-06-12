package org.example.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class IngresarValorReact implements Interaction {
    private final Target target;
    private final String value;

    public IngresarValorReact(Target target, String value) {
        this.target = target;
        this.value = value;
    }

    public static IngresarValorReact en(Target target, String value) {
        return Instrumented.instanceOf(IngresarValorReact.class).withProperties(target, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement element = target.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();

        actor.attemptsTo(Click.on(target));

        js.executeScript(
            "const input = arguments[0];" +
            "const value = arguments[1];" +
            "const nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
            "nativeInputValueSetter.call(input, value);" +
            "input.dispatchEvent(new Event('input', { bubbles: true }));" +
            "input.dispatchEvent(new Event('change', { bubbles: true }));" +
            "input.dispatchEvent(new Event('blur', { bubbles: true }));",
            element, value
        );
    }
}
