class InsertTextCommand implements Command{
    TextDocument textDocument;
    String text;
    int position;

    public InsertTextCommand(TextDocument textDocument, String text, int position) {
        this.textDocument = textDocument;
        this.text = text;
        this.position = position;
    }

    @Override
    public boolean execute() {
        return textDocument.insertText(text, position);
    }

    @Override
    public boolean undo() {
        return  textDocument.deleteText(position, position + text.length());
    }
}
