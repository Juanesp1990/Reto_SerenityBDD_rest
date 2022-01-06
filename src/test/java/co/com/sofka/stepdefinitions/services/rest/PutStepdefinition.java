package co.com.sofka.stepdefinitions.services.rest;

import co.com.sofka.ServiceSetup;
import co.com.sofka.models.PutJsonModel;
import co.com.sofka.models.PutReqresModel;
import co.com.sofka.questions.ResponseCode;
import co.com.sofka.questions.ResponseQuestionPutJson;
import co.com.sofka.questions.ResponseQuestionPutReqres;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;


import static co.com.sofka.tasks.DoPut.doPut;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutStepdefinition extends ServiceSetup {
    public static Logger LOGGER = Logger.getLogger(PutStepdefinition.class);
    private PutReqresModel putReqresModel;
    private PutJsonModel putJsonModel;

    @Given("el usuario está en la página de actualización de reqres con usuario {string} y trabajo {string}")
    public void elUsuarioEstaEnLaPaginaDeActualizacionDeReqresConUsuarioYTrabajo (String usuario, String trabajo) {
        try {
            super.setupReqres();
            putReqresModel = new PutReqresModel();
            putReqresModel.setName(usuario);
            putReqresModel.setJob(trabajo);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }


    @When("cuando el usuario hace una petición de actualizacion put")
    public void cuandoElUsuarioHaceUnaPeticionDeActualizacionPut () {
        try {
            actor.attemptsTo(doPut()
                    .withTheResource(RESOURCE_PUT_REQRES)
                    .andTheBodyRequest(bodyRequestReqres()));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }

    }

    @Then("el usuario deberá obtener un codigo de respuesta {int} y los datos actualizados")
    public void elUsuarioDeberaObtenerUnCodigoDeRespuestaYLosDatosActualizados (Integer statusCode) {
        try {
            actor.should(
                    seeThat("El codigo de respuesta es ", ResponseCode
                            .was(), equalTo(statusCode)),
                    seeThat("el campo trabajo debe contener :",
                            datos -> new ResponseQuestionPutReqres().answeredBy(actor).getJob(),
                            equalTo("zion resident"))
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }

    }

    @Given("el usuario está en la página de actualización de Json con el título {string}")
    public void elUsuarioEstaEnLaPaginaDeActualizacionDeJsonConElTitulo (String titulo) {
        try {
            super.setupJson();
            putJsonModel = new PutJsonModel();
            putJsonModel.setTitle(titulo);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }


    @When("cuando el usuario hace una petición de actualizacion")
    public void cuandoElUsuarioHaceUnaPeticionDeActualizacion () {
        try {
            actor.attemptsTo(doPut()
                    .withTheResource(RESOURCE_PUT_JSON)
                    .andTheBodyRequest(bodyRequestJson()));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }

    }

    @Then("el usuario deberá ver un codigo de respuesta {int} y los datos ingresados")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaYLosDatosIngresados (Integer statusCode) {
        try {
            actor.should(
                    seeThat("El codigo de respuesta", ResponseCode
                            .was(), equalTo(statusCode)),
                    seeThat("el mensaje que debe mostrar es",
                            datos -> new ResponseQuestionPutJson().answeredBy(actor).getTitle(),
                            equalTo("dale a tu cuerpo alegria macarena"))
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }

    }

    private String bodyRequestReqres () {
        return "{\n" +
                "    \"name\": \"" + putReqresModel.getName() + "\",\n" +
                "    \"job\": \"" + putReqresModel.getJob() + "\"\n" +
                "}";
    }

    private String bodyRequestJson () {
        return "{\n" +
                " \n" +
                "  \"title\": \"" + putJsonModel.getTitle() + "\"\n" +
                "\n" +
                "}";
    }


}
