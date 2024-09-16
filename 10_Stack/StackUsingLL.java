class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    Stack() {
        this.top = null;
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(int new_data) {
        Node new_node = new Node(new_data);

        new_node.next = top;
        top = new_node;
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("\nStack underflow");
            return;
        } else {
            Node temp = top;
            top = top.next;
            System.out.println("Popped value: " + temp.data);
            temp = null;  // Helps with garbage collection, but optional in Java.
        }
    }

    int peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
    }
}

public class StackUsingLL {
    public static void main(String[] args) {
        System.out.println("meow");

        Stack st = new Stack();

        // Push elements onto the stack
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);

        // Print top element of the stack
        System.out.println("Top element is " + st.peek());

        // Removing two elements from the top
        System.out.println("Removing two elements...");
        st.pop();
        st.pop();

        // Print top element of the stack
        System.out.println("Top element is " + st.peek());
    }
}
