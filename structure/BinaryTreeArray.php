<?php

namespace structure;

/**
 *  完全二叉树 / 使用数组来存储
 * Class BinaryTree
 * @package structure
 */
class BinaryTreeArray
{
    private $data = [];

    /**
     *      1
     *     2 3
     *    4 56 7
     */

    /**
     * 创建一个二叉树的根节点
     * @param $element
     */
    public function __construct($element)
    {
        $this->data[1] = $element;
    }

    /**
     * 插入节点
     * @param $index
     * @param $element
     */
    public function join($index, $element)
    {
        $i = floor($index / 2);
        if($index <= 1 || empty($this->data[$i])){
            echo '非法参数';
            return;
        }
        $this->data[$index] = $element;
    }


    /**
     * 获取某个编号的父节点 非根节点的父节点都是自己的编号 / 2 向下取整
     * @param $index int 元素的编号(下标)
     * @return object
     */
    public function getParent($index)
    {
        if ($index <= 1) {
            echo '非法参数';
            return ;
        }
        $i = floor($index / 2);
        return $this->data[$i] ?? false;
    }

    /**
     * 某个元素的左儿子
     * @param $index
     * @return mixed|string
     */
    public function getLeftChild($index)
    {
        if ($index < 1 ) {
            echo '非法参数';
            return false;
        }
        return $this->data[$index * 2] ?? false;
    }


    /**
     * 某个元素的右儿子
     * @param $index
     * @return mixed|string
     */
    public function getRightChild($index)
    {
        if ($index < 1) {
            echo '非法参数';
            return false;
        }
        return $this->data[$index * 2 + 1] ?? false;
    }

}