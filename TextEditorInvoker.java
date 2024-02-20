import java.util.Stack;

public class TextEditorInvoker {
    Stack<Command> commandHistory = new Stack<>();
    Stack<Command> undoHistory = new Stack<>();

    public boolean execute(Command command){
        boolean res = command.execute();
        if (res) {
            commandHistory.add(command);
        }
        return res;
    }

    public boolean undo(){
        if (!commandHistory.isEmpty()){
            Command last = commandHistory.pop();
            boolean res = last.undo();
            if (res){
                undoHistory.add(last);
            }
            return res;
        }
        return false;
    }

    public boolean redo(){
        if (!undoHistory.isEmpty()){
            Command last = undoHistory.pop();
            boolean res = last.execute();
            if (res){
                commandHistory.add(last);
            }
            return res;
        }
        return false;
    }
}
