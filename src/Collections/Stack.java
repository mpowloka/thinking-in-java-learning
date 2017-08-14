package Collections;

import java.util.LinkedList;

public class Stack <T> {
    private LinkedList<T> list = new LinkedList<T>();

    public void push (T arg) {
        list.addFirst(arg);
    }
    public T peek () {
        return list.getFirst();
    }
    public T pull () {
        return list.removeFirst();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public String toString() {
        return list.toString();
    }
}
