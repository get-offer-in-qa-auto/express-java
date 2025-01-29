package practice_7.photo_editor;

import java.util.Stack;

public class PhotoEditor {
    // хранить последние действия
    private Stack<String> actions;

    public PhotoEditor() {
        this.actions = new Stack<>();
    }

    // добавления нового действия
    public void addNewAction(String action) {
        actions.push(action);
    }

    // иметь возможность откатить последнее действие
    public void undoLastAction() {
        actions.pop();
    }

    public void printActions() {
        System.out.println("Все действия:");
        actions.forEach(System.out::println);
    }
}
