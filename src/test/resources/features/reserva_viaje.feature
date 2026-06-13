Feature: Reserva de viaje en Testim.io
  Como usuario quiero reservar un viaje completo
  Para confirmar la reserva exitosamente

  @reserva
  Scenario Outline: Reservar un viaje exitosamente
    Given el usuario esta en la pagina de inicio
    When el usuario agenda un viaje con fecha ida "<fechaIda>", fecha regreso "<fechaRegreso>", <adultos> adultos, <ninos> ninos, destino "<destino>"
    And carga mas destinos
    And filtra por precio "<rangoPrecio>"
    And selecciona el destino "<destino>"
    And completa el formulario con nombre "<nombre>", email "<email>", ssn "<socialSecurityNumber>", telefono "<telefono>"
    And adjunta el archivo "<rutaArchivo>"
    And ingresa un codigo "<codigoPromocional>"
    And acepta los terminos
    And realiza el pago
    Then deberia ver el mensaje "Destination Booked"

    Examples:
      | fechaIda   | fechaRegreso | adultos | ninos | rangoPrecio | destino | codigoPromocional | nombre      | email           | socialSecurityNumber | telefono     | rutaArchivo                 |
      | 2026-07-15 | 2026-07-22   | 2       | 1     | 1400        | Tongli  | PROMO2026         | Juan Perez  | juan@email.com  | 123-45-6789          | +17878795412 | src/test/resources/test.txt |
      | 2026-08-1  | 2026-08-17   | 1       | 2     | 1300        | Bahamas | BIENVENIDO        | Maria Gomez | maria@email.com | 987-65-4321          | +17877654321 | src/test/resources/test.txt |
