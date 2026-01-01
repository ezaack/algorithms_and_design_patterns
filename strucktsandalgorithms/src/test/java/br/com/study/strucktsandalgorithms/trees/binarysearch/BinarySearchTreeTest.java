package br.com.study.strucktsandalgorithms.trees.binarysearch;

import br.com.study.strucktsandalgorithms.trees.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTreeImpl bst;

    @BeforeEach
    void setUp() {
        // Replace with your concrete implementation
        bst = new BinarySearchTreeImpl();
    }

    @Test
    void testIsEmptyOnNewTree() {
        assertTrue(bst.isEmpty(), "New tree should be empty");
        assertEquals(0, bst.size(), "Size of new tree should be 0");
    }

    @Test
    void testInsertAndSize() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertFalse(bst.isEmpty(), "Tree should not be empty after inserts");
        assertEquals(3, bst.size(), "Size should reflect number of inserted nodes");
    }

    @Test
    void testRecursiveSearchExistingNode() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        BSNode node = bst.recursiveSearch(10);
        assertNotNull(node, "Node with value 10 should be found");
        assertEquals(10, node.getValue());

        node = bst.recursiveSearch(5);
        assertNotNull(node, "Node with value 5 should be found");
        assertEquals(5, node.getValue());

        node = bst.recursiveSearch(15);
        assertNotNull(node, "Node with value 15 should be found");
        assertEquals(15, node.getValue());
    }

    @Test
    void testRecursiveSearchNonExistingNode() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        BSNode node = bst.recursiveSearch(20);
        assertNull(node, "Searching for a non-existing value should return null");
    }

    @Test
    void testInteractiveSearchExistingNode() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        BSNode node = bst.interactiveSearch(10);
        assertNotNull(node, "Node with value 10 should be found");
        assertEquals(10, node.getValue());

        node = bst.interactiveSearch(5);
        assertNotNull(node, "Node with value 5 should be found");
        assertEquals(5, node.getValue());

        node = bst.interactiveSearch(15);
        assertNotNull(node, "Node with value 15 should be found");
        assertEquals(15, node.getValue());
    }

    @Test
    void testInteractiveSearchNonExistingNode() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        BSNode node = bst.interactiveSearch(20);
        assertNull(node, "Searching for a non-existing value should return null");
    }


    @Test
    void testHeight() {
        assertEquals(0, bst.height(), "Height of empty tree should be 0");

        bst.insert(10);
        assertEquals(1, bst.height(), "Height with single node should be 1");

        bst.insert(5);
        bst.insert(15);
        assertEquals(2, bst.height(), "Height of balanced 3-node tree should be 2");

        bst.insert(2);
        assertEquals(3, bst.height(), "Height should update after adding more nodes");
    }

    @Test
    void testInOrderTraversal() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);

        List<BSNode> traversal = bst.inOrderTraversal();
        int[] expected = {2, 5, 7, 10, 15};

        assertEquals(expected.length, traversal.size(), "Traversal size should match number of nodes");

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], traversal.get(i).getValue(), "In-order traversal should be sorted");
        }
    }

    @Test
    void testInsertDuplicates() {
        bst.insert(10);
        bst.insert(10); // depending on implementation, this may or may not be allowed

        assertEquals(1, bst.size(), "Duplicate values should not increase size if BST doesn't allow duplicates");
    }
}
