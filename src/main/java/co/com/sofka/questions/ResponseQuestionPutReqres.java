package co.com.sofka.questions;

import co.com.sofka.models.PutReqresModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseQuestionPutReqres implements Question <PutReqresModel>{
    @Override
    public PutReqresModel answeredBy (Actor actor) {
        return SerenityRest.lastResponse().as(PutReqresModel.class);
    }
}
