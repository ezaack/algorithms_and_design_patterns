package br.com.study.strucktsandalgorithms.trees.binarysearch;

import br.com.study.strucktsandalgorithms.trees.BinaryTree;
import br.com.study.strucktsandalgorithms.trees.TreeUtils;

import java.util.List;

public class BinarySearchTreeImpl implements BinaryTree<BSNode> {
    private BSNode root;

    @Override
    public void insert(int value) {
        root = insert(root, value);
    }
    @Override
    public BSNode recursiveSearch(int value) {
        return TreeUtils.recursiveSearch(root, value);
    }

    @Override
    public BSNode interactiveSearch(int value){
        return (BSNode) TreeUtils.interactiveSearch(this, value);
    }

    @Override
    public int size() {
        return TreeUtils.size(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int height() {
        return TreeUtils.height(root);
    }
    @Override
    public List<BSNode> inOrderTraversal() {
        return TreeUtils.inOrderTraversal(root);
    }

    @Override
    public BSNode getRoot() {
        return root;
    }

    private BSNode insert(BSNode currentNode, int value) {
        if (currentNode == null) {
            return new BSNode(value);
        }
        if( currentNode.getValue() > value){
            currentNode.setLeft(insert(currentNode.getLeft(), value));
        }

        if( currentNode.getValue() < value){
            currentNode.setRight(insert(currentNode.getRight(), value));
        }

        return currentNode;

    }
}
