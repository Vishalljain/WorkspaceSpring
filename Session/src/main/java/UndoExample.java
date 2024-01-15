import java.util.Stack;

class TextEditor {
    private StringBuilder text;
    public Stack<String> undoStack;

    public TextEditor() {
        text = new StringBuilder();
        undoStack = new Stack<>();
    }

    public void type(char character) {
        text.append(character);
        undoStack.push(text.toString()); // Record the state for undo
        System.out.println("Typed: " + character);
    }

    public void delete() {
        if (text.length() > 0) {
            text.deleteCharAt(text.length() - 1);
            undoStack.push(text.toString()); // Record the state for undo
            System.out.println("Deleted");
        } else {
            System.out.println("Nothing to delete");
        }
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            text = new StringBuilder(undoStack.peek());
            System.out.println("Undo");
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public String getText() {
        return text.toString();
    }
}

public class UndoExample {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.type('H');
        editor.type('e');
        editor.type('l');
        editor.type('l');
        editor.type('o');
        System.out.println("Current Text: " + editor.getText());
        System.out.println("----1--------");
        editor.undoStack.forEach(e->System.out.println(e));
        System.out.println("");
        editor.delete();
        System.out.println("Current Text: " + editor.getText());
        System.out.println("----2--------");
        editor.undoStack.forEach(e->System.out.println(e));
        System.out.println("");
        
        editor.undo();
        System.out.println("Current Text (after undo): " + editor.getText());
        editor.undoStack.forEach(e->System.out.println(e));
        System.out.println("");
    }
}
