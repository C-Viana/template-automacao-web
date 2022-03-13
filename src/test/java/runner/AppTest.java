package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions (
    plugin = {"pretty", "html:target/cucumber"},
    features = "src/test/java/features",
    glue = {"steps"},
    snippets = SnippetType.CAMELCASE,
    dryRun = false,
    stepNotifications = true
    ,tags = "@test_3"
)
@RunWith(Cucumber.class)
public class AppTest 
{ 

}
