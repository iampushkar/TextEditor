package src.main.java.service.impl;

import src.main.java.service.Command;
import src.main.java.service.TextDocument;

public class ReplaceTextCommand implements Command {
    private String newText;
    private String oldText;
    TextDocument document;
    String text;
    int position;

    public ReplaceTextCommand(TextDocument document, String oldtext, String newText, int position) {
        this.document = document;
        this.oldText = oldtext;
        this.newText = newText;
        this.position = position;
    }

    @Override
    public void execute() {
        document.replaceText(position, oldText, newText);
    }

    @Override
    public void undo() {
        document.replaceText(position, newText, oldText);
    }

    @Override
    public void redo() {
        document.replaceText(position,oldText, newText);

    }
}
