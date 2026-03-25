package umg.edu.gt.listasenlazadas.simple;

/**
 * Implementación básica de una lista simplemente enlazada con retos resueltos.
 *
 * @param <T> tipo de dato almacenado
 */
public class SinglyLinkedList<T> {
    private SimpleNode<T> head;
    private SimpleNode<T> tail;
    private int size;



    public void addFirst(T value) {
        SimpleNode<T> newNode = new SimpleNode<>(value);
        newNode.setNext(head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        SimpleNode<T> newNode = new SimpleNode<>(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T value = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public boolean remove(T value) {
        if (head == null) {
            return false;
        }

        if (isSameValue(head.getValue(), value)) {
            removeFirst();
            return true;
        }

        SimpleNode<T> previous = head;
        SimpleNode<T> current = head.getNext();

        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                previous.setNext(current.getNext());
                if (current == tail) {
                    tail = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }



    /**
     * RETO 1 
      */
    public int countOccurrences(T value) {
        int count = 0;
        SimpleNode<T> current = head;
        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                count++;
            }
            current = current.getNext();
        }
        return count;
    }

    /**
     * RETO 2
     */
    public int clean() {
        int removedCount = size;
        SimpleNode<T> current = head;
        
        while (current != null) {
            SimpleNode<T> next = current.getNext();
            current.setNext(null); 
            current = next;
        }

        head = null;
        tail = null;
        size = 0;
        
        return removedCount;
    }

    /**
     * RETO 3
     */
    
    public void reverseInPlace() {
        if (head == null || head.getNext() == null) {
            return; 
        }

        SimpleNode<T> previous = null;
        SimpleNode<T> current = head;
        SimpleNode<T> next = null;

       
        tail = head;

        while (current != null) {
            next = current.getNext(); 
            current.setNext(previous); 
            previous = current;        
            current = next;            
        }

        head = previous; 
    }

}