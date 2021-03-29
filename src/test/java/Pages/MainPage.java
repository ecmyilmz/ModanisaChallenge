package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runner.RunCucumber;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import static junit.framework.TestCase.fail;

public class MainPage extends RunCucumber {

    public static Properties selectors;


    public MainPage(Properties selectors) {

        this.selectors = selectors;

        try {
            selectors.load(MainPage.class.getResourceAsStream("/selectors/selector.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String id) {
        Optional<String> opt = Optional.ofNullable(selectors.getProperty(id));
        if (opt.isPresent())
            return opt.get();
        else
            fail("Error in selectors.properties or Gherkin file ;" + id + " could not be found in selectors.properties!");
        return null;
    }


    public static WebElement getElement(String sel) {
        return driver.findElement(getBy(sel));
    }

    public static List<WebElement> getElements(String sel) {
        return driver.findElements(getBy(sel));
    }


    public static By getBy(String tag) {
        if (tag.substring(0, 1).equals("/"))
            return By.xpath(tag);
        else return By.id(tag);
    }

}
