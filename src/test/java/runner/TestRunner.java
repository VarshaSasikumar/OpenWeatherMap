//package runner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//import org.testng.annotations.DataProvider;
//
//
//@CucumberOptions(features = "src/test/resources/features",
//        glue = {"Stepdefnition"},
//        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
//        monochrome = true,
//        publish = true)
//public class TestRunner extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//}

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Loginpage.feature",
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        monochrome = true,
        publish = true
)

public class TestRunner {

}
