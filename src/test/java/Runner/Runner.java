package Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
//        Login
//        features = "src/test/java/Feature/Login.feature",
//        plugin = {"pretty", "html:target/cucumber-reports/Login.html"},

//        ResetPassword
        features = "src/test/java/Feature/User/FollowUnfollowUser.feature",
        plugin = {"pretty", "html:target/cucumber-reports/FollowUnfollowUser.html"},
        monochrome = true,
        glue = {"Steps"}
)

@Test
public class Runner {
}
