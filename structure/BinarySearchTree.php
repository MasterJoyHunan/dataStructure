<?php
/**
 * Created by PhpStorm.
 * User: master-joy
 * Date: 2018/9/28
 * Time: 21:59
 */

namespace structure;

use data\TreeNode2;

/**
 * 二叉搜索树/二叉排序树/二叉查找树
 *      二叉搜索树是一个有序的树集合
 *      非空左子树小于根节点
 *      非空右子树大于根节点
 * Class BinarySearchTree
 * @package structure
 */
class BinarySearchTree
{
    public $tree;
    private $currentTree;

    /**
     * 查找树的某个节点
     * @param int $data
     * @param tree $tree
     * @return boolean
     */
    public function find($data, $tree)
    {
        /*if (!$tree) {
            return false;
        }
        // 如果要查找的值大于根节点, 往右边找
        if ($data > $tree->data) {
            $this->find($tree->right->data, $tree->right);
        // 如果要查找的值小于根节点, 往左边找
        } else if ($data < $tree->data) {
            $this->find($tree->left, $tree->left);
        // 不大不小,直接返回
        } else {
            return $tree;
        }*/
        // 尾递归都可以用while实现
        while ($tree) {
            if ($data > $tree->data) {
                $tree = $tree->right;
            } else if ($data < $tree->data) {
                $tree = $tree->left;
            } else {
                return $tree;
            }
        }
        return false;
    }

    /**
     * 查找某棵树的最小节点
     */
    public function findMin($tree)
    {
        /*if (!$tree) {
            return false;
        }
        if ($tree->left) {
            $this->findMin($tree->left);
        } else {
            return $tree->data;
        }*/
        // 尾递归都可以用while实现
        while ($tree) {
            if ($tree->left) {
                $tree = $tree->left;
            } else {
                return $tree;
            }
        }
        return false;
    }

    /**
     * 查找某棵树的最大节点
     */
    public function findMax($tree)
    {
        /*if (!$tree) {
            return false;
        }
        if ($tree->right) {
            $this->findMin($tree->right);
        } else {
            return $tree->data;
        }*/

        // 尾递归都可以用while实现
//        while ($tree) {
//            if ($tree->right) {
//                $tree = $tree->right;
//            } else {
//                return $tree;
//            }
//        }
        if ($tree) {
            while ($tree->right) {
                $tree = $tree->right;
            }
            return $tree;
        }
        return false;
    }

    /**
     * 在树里面插入数据
     */
    public function insert($data, $current_tree = false)
    {
        // 实现方式2
        /*if (!$current_tree) {
            $current_tree = new TreeNode2($data);
        } else {
            if ($data > $current_tree->data) {
                // 找右边
                $current_tree->right = $this->insert($data, $current_tree->right);
            } else if ($data < $current_tree->data) {
                // 找左边
                $current_tree->left = $this->insert($data, $current_tree->left);
            }
        }
        return $current_tree;*/
        // 实现方式3
        if (!$this->tree) {
            $this->tree = new TreeNode2($data);
        } else {
            $currentTree = $this->tree;
            while ($data != $currentTree->data) {
                if ($data > $currentTree->data) {
                    $currentTree->right ?
                        $currentTree = $currentTree->right :
                        $currentTree->right = new TreeNode2($data);
                } else if ($data < $currentTree->data) {
                    $currentTree->left ?
                        $currentTree = $currentTree->left :
                        $currentTree->left = new TreeNode2($data);
                }
            }
        }
    }

    /**
     * 在树里面删除数据
     */
    public function delete()
    {

    }
}