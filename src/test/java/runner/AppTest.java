package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions (
    features = "src/main/java/features",
    glue = {"steps"},
    snippets = SnippetType.CAMELCASE,
    dryRun = false,
    stepNotifications = true
)
@RunWith(Cucumber.class)
public class AppTest 
{

}
