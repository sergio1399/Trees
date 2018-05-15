package app;

import app.datastruct.Node;

public class Application {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(23);
        Node<Integer> node2 = new Node<>(7);
        Node<Integer> node3 = new Node<>(9);
        node2.setParent(node1);
        node3.setParent(node1);
    }
}
