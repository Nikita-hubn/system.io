import org.example.FirstPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest extends BaseTest {


@Test
public void buttonTest() {
    driver.get("https://systeme.io/blog/cost-of-online-course");
    String example="Please enter a valid email address";
    page=new FirstPage(driver);
    page.submitEmail();
    assertEquals(example, page.checkMessage(), "ii");
    page.clickCloseButton();
    tearDown();
}



}
