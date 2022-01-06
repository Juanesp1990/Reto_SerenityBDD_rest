package co.com.sofka.questions;

import co.com.sofka.models.PostReqresModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseQuestionPostReqres implements Question <PostReqresModel>{
    @Override
    public PostReqresModel answeredBy (Actor actor) {
        return SerenityRest.lastResponse().as(PostReqresModel.class);
    }
}
