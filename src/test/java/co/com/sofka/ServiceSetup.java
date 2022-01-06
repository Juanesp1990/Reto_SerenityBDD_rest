package co.com.sofka;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.HashMap;


public class ServiceSetup {
    protected static final String URL_BASE_REQRES = "https://reqres.in/api";
    protected static final String RESOURCE_POST_REQRES = "/users";
    protected static final String RESOURCE_PUT_REQRES = "/users/2";

    protected static final String URL_BASE_JSON="https://jsonplaceholder.typicode.com";
    protected static final String RESOURCE_POST_JSON="/posts";
    protected static final String RESOURCE_PUT_JSON="/posts/1";

    protected final Actor actor = new Actor("Juan");

    protected void setupReqres () {
        actorCanReqres();
    }

    protected void setupJson () {
        actorCanJson();
    }

    private void actorCanReqres () {
        actor.can(CallAnApi.at(URL_BASE_REQRES));
    }

    private void actorCanJson () {
        actor.can(CallAnApi.at(URL_BASE_JSON));
    }


}
