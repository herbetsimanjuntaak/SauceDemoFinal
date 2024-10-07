package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/web/WebTestingSauceDemo-report.html", "json:reports/web/WebTestingSauceDemo-report.json"},
        glue = {"stepDef"},
        features = {"src/test/java/features"}
)
public class WebRunner {
}
