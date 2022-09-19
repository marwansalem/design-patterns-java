package patterns.behavioural.iterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Node<T> {
    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Iterator<Node<T>> preorder() {
        return new Iterator<>() {
            final Deque<Node<T>> stack = new ArrayDeque<>();
            {
                stack.push(Node.this);
            }
            @Override
            public Node<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node node = stack.pop();
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
                return node;
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }
        };
    }
}
