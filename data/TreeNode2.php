<?php
namespace data;


class TreeNode2
{
    public $data;
    public $left;
    public $right;
    public $visit; // 非递归后续遍历使用

    public function __construct($data)
    {
        $this->data = $data;
    }
}