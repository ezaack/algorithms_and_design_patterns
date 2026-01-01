package br.com.study.strucktsandalgorithms.trees.redblacktree;

import br.com.study.strucktsandalgorithms.trees.BinaryTree;
import br.com.study.strucktsandalgorithms.trees.TreeUtils;

import java.util.List;

public class RedBlackTreeImpl implements BinaryTree<RBNode> {
    private RBNode root;
    @Override
    public void insert(int value) {
        RBNode current = insert(null,root, value);
        while (current.getParent() != null) {
            current = current.getParent();
        }
        root = current;
        root.setBlack(true);
    }
    private RBNode insert(RBNode parent, RBNode current, int value){
        if(current == null){ //root
            current = new RBNode(value);
            current.setParent(parent);
            return current;
        }
        if(current.getValue() > value){
            RBNode newNode = insert(current, current.getLeft(), value);
            current.setLeft(newNode);
            balance(newNode);
        }

        if(current.getValue() < value){
            RBNode newNode = insert(current, current.getRight(), value);
            current.setRight(newNode);
            balance(newNode);
        }
        return current;
    }

    private void balance( RBNode current) {
        RBNode parent = current.getParent();
        if(parent == null || parent.isBlack()){
            return;
        }
        RBNode grantParent = parent.getParent();
        RBNode uncle = getUncle(grantParent, parent);

        if(uncle != null && !uncle.isBlack()){ //red uncle
            uncle.setBlack(true);
            parent.setBlack(true);
            if(!grantParent.equals(root)) {
                grantParent.setBlack(false);
                balance(grantParent);
            }
        }else
        if(uncle == null || uncle.isBlack()){ //black uncle
            if(isLeftChild(parent) && isLeftChild(current)){
                rotateRight(grantParent);
            }
            if(isLeftChild(parent) && !isLeftChild(current)){
                rotateLeft(parent);
                rotateRight(grantParent);
            }
            if(!isLeftChild(parent) && !isLeftChild(current)){
                rotateLeft(grantParent);
            }
            if(!isLeftChild(parent) && isLeftChild(current)){
                rotateRight(parent);
                rotateLeft(grantParent);
            }
            if(grantParent!=null){
                grantParent.setBlack(false);
            }
            parent.setBlack(true);
        }

    }

    private static RBNode getUncle(RBNode grantParent, RBNode parent) {
        return grantParent == null ? null
                : isLeftChild(parent) ?
                grantParent.getRight()
                : grantParent.getLeft();
    }

    private static void rotateLeft(RBNode x){
        if(x== null){
            return;
        }
        RBNode granparent = x.getParent();
        RBNode y = x.getRight();
        RBNode t2 = y.getLeft();
        y.setLeft(x);
        x.setRight(t2);
        if(granparent != null){
            if(isLeftChild(x)) {
                granparent.setRight(y);
            }else{
                granparent.setLeft(y);
            }
        }
    }

    private static void rotateRight(RBNode x){
        if(x== null){
            return;
        }
        RBNode granparent = x.getParent();
        RBNode y = x.getLeft();
        RBNode t2 = y.getRight();
        y.setRight(x);
        x.setLeft(t2);
        if(granparent != null){
            if(isLeftChild(x)) {
                granparent.setLeft(y);
            }else{
                granparent.setRight(y);
            }
        }
    }
    private static boolean isLeftChild(RBNode node){
        RBNode parent = node.getParent();
        return parent != null && parent.getLeft()!=null && parent.getLeft().equals(node);
    }


    @Override
    public RBNode recursiveSearch(int value) {
        return TreeUtils.recursiveSearch(root, value);
    }

    @Override
    public RBNode interactiveSearch(int value){
        return (RBNode) TreeUtils.interactiveSearch(this, value);
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
    public List<RBNode> inOrderTraversal() {
        return TreeUtils.inOrderTraversal(root);
    }

    @Override
    public RBNode getRoot() {
        return  root;
    }
}
