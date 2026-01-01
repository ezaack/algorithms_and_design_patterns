package br.com.study.strucktsandalgorithms.trees;

import br.com.study.strucktsandalgorithms.trees.binarysearch.BSNode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeUtils {
    private TreeUtils() {
    }

    public static Node interactiveSearch(BinaryTree<?> binarySearchTree, int value) {
        Node current = binarySearchTree.getRoot();
        while(current != null){
            if(current.getValue() == value){
                break;
            }
            if(current.getValue() > value){
                current = current.getLeft();
                continue;
            }

            if(current.getValue() < value){
                current = current.getRight();
            }
        }
        return current;
    }

    public static <N extends Node> N recursiveSearch(N root, int value) {
        if( root == null){
            return null;
        }
        if(root.getValue() > value){
            return recursiveSearch((N)root.getLeft(), value);
        }

        if(root.getValue() < value){
            return recursiveSearch((N)root.getRight(), value);
        }

        return root;
    }

    public static <N extends Node> int size(N current) {
        if( current == null){
            return 0;
        }
        return 1 + size(current.getLeft()) + size(current.getRight());
    }

    public static <N extends Node> List<N> inOrderTraversal(N node) {
        if(node == null){
            return Collections.emptyList();
        }
        List<N> leftNodes = (List<N>) inOrderTraversal(node.getLeft());
        List<N> rightNodes = (List<N>) inOrderTraversal(node.getRight());
        return Stream.concat(
                Stream.concat(leftNodes.stream(), Stream.of(node)),
                rightNodes.stream()
        ).collect(Collectors.toList());
    }

    public static <N extends Node> int height(N current) {
        if(current == null){
            return 0;
        }
        int leftHeight = height(current.getLeft());
        int rightHeight = height(current.getRight());

        return 1 + (
                leftHeight> rightHeight? leftHeight : rightHeight
                );
    }
}
