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
        plugin = {"pretty","html:output/reports_html.html"}

//        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class Run {
}
