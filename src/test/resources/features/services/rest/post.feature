Feature: crear un nuevo registro
  como un usuario de la página quiero crear un nuevo registro
  asignando un nombre de usuario y un  trabajo

  Scenario: Creación de registro Reqres
    Given el usuario está en la página Reqres ingresa el nombre "morpheus" y el campo trabajo "leader"
    When cuando el usuario hace una petición de creación de registro
    Then el usuario deberá ver un codigo de respuesta 201 y los datos creados

  Scenario: Creación de registro Json
    Given el usuario está en la página de creacion de Json ingresa el nombre "Juanes"
    When cuando el usuario hace una petición de creación post
    Then el usuario deberá ver un codigo 201 y el dato creado