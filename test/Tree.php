<?php

namespace test;
use data\TreeNode2;
use structure\BinaryTree;

class Tree
{
    public function index()
    {
        $binaryTree = new BinaryTree();
        $binaryTree->root = new TreeNode2(1);
        $binaryTree->root->left = new TreeNode2(2);
        $binaryTree->root->right = new TreeNode2(3);
        $binaryTree->root->left->left = new TreeNode2(5);
        $binaryTree->root->right->right = new TreeNode2(6);
        $binaryTree->root->left->right = new TreeNode2(7);
        $binaryTree->root->right->left = new TreeNode2(8);
        /**
         *          1
         *         2  3
         *        5 7 8 6
         */
        //先 根左右
//        $binaryTree->preOrderTraversal($binaryTree->root); //1257386
//        echo "<hr>";
        //中 左根右
//        $binaryTree->inOrderTraversal($binaryTree->root); //5271836
//        echo "<hr>";
        //后 左右根
//        $binaryTree->postOrderTraversal($binaryTree->root); //5728631
//        echo "<hr>";
        //先, 堆栈
//        $binaryTree->preOrderTraversalStack($binaryTree->root);
//        echo "<hr>";
        //中, 堆栈
        $binaryTree->inOrderTraversalStack($binaryTree->root);
        echo "<hr>";
        //后, 堆栈
//        $binaryTree->postOrderTraversalStack($binaryTree->root);
    }
}