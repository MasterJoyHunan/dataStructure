<?php

namespace structure;

use data\Node;
use data\Node1;

/**
 * 二叉树, 儿子兄弟表示法
 *  『       data
 *      child | brother 』
 *
 * Class BinaryTree
 * @package structure
 */
class BinaryTree
{
    public $root; // 所有树都有ROOT节点

    /**
     * 建立一颗二叉树
     * BinaryTree constructor.
     */
    public function __construct()
    {
    }

    /**
     * 判断树是否为空
     */
    public function isEmpty()
    {

    }


    /**
     * 对一颗二叉树进行遍历
     */
    public function traversal()
    {
        //先序遍历 根->左->右
        //中序遍历 左->根->右
        //后序遍历 左->右->根
        //层次遍历 从上到下 从左到右
    }

    /**
     * 先序遍历 根->左->右
     * @param $current
     */
    public function preOrderTraversal($current)
    {
        if ($current) {
            echo $current->data;
            $this->preOrderTraversal($current->left);
            $this->preOrderTraversal($current->right);
        }
    }

    /**
     * 中序遍历 左->根->右
     * @param $current
     */
    public function inOrderTraversal($current)
    {
        if ($current) {
            $this->inOrderTraversal($current->left);
            echo $current->data;
            $this->inOrderTraversal($current->right);
        }
    }


    /**
     * 后序遍历 左->右->根
     * @param $current
     */
    public function postOrderTraversal($current)
    {
        if ($current) {
            $this->postOrderTraversal($current->left);
            $this->postOrderTraversal($current->right);
            echo $current->data;
        }
    }

    /**
     * 先序遍历 根->左->右
     * 使用堆栈实现
     * @param $current
     */
    public function preOrderTraversalStack($current)
    {
        $stack = new StackList();

        /**
         *          1
         *         2  3
         *        5 7 8 6
         */

        while ($current || !$stack->isEmpty()) {
            while ($current) {
                echo $current->data;
                $stack->push(new Node1($current));
                $current = $current->left;
            }
            if (!$stack->isEmpty()) {
                $current = $stack->pop();
                $current = $current->right;
            }
        }
    }

    /**
     * 中序遍历 左->根->右
     * 使用堆栈实现
     * @param $current
     */
    public function inOrderTraversalStack($current)
    {
        $stack = new StackList();

        /**
         *          1
         *         2  3
         *        5 7 8 6
         */

        while ($current || !$stack->isEmpty()) {
            while ($current) {
                $stack->push(new Node1($current));
                $current = $current->left;
            }
            if (!$stack->isEmpty()) {
                $current = $stack->pop();
                echo $current->data;
                $current = $current->right;
            }
        }
    }


    /**
     * 先序遍历 左->右->根
     * 使用堆栈实现
     * @param $current
     */
    public function postOrderTraversalStack($current)
    {
        $stack = new StackList();

        /**
         *          1
         *         2  3
         *        5 7 8 6
         */

        while ($current || !$stack->isEmpty()) {
            while ($current) {
                $current->visit = 1; //第一次碰到个节点
                $stack->push(new Node1($current));
                $current = $current->left;
            }
            if (!$stack->isEmpty()) {
                $current = $stack->getTop();
                if ($current->visit == 2) { //第三次就直接输出
                    $current = $stack->pop();
                    echo $current->data;
                    $current = null;
                } else if ($current->visit == 1) {
                    $current->visit = 2; //第二次碰到该节点
                    $current = $current->right;
                }
            }
        }
    }


    /**
     * 层次遍历 从上到下 从左到右
     */
    public function levelTraversalQueue($list)
    {
        $queue = new QueueList();
        $queue->add(new Node1($list));
        while ($current = $queue->delete()) {
            echo $current->data;
            if ($current->left) {
                $queue->add(new Node1($current->left));
            }
            if ($current->right) {
                $queue->add(new Node1($current->right));
            }
        }
    }

    /**
     * 层次遍历 从上到下 从左到右
     */
    public function levelTraversalStack($list)
    {
        $stack = new StackList();
        $stack->push(new Node1($list));
        while ($current = $stack->pop()) {
            echo $current->data;
            if ($current->left) {
                $stack->push(new Node1($current->left));
            }
            if ($current->right) {
                $stack->push(new Node1($current->right));
            }
        }
    }


}