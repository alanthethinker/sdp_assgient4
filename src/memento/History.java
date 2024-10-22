package memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<TextMemento> states = new ArrayList<>();
    private int currentIndex = -1;

    public void push(TextMemento state) {
        // Remove any states after the current position
        while (states.size() > currentIndex + 1) {
            states.remove(states.size() - 1);
        }
        states.add(state);
        currentIndex++;
    }

    public TextMemento undo() {
        if (currentIndex > 0) {
            currentIndex--;
            return states.get(currentIndex);
        }
        return null;
    }

    public TextMemento redo() {
        if (currentIndex + 1 < states.size()) {
            currentIndex++;
            return states.get(currentIndex);
        }
        return null;
    }

    public boolean canUndo() {
        return currentIndex > 0;
    }

    public boolean canRedo() {
        return currentIndex + 1 < states.size();
    }
}