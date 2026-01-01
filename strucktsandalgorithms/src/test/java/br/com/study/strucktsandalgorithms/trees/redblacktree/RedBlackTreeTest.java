package br.com.study.strucktsandalgorithms.trees.redblacktree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {

    private RedBlackTreeImpl rbt;

    @BeforeEach
    void setUp() {
        // Replace with your actual implementation
        rbt = new RedBlackTreeImpl();
    }

    @Test
    void testIsEmptyOnNewTree() {
        assertTrue(rbt.isEmpty(), "New tree should be empty");
        assertEquals(0, rbt.size(), "Size of new tree should be 0");
    }

    @Test
    void testInsertAndSize() {
        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(15);

        assertFalse(rbt.isEmpty(), "Tree should not be empty after inserts");
        assertEquals(3, rbt.size(), "Size should reflect number of inserted nodes");
    }

    @Test
    void testRecursiveSearchExistingNode() {
        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(15);

        RBNode node = rbt.recursiveSearch(10);
        assertNotNull(node, "Node with value 10 should be found");
        assertEquals(10, node.getValue());

        node = rbt.recursiveSearch(5);
        assertNotNull(node, "Node with value 5 should be found");
        assertEquals(5, node.getValue());

        node = rbt.recursiveSearch(15);
        assertNotNull(node, "Node with value 15 should be found");
        assertEquals(15, node.getValue());
    }

    @Test
    void testInteractiveSearchExistingNode() {
        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(15);

        RBNode node = rbt.interactiveSearch(10);
        assertNotNull(node, "Node with value 10 should be found");
        assertEquals(10, node.getValue());
    }

    @Test
    void testSearchNonExistingNode() {
        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(15);

        assertNull(rbt.recursiveSearch(20), "Searching non-existing value should return null");
        assertNull(rbt.interactiveSearch(20), "Searching non-existing value should return null");
    }

    @Test
    void testHeight() {
        assertEquals(0, rbt.height(), "Height of empty tree should be 0");

        rbt.insert(10);
        assertEquals(1, rbt.height(), "Height with single node should be 1");

        rbt.insert(5);
        rbt.insert(15);
        assertEquals(2, rbt.height(), "Height of tree with three nodes should be 2");

        rbt.insert(2);
        assertTrue(rbt.height() >= 2, "Height should increase with more nodes"); // exact height depends on balancing
    }

    @Test
    void testInOrderTraversal() {
        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(15);
        rbt.insert(2);
        rbt.insert(7);

        List<RBNode> traversal = rbt.inOrderTraversal();
        int[] values = traversal.stream().mapToInt(RBNode::getValue).toArray();
        int[] expectedSorted = {2, 5, 7, 10, 15};

        assertArrayEquals(expectedSorted, values, "In-order traversal should return sorted values");
    }

    @Test
    void testNodeColorsAfterInsert() {
        // Optional test: checks basic property that root is black (common in RB trees)
        rbt.insert(10);
        RBNode root = rbt.recursiveSearch(10);
        assertNotNull(root, "Root node should exist");
        assertTrue(root.isBlack(), "Root node should be black after insert");
    }

    @Test
    void testRedBlackProperties() {
        rbt.insert(10);
        rbt.insert(5);
        rbt.insert(15);
        rbt.insert(1);
        rbt.insert(7);
        rbt.insert(12);
        rbt.insert(20);

        RBNode root = rbt.recursiveSearch(10);
        assertTrue(root.isBlack(), "Root should be black");

        checkRedBlackProperties(root);
    }

    // Recursive helper to check RB properties
    private int checkRedBlackProperties(RBNode node) {
        if (node == null) return 1; // nulls count as black leaves

        RBNode left = node.getLeft();
        RBNode right = node.getRight();

        // No consecutive reds
        if (!node.isBlack()) {
            if ((left != null && !left.isBlack())) {
                fail("Red node cannot have red child: " + node.getValue()+"\nparent: " + node.getValue() + " left: " + left.getValue());
            }

            if ((right != null && !right.isBlack())) {
                fail("Red node cannot have red child: " + node.getValue()+"\nparent: " + node.getValue() + " right: " + right.getValue());
            }
        }

        int leftBlackHeight = checkRedBlackProperties(left);
        int rightBlackHeight = checkRedBlackProperties(right);

        if (leftBlackHeight != rightBlackHeight) {
            fail("Black height mismatch in subtree rooted at " + node.getValue());
        }

        return leftBlackHeight + (node.isBlack() ? 1 : 0);
    }

}
