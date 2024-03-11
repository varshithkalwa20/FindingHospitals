package Test_Runner;


import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@Test
@CucumberOptions(tags = "", features = {".//Feature_Files/FindingHospitals.feature"}, glue = {"Step_Definitions"},
                 plugin = {})

public class testrun extends AbstractTestNGCucumberTests {

}
