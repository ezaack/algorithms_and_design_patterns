package br.com.study.strucktsandalgorithms.trees;

import java.util.List;

public interface BinaryTree<N extends Node> {
    void insert(int value);

    N recursiveSearch(int value);

    N interactiveSearch(int value);

    int size();

    boolean isEmpty();

    int height();

    List<N> inOrderTraversal();

    N getRoot();
}
