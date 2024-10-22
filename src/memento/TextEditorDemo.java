package memento;

public class TextEditorDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Test case 1: Basic typing and undoing
        System.out.println("=== Test Case 1: Basic Typing and Undoing ===");
        editor.type("Hello ");
        System.out.println("After typing 'Hello ': " + editor.getContent());

        editor.type("World!");
        System.out.println("After typing 'World!': " + editor.getContent());

        editor.undo();
        System.out.println("After first undo: " + editor.getContent());

        editor.undo();
        System.out.println("After second undo: " + editor.getContent());

        // Test case 2: Redo functionality
        System.out.println("\n=== Test Case 2: Redo Functionality ===");
        editor.redo();
        System.out.println("After first redo: " + editor.getContent());

        editor.redo();
        System.out.println("After second redo: " + editor.getContent());

        // Test case 3: Deleting text
        System.out.println("\n=== Test Case 3: Deleting Text ===");
        editor.delete(5, 11); // Delete "World"
        System.out.println("After deleting 'World': " + editor.getContent());

        editor.undo();
        System.out.println("After undoing delete: " + editor.getContent());

        // Test case 4: Clear functionality
        System.out.println("\n=== Test Case 4: Clear Functionality ===");
        editor.clear();
        System.out.println("After clear: " + editor.getContent());

        editor.undo();
        System.out.println("After undoing clear: " + editor.getContent());
    }
}