<?php

namespace test;
use data\TreeNode2;
use structure\BinaryTree;

class Tree
{
    public function index()
    {
        $binaryTree = new BinaryTree();
        dump($binaryTree);
        $binaryTree->root = new TreeNode2(1);
        $binaryTree->root->left = new TreeNode2(2);
        $binaryTree->root->right = new TreeNode2(3);
        $binaryTree->root->left->left = new TreeNode2(5);
        $binaryTree->root->right->right = new TreeNode2(6);
        $binaryTree->root->left->right = new TreeNode2(7);
        $binaryTree->root->right->left = new TreeNode2(8);
        dump($binaryTree);
        $binaryTree->preOrderTraversal($binaryTree->root);
        echo "<hr>";
        $binaryTree->inOrderTraversal($binaryTree->root);
    }
}