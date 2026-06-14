Feature: Inicio de sesión

  @login
  Scenario Outline: Login exitoso con credenciales válidas
    Given que el usuario se encuentra en la página de inicio de sesión
    When ingresa "<usuario>" y "<contrasena>"
    Then debe mostrar el usuario logueado

    Examples:
      | usuario | contrasena  |
      | Név123  | password123 |
      |3543     |232          |
