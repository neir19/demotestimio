package org.example.Utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public abstract class Utils {
    public static String[] separar(String cadena) {
        return cadena.split("-");
    }

    public static LocalDate parseFecha(String cadena) {
        String[] partes = separar(cadena);
        return LocalDate.of(
                Integer.parseInt(partes[0]),
                Integer.parseInt(partes[1]),
                Integer.parseInt(partes[2])
        );
    }

    public static String obtenerMes(int numeroMes) {
        return Month.of(numeroMes)
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public static int[] obtenerMesYAnioActual() {
        LocalDate fechaActual = LocalDate.now();

        return new int[]{
                fechaActual.getMonthValue(),
                fechaActual.getYear()
        };
    }

    public static YearMonth mesVisibleInicial(int anioObjetivo) {
        YearMonth actual = YearMonth.now();
        return anioObjetivo == actual.getYear()
                ? actual
                : YearMonth.of(anioObjetivo, 1);
    }

    public static void validarFecha(String[] fecha) {
        validarFecha(LocalDate.of(
                Integer.parseInt(fecha[0]),
                Integer.parseInt(fecha[1]),
                Integer.parseInt(fecha[2])
        ));
    }

    public static void validarFecha(LocalDate fecha) {
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Fecha no válida: " + fecha +
                            ". La fecha debe ser igual o posterior a la fecha actual."
            );
        }
    }
}


