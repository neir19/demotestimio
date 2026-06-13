Feature: Filtrar destinos por precio
  Como usuario quiero filtrar destinos por precio maximo
  Para encontrar viajes dentro de mi presupuesto

  @FiltrarPorPrecio @Regresion
  Scenario Outline: Filtrar destinos por diferentes rangos de precio maximo
    Given que el usuario se encuentra en la seccion de seleccion de destinos
    When el usuario ajusta el filtro de precio maximo a "<precio_maximo>" dolares
    Then todos los resultados de viajes mostrados deben tener un costo menor o igual a "<precio_maximo>" dolares

    Examples:
      | precio_maximo |
      | 500           |
      | 1200          |
      | 250           |
