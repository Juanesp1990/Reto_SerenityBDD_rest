Feature: actualizar datos de registro
  como un usuario registrado del sistema
  necesito actualizar el campo trabajo asignado a mi nombre

  @actualizarReqres
  Scenario: Registro actualizado completamente
    Given el usuario está en la página de actualización de reqres con usuario "morpheus" y trabajo "zion resident"
    When cuando el usuario hace una petición de actualizacion put
    Then el usuario deberá obtener un codigo de respuesta 200 y los datos actualizados

  @actualizarJson
  Scenario: Registro actualizado parcialmente
    Given el usuario está en la página de actualización de Json con el título "dale a tu cuerpo alegria macarena"
    When cuando el usuario hace una petición de actualizacion
    Then el usuario deberá ver un codigo de respuesta 200 y los datos ingresados