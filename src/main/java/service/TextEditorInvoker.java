package src.main.java.service;

import src.main.java.service.impl.InsertTextCommand;

import java.util.Stack;

public class TextEditorInvoker {
    TextDocument document;
    Command command;
    // history of commands executed
    Stack<Command> commandHistory = new Stack<>();
    Stack<Command> undoHistory = new Stack<>();

    public TextEditorInvoker(TextDocument textDocument){
        this.document = textDocument;
    }

    public TextEditorInvoker() {

    }

    public void setCommand(Command command){
        this.command=command;
    }

    public void execute(Command command){
        command.execute();
        commandHistory.push(command);
    }

    public void undo(){
        if(!commandHistory.isEmpty()){
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
            undoHistory.push(lastCommand);
        }
    }

    public void redo(){
        if(!undoHistory.isEmpty()){
            Command lastUndoCommand = undoHistory.pop();
            lastUndoCommand.execute();
            commandHistory.push(lastUndoCommand);
        }
    }



}
