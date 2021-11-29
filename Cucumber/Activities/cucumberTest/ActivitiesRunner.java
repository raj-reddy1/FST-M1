package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    //tags = "@activity1_1",
    //tags = "@activity1_2",
    //tags = "@activity1_3",
    //tags = "@activity2_4",
    tags = "@activity2_5",
    //tags = "@SimpleAlert",
    plugin = { "pretty", "html:target/cucumber-reports/html-report.html" },
    //plugin = { "pretty", "json:target/cucumber-reports/json-report.json" },
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}
