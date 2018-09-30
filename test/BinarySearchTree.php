<?php
/**
 * Created by PhpStorm.
 * User: master-joy
 * Date: 2018/9/28
 * Time: 23:14
 */

namespace test;
use data\TreeNode2;
use structure\BinarySearchTree as Tree;

class BinarySearchTree
{
    public function index()
    {
        $tree = new Tree();
        $tree->insert(7);
        $tree->insert(6);
        $tree->insert(4);
        $tree->insert(5);
        $tree->insert(8);
        $tree->insert(9);
        $tree->insert(3);
        $tree->insert(1);
        dump($tree->tree);
        $min = $tree->findMin($tree->tree);
        $max = $tree->findMax($tree->tree);

        dump($min);
        dump($max);

        /*$bst = false;
        $bst = $tree->insert(7);
        $bst = $tree->insert(6, $bst);
        $bst = $tree->insert(4, $bst);
        $bst = $tree->insert(5, $bst);
        $bst = $tree->insert(8, $bst);
        $bst = $tree->insert(9, $bst);
        $bst = $tree->insert(3, $bst);
        $bst = $tree->insert(1, $bst);*/
    }
}