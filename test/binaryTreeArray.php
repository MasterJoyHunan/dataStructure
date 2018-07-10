<?php

namespace test;
use structure\BinaryTreeArray as BinaryTree;
/**
 * 完全二叉树, 可以用数组表示
 * Class binarySearch
 * @package test
 */
class binaryTreeArray
{
    public function index()
    {
        $tree = new BinaryTree('A');
        $tree->join(2, 'B');
//        $tree->join(3, 'C');
        $tree->join(4, 'D');
        $tree->join(4, 'T');
//        $tree->join(5, 'E');
//        $tree->join(6, 'F');
//        $tree->join(7, 'G');
        $tree->join(8, 'H');
        dump($tree->getParent(8));
        dump($tree->getLeftChild(4));
        dump($tree->getRightChild(4));
        dump($tree);
    }
}