package org.example.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import net.serenitybdd.screenplay.targets.Target;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CargarArchivo implements Interaction {
    private final String rutaArchivo;
    private final Target target;

    public CargarArchivo(String rutaArchivo, Target target) {
        this.rutaArchivo = rutaArchivo;
        this.target = target;
    }

    public static CargarArchivo en(Target target, String rutaArchivo) {
        return Instrumented.instanceOf(CargarArchivo.class).withProperties(rutaArchivo, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        var webElement = target.resolveFor(actor);
        Path rutaAbsoluta = Paths.get(rutaArchivo);
        if (!rutaAbsoluta.isAbsolute()) {
            rutaAbsoluta = Paths.get(System.getProperty("user.dir")).resolve(rutaArchivo).normalize();
        }
        if (!rutaAbsoluta.toFile().exists()) {
            throw new IllegalArgumentException("Archivo no encontrado: " + rutaAbsoluta);
        }

        webElement.sendKeys(rutaAbsoluta.toAbsolutePath().toString());
    }
}