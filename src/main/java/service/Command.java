package src.main.java.service;

public interface Command {
    default void execute(){
        System.out.println("Perform given command");
    }

    default void undo(){
        System.out.println("Perform undo command");
    }
    default void redo(){
        System.out.println("Perform redo command");
    }
}
