package com.example.demo;

public class BinaryTree {

    /*
    Given the root node of a binary tree, swap the ‘left’ and ‘right’ children for each node.
    The example below shows how the mirrored binary tree would look like for a given binary tree.
                1
             /     \
            3       4
           / \      / \
          10  20   30  7


                1
             /     \
            4       3
           / \      / \
          7  30   20  10

     */

    BinaryTree left = null;
    BinaryTree right = null;
    Integer value;

    public BinaryTree(Integer value) {
        this.value = value;
    }

    static BinaryTree swapBinaryTree(BinaryTree tree) {
        if (tree == null){
            return null;
        }

        BinaryTree result = new BinaryTree(tree.value);
        result.left = swapBinaryTree(tree.right);
        result.right = swapBinaryTree(tree.left);
        return result;
    }

}
