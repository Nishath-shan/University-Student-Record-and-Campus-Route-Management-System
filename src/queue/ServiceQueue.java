package queue;

import java.util.NoSuchElementException;

/** Represents a queue of student service requests. */
public class ServiceQueue {
    private static class Node {
        private final String request;
        private Node next;

        private Node(String request) {
            this.request = request;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public void enqueue(String request) {
        Node node = new Node(request);
        if (isEmpty()) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue from an empty service queue.");
        }

        String request = front.request;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return request;
    }

    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek at an empty service queue.");
        }

        return front.request;
    }

    public void displayQueue() {
        Node current = front;
        while (current != null) {
            System.out.println(current.request);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}
