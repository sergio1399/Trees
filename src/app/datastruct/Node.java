package app.datastruct;

import java.util.*;

public class Node<T> {
    private List<Node<T>> children = new ArrayList<Node<T>>();
    private Node<T> parent = null;
    private T data = null;
    private int weight = 0;

    //private List< Stack<Node<T>> > subtrees = new ArrayList<>();
    private static int maxSubWeight = 13;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public Node(T data, Node<T> parent, int weight) {
        this.data = data;
        this.parent = parent;
        this.weight = weight;
    }

    public Node(Node<T> parent, int weight) {
        this.weight = weight;
        this.parent = parent;
    }

    /*public List<Stack<Node<T>>> getSubtrees() {
        return subtrees;
    }*/

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setParent(Node<T> parent) {
        parent.addChild(this);
        this.parent = parent;
    }

    public void addChild(T data) {
        Node<T> child = new Node<T>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data, int weight) {
        Node<T> child = new Node<T>(data, weight);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Node<T> child) {
       // child.setParent(this);
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if(this.children.size() == 0)
            return true;
        else
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public Stack<Node<T>> recursionPass(Stack<Node<T>> chain, int maxWeight, List< Stack<Node<T>> > subtrees ){
        Stack< Node<T> > newChain = new Stack<>();
        if(getSumWeight(chain) + this.weight <= maxWeight) {
            //Stack< Node<T> > newChain = new Stack<>();
            newChain.addAll(chain);
            newChain.add(this);
            subtrees.add(newChain);
            for (Node<T> node: this.children) {
                chain = node.recursionPass(newChain, maxWeight, subtrees);
                //newChain = node.recursionPass(newChain, maxWeight, subtrees);
            }

        }

        //return newChain;
        return chain;
    }

    private int getSumWeight(Collection< Node<T> > col){
        int sum = 0;
        for ( Node<T> node : col ) {
            sum += node.weight;
        }
        return sum;
    }







}