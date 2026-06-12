package org.example.model;

public record DatosCredenciales(
        String usuario,
        String contrasena
) {
    public static DatosCredenciales deAcceso(String usuario, String contrasena) {
        return new DatosCredenciales(usuario, contrasena);
    }
}
