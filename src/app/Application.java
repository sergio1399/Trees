package app;

import app.datastruct.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Application {
    public static void main(String[] args) {
        Node<String> node1 = new Node<>("",4);
        Node<String> node2 = new Node<>("", 5);
        Node<String> node3 = new Node<>("", 2);
        Node<String> node4 = new Node<>("", 4);
        Node<String> node5 = new Node<>("", 1);
        Node<String> node6 = new Node<>("", 3);
        Node<String> node7 = new Node<>("", 7);
        Node<String> node8 = new Node<>("", 2);
        Node<String> node9 = new Node<>("", 8);
        Node<String> node10 = new Node<>("", 9);
        Node<String> node11 = new Node<>("", 3);
        Node<String> node12 = new Node<>("", 4);
        Node<String> node13 = new Node<>("", 5);
        node2.setParent(node1);
        node3.setParent(node1);
        node4.setParent(node2);
        node5.setParent(node3);
        node6.setParent(node3);
        node7.setParent(node3);
        node8.setParent(node4);
        node9.setParent(node4);
        node10.setParent(node9);
        node11.setParent(node8);
        node12.setParent(node8);
        node13.setParent(node8);

        /*List< Node<String> > list = new ArrayList<>();
        List< Node<String> > workList = new ArrayList<>();
        List< List<Node<String>> > subtrees = new ArrayList<>();
        node1.recursionPass(list, 15, subtrees);
        for (List< Node<String> > chain: subtrees) {
            for (Node<String> node: chain) {
                System.out.print(node.getWeight());
            }
            System.out.println();
        }*/

        Node<String> result = node1.getSubtree(node1,15);
        System.out.println();
        result.passTree();

    }
}
