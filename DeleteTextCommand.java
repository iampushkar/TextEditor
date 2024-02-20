class DeleteTextCommand implements Command{
    TextDocument textDocument;
    String text;
    int start;
    int end;

    public DeleteTextCommand(TextDocument textDocument, int start, int end) {
        this.textDocument = textDocument;
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean execute() {
        String removalText =  textDocument.getTextByIndex(start, end);
        boolean res = textDocument.deleteText(start, end);
        if(res) this.text = removalText;
        return res;
    }

    @Override
    public boolean undo() {
        return  textDocument.insertText(text, start);
    }
}
