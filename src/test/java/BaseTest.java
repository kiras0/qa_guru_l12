import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

public class BaseTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }
}
