<?php

namespace data;

/**
 * 十字链表的数据
 * Class OrthogonalList
 * @package data
 */
class OrthogonalList
{
    public $row;    // 如果是入口节点 => 代表总行数         | 如果是头节点 => null             | 如果是数据节点 => 属于几行 从0开始
    public $col;    // 如果是入口节点 => 代表总列数         | 如果是头节点 => null             | 如果是数据节点 => 属于几列 从0开始
    public $value;  // 如果是入口节点 => 代表总节点个数      | 如果是头节点 => null            | 如果是数据节点 => 值是什么
    public $right;  // 如果是入口节点 => 指向下一个头结点    | 如果是头节点 => 指向同行头节点    | 如果是数据节点 => 指向同行数据节点
    public $down;   // 如果是入口节点 => null              | 如果是头节点 => 指向同列头节点    | 如果是数据节点 => 指向同行数据节点

    /**
     * OrthogonalList constructor.
     * @param $row
     * @param $col
     * @param $value
     * @param $right
     * @param $down
     */
    public function __construct($row = null, $col = null, $value = null, $right = null, $down = null)
    {
        $this->row = $row;
        $this->col = $col;
        $this->value = $value;
        $this->right = $right;
        $this->down = $down;
    }


}