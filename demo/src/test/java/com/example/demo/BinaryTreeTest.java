package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {


    @Test
    void swapBinaryTree() {
        var tree = new BinaryTree(1);
        tree.left = new BinaryTree(3);
        tree.right = new BinaryTree(4);
        tree.left.left = new BinaryTree(10);
        tree.left.right = new BinaryTree(20);
        tree.right.left = new BinaryTree(30);
        tree.right.right = new BinaryTree(7);

        var swapped = BinaryTree.swapBinaryTree(tree);

        Assertions.assertEquals(swapped.value, 1);
        Assertions.assertEquals(swapped.left.value, 4);
        Assertions.assertEquals(swapped.right.value, 3);
        Assertions.assertEquals(swapped.left.left.value, 7);
        Assertions.assertEquals(swapped.left.right.value, 30);
        Assertions.assertEquals(swapped.right.left.value, 20);
        Assertions.assertEquals(swapped.right.right.value, 10);
    }
}
