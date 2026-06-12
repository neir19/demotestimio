package org.example.model;

public record DatosReserva(
    String fechaIda,
    String fechaRegreso,
    String adultos,
    String ninos,
    String rangoPrecio,
    String destino
) {
    public static DatosReserva deViaje(String fechaIda, String fechaRegreso, String adultos,
                                        String ninos, String rangoPrecio, String destino
                                        ) {
        return new DatosReserva(fechaIda, fechaRegreso, adultos, ninos, rangoPrecio, destino);
    }
}
