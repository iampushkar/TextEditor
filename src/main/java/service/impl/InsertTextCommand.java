package src.main.java.service.impl;

import src.main.java.service.Command;
import src.main.java.service.TextDocument;

public class InsertTextCommand implements Command {
    TextDocument document;
    String text;
    int position;

    public InsertTextCommand(TextDocument document, String text, int position) {
        this.document = document;
        this.text = text;
        this.position = position;
    }

    @Override
    public void execute() {
        document.insertText(position,text);
    }

    @Override
    public void undo() {
        document.deleteText(position, text.length());
    }

    @Override
    public void redo() {
        document.insertText(position,text);
    }
}
