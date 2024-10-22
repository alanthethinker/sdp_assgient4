package memento;

public class TextEditor {
    private StringBuilder content;
    private History history;

    public TextEditor() {
        this.content = new StringBuilder();
        this.history = new History();
        saveState(); // Save initial empty state
    }

    public void type(String text) {
        content.append(text);
        saveState();
    }

    public void delete(int start, int end) {
        if (start >= 0 && end <= content.length() && start <= end) {
            content.delete(start, end);
            saveState();
        }
    }

    public void clear() {
        content.setLength(0);
        saveState();
    }

    private void saveState() {
        history.push(new TextMemento(content.toString()));
    }

    public void undo() {
        TextMemento memento = history.undo();
        if (memento != null) {
            content = new StringBuilder(memento.getContent());
        }
    }

    public void redo() {
        TextMemento memento = history.redo();
        if (memento != null) {
            content = new StringBuilder(memento.getContent());
        }
    }

    public String getContent() {
        return content.toString();
    }

    public boolean canUndo() {
        return history.canUndo();
    }

    public boolean canRedo() {
        return history.canRedo();
    }
}