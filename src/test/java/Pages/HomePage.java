package Pages;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import runner.RunCucumber;

import java.util.List;
import java.util.Properties;

public class HomePage extends RunCucumber{


    public static By toDoList = By.xpath("/html/body/section/section/ul/li");
    public static By textBox = By.xpath("/html/body/section/header/input");
    public static By checkBox = By.xpath("/html/body/section/section/ul/li/div/input");
    public static By toDoComletedItem = By.xpath("//li[@class='todo completed']");
    public static By toDoItem = By.xpath("//li[@class='todo']");
    public static By deletedItem = By.xpath("/html/body/section/section/ul/li[2]/div/button");

    public static By getBy(String tag) {
      return By.xpath(tag);
    }

    public static void EmptyToDoList(){
        int size = driver.findElements(toDoList).size();
        Assert.assertTrue(size == 0);
    }

    public static void WriteItem(String text) {

        WebElement input2 = driver.findElement(textBox);
        input2.sendKeys(text);
        input2.sendKeys(Keys.ENTER);

    }

    public static void VerifyItem(String text) {
        List<WebElement> toDoListItems = driver.findElements(toDoList);
        for (int i = 0; i < toDoListItems.size(); i++) {
            String todoText = toDoListItems.get(i).getText();
            Assert.assertEquals(text, todoText);
        }
    }

    public static void VerifySecondItem(String secondText, String firstText){
        List<WebElement> toDoListItems = driver.findElements(toDoList);
            Assert.assertEquals(firstText,toDoListItems.get(0).getText());
            Assert.assertEquals(secondText,toDoListItems.get(1).getText());
        }

    public static void ClickButton(String element, String text) throws InterruptedException {
        List<WebElement> toDoListItems = driver.findElements(toDoList);
        List<WebElement> clickableButtons = driver.findElements(getBy(element));

        Thread.sleep(1000);
        for(int i=0; i<toDoListItems.size(); i++){
            if(toDoListItems.get(i).getText().equals(text)){
                System.out.println(clickableButtons);
                clickableButtons.get(i).click();
            }
        }
    }

    public static void VerifyDone(String text) {
        List<WebElement> DoneItems = driver.findElements(toDoComletedItem);
        Assert.assertFalse(DoneItems.size() == 0);
        for (int i = 0; i < DoneItems.size(); i++) {
            Assert.assertEquals(text, DoneItems.get(i).getText());
        }
    }

    public static void VerifyUndone(String text){
        List<WebElement> UndoneItems = driver.findElements(getBy("toDoItem"));
        Assert.assertFalse(UndoneItems.size() == 0);
        for (int i = 0; i < UndoneItems.size(); i++) {
            Assert.assertEquals(text,UndoneItems.get(i).getText());
        }
    }

//    public static void DeletedItem(String text) throws InterruptedException {
//        List<WebElement> toDoListItems = driver.findElements(toDoList);
//        List<WebElement> deletedItems = driver.findElements(deletedItem);
//        System.out.println(deletedItems.size());
//        Thread.sleep(1000);
//        for(int i=0; i<toDoListItems.size(); i++){
//            if(toDoListItems.get(i).getText().equals(text)){
//                deletedItems.get(i).click();
//            }
//        }
//    }

}
