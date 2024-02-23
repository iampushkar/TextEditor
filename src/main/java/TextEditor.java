package src.main.java;

import src.main.java.controller.TextEditorController;
import src.main.java.service.Command;
import src.main.java.service.TextDocument;
import src.main.java.service.TextEditorInvoker;
import src.main.java.service.impl.InsertTextCommand;

public class TextEditor {
    public static void main(String[] args) {
        new TextEditorController().runApplication();


    }
}
