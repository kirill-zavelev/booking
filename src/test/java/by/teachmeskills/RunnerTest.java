package by.teachmeskills;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue = "by.teachmeskills.step",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"})
public class RunnerTest extends AbstractTestNGCucumberTests {
}
