package app.datastruct;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private List<Node<T>> children = new ArrayList<Node<T>>();
    private Node<T> parent = null;
    private T data = null;
    private int weight = 0;

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
        child.setParent(this);
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

    /*public List<Node<T>> getAllProperSubtrees(int maxWeight){
        List<Node<T>> resultList = new ArrayList<>();
        if(this.weight <= maxWeight)
            resultList.add(this);
        else
            return resultList;
        for (Node<T> node : this.children) {

        }
        return  resultList;
    }*/

    public List<Node<T>> getSubtree(int maxWeight, int curWeight, List<Node<T>> subtree){


        return subtree;
    }


}