package stack;

import java.util.NoSuchElementException;

/** Represents a stack of actions for tracking reversible operations. */
public class ActionStack {
    private static class Node {
        private final String action;
        private Node next;

        private Node(String action, Node next) {
            this.action = action;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public void push(String action) {
        top = new Node(action, top);
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot pop from an empty action stack.");
        }

        String action = top.action;
        top = top.next;
        size--;
        return action;
    }

    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek at an empty action stack.");
        }

        return top.action;
    }

    public void displayHistory() {
        Node current = top;
        while (current != null) {
            System.out.println(current.action);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
