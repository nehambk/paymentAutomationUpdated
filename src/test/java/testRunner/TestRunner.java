package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, extraGlue = {"stepDef"},
plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt", "summary", "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
         snippets = CucumberOptions.SnippetType.CAMELCASE, monochrome = true, tags = "@Regression")

public class TestRunner {

}
