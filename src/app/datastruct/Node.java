package app.datastruct;

import java.util.*;

public class Node<T> {
    private List<Node<T>> children = new ArrayList<Node<T>>();
    private Node<T> parent = null;
    private T data = null;
    private int weight = 0;

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
        //child.setParent(this);
       this.children.add(child);
    }

    public void removeChild(Node<T> child){
        for (int i = 0; i < this.children.size(); i++) {
            if(child.equals(this.children.get(i))){
                child.parent = null;
                this.children.remove(i);
                break;
            }
        }
    }

    public void removeAllChildren(){
        for (Node<T> node: this.children) {
            node.parent = null;
        }
        this.children.clear();
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

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public Node<T> copyTree(Node<T> source) {
        if (source == null) {
            // base case
            return null;
        }
        Node<T> copy = new Node(source.data, source.weight);
        for (Node<T> child : source.children) {
            copy.children.add(copyTree(child));
        }
        return copy;
    }

    public Node<T> getRoot(){
        Node<T> root = this;
        while (root.parent != null){
            root = root.parent;
        }
        return root;
    }

    /*public List<Node<T>> recursionPass(List<Node<T>> chain, int maxWeight, List< List<Node<T>> > subtrees){
        List< Node<T> > newChain = new ArrayList<>();
        newChain.addAll(chain);
        if(getSumWeight(chain) + this.weight <= maxWeight) {
            newChain.add(this);
            subtrees.add(newChain);
            for (Node<T> node: this.children) {
                chain = node.recursionPass(newChain, maxWeight, subtrees);
            }
        }
        return chain;
    }


    private int getSumWeight(Collection< Node<T> > col){
        int sum = 0;
        for ( Node<T> node : col ) {
            sum += node.weight;
        }
        return sum;
    }*/

    public List<Node<T>> treeTravel(int maxWeight){
        if(this.weight > maxWeight)
            return Collections.emptyList();
        Node<T> newTree = new Node<>(this.data, this.weight);
        List<Node<T>> result = new ArrayList<>();
        Node<T> root = copyTree(this);
        result = getSubtree(root, maxWeight, newTree, result);
        return result;
    }

    public List<Node<T>> getSubtree(Node<T> root, int maxWeight, Node<T> newTree, List<Node<T>> result){
        if(root.isLeaf()){
            Node<T> toAddTree = copyTree(newTree.getRoot());
            root.setWeight(0);
            result.add(toAddTree);
        }
        else {
                for (int cnt = 0; cnt < root.children.size(); cnt++) {
                    if (root.children.get(cnt).weight != 0 && root.children.get(cnt).weight <= maxWeight) {
                        Node<T> child = new Node<>(root.children.get(cnt).data, root.children.get(cnt).weight);
                        child.setParent(newTree);
                        getSubtree(root.children.get(cnt), maxWeight - root.weight, newTree.children.get(cnt), result);

                    } else {
                        if (root.weight != 0) {
                            Node<T> toAddTree = copyTree(newTree.getRoot());
                            root.setWeight(0);
                            result.add(toAddTree);
                        }
                    }
                }
                newTree.removeAllChildren();
        }


        return result;
    }


    public void passTree(){
        System.out.print(this);
        for (Node<T> node : this.children) {
            node.passTree();
        }
    }







}