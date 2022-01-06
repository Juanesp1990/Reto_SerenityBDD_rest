package co.com.sofka.runners.services.rest.cucumber;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/services/rest/post.feature",
                    "src/test/resources/features/services/rest/put.feature"},
        glue = {"co.com.sofka.stepdefinitions.services.rest"}
)
public class PostPutTestCucumber {
}
