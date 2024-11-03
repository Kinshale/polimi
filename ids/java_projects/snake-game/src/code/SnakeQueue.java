package code;

public class SnakeQueue {
    private Node<int[]> front;  // First element: the tail of the snake.
    private Node<int[]> rear;   // Last element: the head of the snake.
    private int size;           // Track the size of the queue

    public SnakeQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Add a new element (new head) to the queue
    public void enqueue(int var1, int var2) {
        Node<int[]> newNode = new Node<>(var1, var2);

        if (this.rear == null) {  // Queue is empty
            this.front = newNode;  // Both front and rear point to the new node
            this.rear = newNode;
        } else {
            this.rear.next = newNode;  // Link the new node at the end
            this.rear = newNode;       // Update rear to the new node
        }
        this.size++;
    }

    // Remove the element from the front (tail)
    public int[] dequeue() {
        if (this.front == null) {  // Queue is empty
            return null;
        }

        int[] dequeuedData = new int[]{this.front.x, this.front.y};
        this.front = this.front.next;  // Move front to the next node
        
        if (this.front == null) {  // If the queue becomes empty
            this.rear = null;  // Update rear to null as well
        }

        this.size--;
        return dequeuedData;
    }

    // Get the tail (first element)
    public Node<int[]> tail() {
        return this.front;
    }

    // Get the head (last element)
    public Node<int[]> head() {
        return this.rear;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }
}
