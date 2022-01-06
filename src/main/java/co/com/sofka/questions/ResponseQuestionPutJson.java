package co.com.sofka.questions;

import co.com.sofka.models.PutJsonModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseQuestionPutJson implements Question<PutJsonModel> {
    @Override
    public PutJsonModel answeredBy (Actor actor) {
        return SerenityRest.lastResponse().as(PutJsonModel.class);
    }
}
