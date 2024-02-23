package src.main.java.service.impl;

import src.main.java.service.Command;
import src.main.java.service.TextDocument;

public class DeleteTextCommand implements Command {
    TextDocument document;
    String text;
    int start;

    public DeleteTextCommand(TextDocument document, String text, int start) {
        this.document = document;
        this.text = text;
        this.start = start;
    }


    @Override
    public void execute() {
        document.deleteText(start,text.length());
    }

    @Override
    public void undo() {
        document.insertText(start, text);
    }

    @Override
    public void redo() {
        document.deleteText(start,text.length());
    }
}
