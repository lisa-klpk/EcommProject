
package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


//steps.other directory if one
// tag pour lancer les tests avec le meme tag
//plugin pour generer le fichier.json le rapport
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features="src/test/resources/features",
        glue = {"steps/accountcreation"}
)

public class RunnerTest {

}


