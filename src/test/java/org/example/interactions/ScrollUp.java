package org.example.interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollUp implements Interaction {

    public static ScrollUp toTheTop() {
        return new ScrollUp();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        // Hace scroll hasta la parte superior de la página
        js.executeScript("window.scrollTo(0, 0);");
    }
}
