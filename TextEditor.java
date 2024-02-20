import java.util.Scanner;

class TextEditor {

    void printOptions(){
        System.out.println("Options:");
        System.out.println("1. Add Text");
        System.out.println("2. Delete Text");
        System.out.println("3. Undo ");
        System.out.println("4. Redo ");
        System.out.println("5. Show Text ");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    int getIntInput(java.util.Scanner scanner, String message){
        System.out.println(message);
        int inp = scanner.nextInt();
        scanner.nextLine();
        return inp;
    }

    String getStringInput(java.util.Scanner scanner, String message){
        System.out.println(message);
        String inp = scanner.next();
        scanner.nextLine();
        return inp;
    }

    void printOutput(boolean result){
        if (result){
            System.out.println("SUCCESS !!!");
        }else{
            System.out.println("FAILED !!!");
        }
    }

    void doActionsForOption(int option, java.util.Scanner scanner, TextEditorInvoker invoker, TextDocument document){
        System.out.printf("Option selected %s", option);
        System.out.println();
        switch (option) {
            case 1:
                int insertPosition = 0;
                if (document.getSize() > 0){
                    insertPosition = getIntInput(scanner, "Give position to insert. Min: 0. Max: " +  document.getSize());
                }
                String text = getStringInput(scanner, "Give text to insert");
                boolean res = invoker.execute(new InsertTextCommand(document, text, insertPosition));
                printOutput(res);
                return;
            case 2:
                int start = getIntInput(scanner, "Give start index to delete. Min: 0. Max: " +  document.getSize());
                int end = getIntInput(scanner, "Give end index to delete. Min: 0. Max: " +  document.getSize());
                res = invoker.execute(new DeleteTextCommand(document, start, end));
                printOutput(res);
                return;
            case 3:
                res = invoker.undo();
                printOutput(res);
                return;
            case 4:
                res = invoker.redo();
                printOutput(res);
                return;
            case 5:
                System.out.println("Current Text Below -->");
                System.out.println(document.getText());
                return;
            case 6:
                System.out.println("Exiting the application.");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
                System.out.println();
        }

    }
    public void start() {
        TextDocument document = new TextDocument();
        TextEditorInvoker invoker = new TextEditorInvoker();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try{
                printOptions();
                int choice = getIntInput(scanner, "");
                doActionsForOption(choice, scanner, invoker, document);
            }catch (Exception e){
                System.out.println("Something went wrong !!! Please try again");
                System.exit(0);
            }

        }
    }

}

