Feature: Calculo de tarifas
  Como usuario quiero que el sistema calcule correctamente las tarifas
  Para asegurar que el precio total refleje la cantidad de pasajeros

  @CalculoTarifas @Regresion
  Scenario Outline: Calcular correctamente el precio para multiples pasajeros
    Given que el usuario selecciono un vuelo disponible
    When agrega <pasajeros> pasajeros a la reserva
    Then el sistema debe actualizar el valor total
    And el precio debe corresponder a la cantidad de pasajeros seleccionados

    Examples:
      | pasajeros |
      | 1         |
      | 2         |
      | 3         |
