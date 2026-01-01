package br.com.study.strucktsandalgorithms.trees.binarysearch;

import br.com.study.strucktsandalgorithms.trees.Node;

public class BSNode implements Node {
    private int value;
    private BSNode left;
    private BSNode right;

    public BSNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public BSNode getLeft() {
        return left;
    }

    public void setLeft(BSNode left) {
        this.left = left;
    }

    @Override
    public BSNode getRight() {
        return right;
    }

    public void setRight(BSNode right) {
        this.right = right;
    }
}
