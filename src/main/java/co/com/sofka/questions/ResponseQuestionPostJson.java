package co.com.sofka.questions;

import co.com.sofka.models.PostJsonModel;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseQuestionPostJson implements Question <PostJsonModel>{

    @Override
    public PostJsonModel answeredBy (Actor actor) {
        return SerenityRest.lastResponse().as(PostJsonModel.class);
    }
}
