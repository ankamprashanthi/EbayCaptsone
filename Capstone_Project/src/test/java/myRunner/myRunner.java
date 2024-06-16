package myRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

		features="src//test//java//feature//inValidLogin.feature",

		glue="stepDef",

		plugin= {"pretty","html:target/invalid_Reports"},

		monochrome=true

		)

public class myRunner {

}