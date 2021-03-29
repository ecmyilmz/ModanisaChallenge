package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;


public class HomePage extends MainPage {

    public HomePage(Properties selectors) {
        super(selectors);
    }

    public static void EmptyToDoList() {
        int size = getElements(getPropertyValue("toDoList")).size();
        Assert.assertTrue(size == 0);
    }

    public static void WriteItem(String text) {
        WebElement input2 = getElement(getPropertyValue("textBox"));
        input2.sendKeys(text);
        input2.sendKeys(Keys.ENTER);
    }

    public static void VerifyItem(String text) {
        List<WebElement> toDoListItems = getElements(getPropertyValue("toDoList"));
        boolean verify = false;
        for (int i = 0; i < toDoListItems.size(); i++) {
            String todoText = toDoListItems.get(i).getText();
            if (todoText.equals(text)) {
                Assert.assertEquals(text, todoText);
                verify = true;
            }
        }
        Assert.assertFalse( verify == false, "Todo List Item could not found");
    }

    public static void VerifySecondItem(String secondText, String firstText) {
        List<WebElement> toDoListItems = getElements(getPropertyValue("toDoList"));
        Assert.assertEquals(firstText, toDoListItems.get(0).getText());
        Assert.assertEquals(secondText, toDoListItems.get(1).getText());
    }

    public static void ClickButton(String element, String text) throws InterruptedException {
        List<WebElement> toDoListItems = getElements(getPropertyValue("toDoList"));
        List<WebElement> clickableButtons = getElements(getPropertyValue(element));
        boolean verify = false;
        for (int i = 0; i < toDoListItems.size(); i++) {
            if (toDoListItems.get(i).getText().equals(text)) {
                if (element.equals("deleteButton")) {
                    Actions builder = new Actions(driver);
                    builder.moveToElement(toDoListItems.get(i)).perform();
                }
                clickableButtons.get(i).click();
                verify = true;
            }
        }
        Assert.assertFalse( verify == false, "Text could not found");
    }

    public static void VerifyDone(String text) {
        List<WebElement> DoneItems = getElements(getPropertyValue("toDoComletedItem"));
        Assert.assertFalse(DoneItems.size() == 0);
        for (int i = 0; i < DoneItems.size(); i++) {
            Assert.assertEquals(text, DoneItems.get(i).getText());
        }
    }

    public static void VerifyUndone(String text) {
        List<WebElement> UndoneItems = getElements(getPropertyValue("toDoItem"));
        Assert.assertFalse(UndoneItems.size() == 0);
        for (int i = 0; i < UndoneItems.size(); i++) {
            Assert.assertEquals(text, UndoneItems.get(i).getText());
        }
    }

}
