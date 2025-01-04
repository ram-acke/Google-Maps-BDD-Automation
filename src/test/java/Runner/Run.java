package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".//Features/openMap.feature"},
        glue="StepDefinition",
        dryRun = false,
//        dryRun = true,
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
)
public class Run {
}
