package br.com.study.strucktsandalgorithms.trees.redblacktree;

import br.com.study.strucktsandalgorithms.trees.Node;

public class RBNode implements Node {
    private int value;
    private boolean black;
    private RBNode left;
    private RBNode right;
    private RBNode parent;

    public RBNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public RBNode getLeft() {
        return left;
    }

    public void setLeft(RBNode left) {
        this.left = left;
        if(this.left != null) {
            this.left.setParent(this);
        }
    }

    public RBNode getRight() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
        if(this.right != null) {
            this.right.setParent(this);
        }
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public RBNode getParent() {
        return parent;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "RBNode{" +
                "value=" + value +
                ", black=" + black +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
