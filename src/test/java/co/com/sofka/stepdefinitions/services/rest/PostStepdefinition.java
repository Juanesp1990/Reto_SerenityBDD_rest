package co.com.sofka.stepdefinitions.services.rest;

import co.com.sofka.ServiceSetup;
import co.com.sofka.models.PostJsonModel;
import co.com.sofka.models.PostReqresModel;
import co.com.sofka.questions.ResponseCode;
import co.com.sofka.questions.ResponseQuestionPostJson;
import co.com.sofka.questions.ResponseQuestionPostReqres;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.tasks.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostStepdefinition extends ServiceSetup {
    public static Logger LOGGER = Logger.getLogger(PostStepdefinition.class);
    private PostReqresModel postReqresModel;
    private PostJsonModel postJsonModel;

    @Given("el usuario está en la página Reqres ingresa el nombre {string} y el campo trabajo {string}")
    public void elUsuarioEstaEnLaPaginaReqresIngresaElNombreYElCampoTrabajo (String usuario, String trabajo) {
        try {
            super.setupReqres();
            postReqresModel = new PostReqresModel();
            postReqresModel.setName(usuario);
            postReqresModel.setJob(trabajo);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }

    }

    @When("cuando el usuario hace una petición de creación de registro")
    public void cuandoElUsuarioHaceUnaPeticionDeCreacionDeRegistro () {
        try {

            actor.attemptsTo(doPost()
                    .withTheResource(RESOURCE_POST_REQRES)
                    .andTheBodyRequest(bodyRequestReqres()));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }

    }

    @Then("el usuario deberá ver un codigo de respuesta {int} y los datos creados")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaYLosDatosCreados (Integer statusCode) {
        try {
            actor.should(
                    seeThat("El codigo de respuesta", ResponseCode
                            .was(), equalTo(statusCode)),
                    seeThat("el campo del lider es ",
                            datos -> new ResponseQuestionPostReqres().answeredBy(actor).getJob(),
                            equalTo("leader"))
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }

    }


    @Given("el usuario está en la página de creacion de Json ingresa el nombre {string}")
    public void elUsuarioEstaEnLaPaginaDeCreacionDeJsonIngresaElNombre (String titulo) {
        try {
            super.setupJson();
            postJsonModel = new PostJsonModel();
            postJsonModel.setTitle(titulo);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }


    @When("cuando el usuario hace una petición de creación post")
    public void cuandoElUsuarioHaceUnaPeticionDeCreacionPost () {
        try {
            actor.attemptsTo(doPost()
                    .withTheResource(RESOURCE_POST_JSON)
                    .andTheBodyRequest(bodyRequestJson()));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }

    }

    @Then("el usuario deberá ver un codigo {int} y el dato creado")
    public void elUsuarioDeberaVerUnCodigoYElDatoCreado (Integer statusCode) {
        try {
            PostJsonModel modelo;
            modelo = new ResponseQuestionPostJson().answeredBy(actor);
            System.out.println(modelo.getTitle());
            actor.should(
                    seeThat("El codigo de respuesta", ResponseCode
                            .was(), equalTo(statusCode)),
                    seeThat("el campo del l",
                            datos -> new ResponseQuestionPostJson().answeredBy(actor).getTitle(),
                            equalTo("Juanes"))
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private String bodyRequestReqres () {
        return "{\n" +
                "    \"name\": \"" + postReqresModel.getName() + "\",\n" +
                "    \"job\": \"" + postReqresModel.getJob() + "\"\n" +
                "}";
    }

    private String bodyRequestJson () {
        return "{\n" +
                "\n" +
                "  \"title\": \"" + postJsonModel.getTitle() + "\"\n" +
                "\n" +
                "}";
    }

}
