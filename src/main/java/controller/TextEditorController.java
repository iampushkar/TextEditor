package src.main.java.controller;

import src.main.java.service.Command;
import src.main.java.service.TextDocument;
import src.main.java.service.TextEditorInvoker;
import src.main.java.service.impl.DeleteTextCommand;
import src.main.java.service.impl.InsertTextCommand;
import src.main.java.service.impl.ReplaceTextCommand;

import java.util.Scanner;

public class TextEditorController {
    TextDocument document= new TextDocument();
    TextEditorInvoker invoker = new TextEditorInvoker();
    Scanner sc = new Scanner(System.in);
    // insert text

    public void runApplication() {
        while (true){
            showMenu();
            String userAction = getUserInput("Enter the action you want to perform ");
            performAction(userAction);
        }
    }

    private void performAction(String userAction) {
        switch (userAction){
            case "1":
                Command insertTextCommand = new InsertTextCommand(document, "Hello World!!", 0);
                invoker.execute(insertTextCommand);
                invoker.undo();
                invoker.redo();
                System.out.println(document.getContext());
                break;
            case "2":
                Command deleteTextCommand = new DeleteTextCommand(document, "Hel", 0);
                invoker.execute(deleteTextCommand);
                invoker.undo();
                invoker.redo();
                System.out.println(document.getContext());
                break;
            case "3":
                Command replaceTextCommand = new ReplaceTextCommand(document, "World", "India", 6);
                invoker.execute(replaceTextCommand);
                //invoker.undo();
                //invoker.redo();
                System.out.println(document.getContext());
                break;
            case "4":
                System.exit(200);
                break;
            default:
                System.out.println("Enter the valid input!!");
                break;

        }
    }

    private String getUserInput(String s) {
        System.out.print(s + " : ");
        return sc.nextLine();
    }

    private void showMenu() {
        System.out.println("Welcome to Text Editor App");
        System.out.println("Pick the action items : ");
        System.out.println("1. Insert Text");
        System.out.println("2. Delete Text");
        System.out.println("3. Replace Text");
        System.out.println("4. Exit!!");
    }
}
