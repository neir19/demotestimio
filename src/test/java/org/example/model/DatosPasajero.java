package org.example.model;

public record DatosPasajero(
    int cantidad
) {
    public static DatosPasajero deReserva(int cantidad) {
        return new DatosPasajero(cantidad);
    }
}
