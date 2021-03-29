package behavior;

import Pages.HomePage;

public class MainBehave {

    public static void emptyToDoList() {
        HomePage.EmptyToDoList();
    }

    public static void itemListed(String todo) {
        HomePage.WriteItem(todo);
        HomePage.VerifyItem(todo);
    }

    public static void markedItemListed() throws Exception {
        HomePage.WriteItem("buy some milk");
        HomePage.VerifyItem("buy some milk");
        HomePage.ClickButton("checkBox", "buy some milk");
        HomePage.VerifyDone("buy some milk");
    }

    public static void itemsListed(String todo1, String todo2) {
        HomePage.WriteItem(todo1);
        HomePage.WriteItem(todo2);
    }

    public static void writeAndSend(String todo) {
        HomePage.WriteItem(todo);
    }

    public static void nextToItemClick(String el, String todo) throws InterruptedException {
       // HomePage.VerifyItem(todo);
        HomePage.ClickButton(el, todo);
    }

    public static void itemClick(String el) throws InterruptedException {
        HomePage.ClickButton(el, "buy some milk");
    }

    public static void seeItem(String todo) {
        HomePage.VerifyItem(todo);
    }

    public static void seeSecondItem(String todo1, String todo2) {
        HomePage.VerifySecondItem(todo1, todo2);
    }

    public static void seeItemIsDone(String todo) {
        HomePage.VerifyDone(todo);
    }

    public static void seeItemIsUndone(String todo) {
        HomePage.VerifyUndone(todo);
    }

}
