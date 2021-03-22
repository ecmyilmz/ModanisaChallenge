package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.List;
import java.util.Properties;


public class HomePage extends MainPage{

    public HomePage(Properties selectors) {
        super(selectors);
    }

    public static void EmptyToDoList2(){
        int size = driver.findElements(getBy(getPropertyValue("toDoList"))).size();
        Assert.assertTrue(size == 0);
    }

    public static void WriteItem(String text) {
        WebElement input2 = driver.findElement(getBy(getPropertyValue("textBox")));
        input2.sendKeys(text);
        input2.sendKeys(Keys.ENTER);
    }

    public static void VerifyItem(String text) {
        List<WebElement> toDoListItems = driver.findElements(getBy(getPropertyValue("toDoList")));
        for (int i = 0; i < toDoListItems.size(); i++) {
            String todoText = toDoListItems.get(i).getText();
           if(todoText.equals(text)){
               Assert.assertEquals(text, todoText);
               return;
           }
        }
    }

    public static void VerifySecondItem(String secondText, String firstText){
        List<WebElement> toDoListItems = driver.findElements(getBy(getPropertyValue("toDoList")));
            Assert.assertEquals(firstText,toDoListItems.get(0).getText());
            Assert.assertEquals(secondText,toDoListItems.get(1).getText());
        }

    public static void ClickButton(String element, String text) throws InterruptedException {
        List<WebElement> toDoListItems = driver.findElements(getBy(getPropertyValue("toDoList")));
        List<WebElement> clickableButtons = driver.findElements(getBy(getPropertyValue(element)));
        Thread.sleep(1000);
        for(int i=0; i<toDoListItems.size(); i++){
            if(toDoListItems.get(i).getText().equals(text)){
                if(element.equals("deleteButton")){
                    Actions builder = new Actions(driver);
                    builder.moveToElement(toDoListItems.get(i)).perform();
                }
                clickableButtons.get(i).click();
            }
        }
    }

    public static void VerifyDone(String text) {
        List<WebElement> DoneItems = driver.findElements(getBy(getPropertyValue("toDoComletedItem")));
        Assert.assertFalse(DoneItems.size() == 0);
        for (int i = 0; i < DoneItems.size(); i++) {
            Assert.assertEquals(text, DoneItems.get(i).getText());
        }
    }

    public static void VerifyUndone(String text){
        List<WebElement> UndoneItems = driver.findElements(getBy(getPropertyValue("toDoItem")));
        Assert.assertFalse(UndoneItems.size() == 0);
        for (int i = 0; i < UndoneItems.size(); i++) {
            Assert.assertEquals(text,UndoneItems.get(i).getText());
        }
    }

}
