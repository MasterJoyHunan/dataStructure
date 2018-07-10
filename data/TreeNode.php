<?php

namespace data;

/**
 * 二叉树
 * Class TreeNode
 * @package data
 */
class TreeNode
{
    public $data;
    public $child_link;
    public $brother_link;

    /**
     * TreeNode constructor.
     * @param $data
     */
    public function __construct($data = '')
    {
        $this->data = $data;
    }


}