package code;

public class Node<T> {
    public int x;
    public int y;
    public Node<T> next;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.next = null;
    }
}

