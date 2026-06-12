package org.example.model;

public record DatosPersonales(
    String nombre,
    String email,
    String socialSecurityNumber,
    String telefono
) {
    public static DatosPersonales delCliente(String nombre, String email, String socialSecurityNumber, String telefono) {
        return new DatosPersonales(nombre, email, socialSecurityNumber, telefono);
    }
}
