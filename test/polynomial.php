<?php

namespace test;

use data\Node;
use structure\{
    singeLinkList
};

/**
 * 单向链表表示的一元多项式
 * Class polynomial
 * @package test
 */
class polynomial
{
    public function index()
    {
        $pol = new singeLinkList();
        $list = $pol->init(new Node(null, null));
        $pol->add(new Node(1, 1));
        $pol->add(new Node(2, 2));
        $pol->add(new Node(-41, 99));
        $pol->add(new Node(-21, 92));
        dump('初始数据', $list);

        $list_length = $pol->length();
        dump('这个链表的长度为', $list_length);

        $res = $pol->findKth(0);
        dump('链表的第0位长度的值为', $res);

        $res2 = $pol->findIndex(new Node(1, 12));
        dump('数据 new Node(1, 12) 在链表的位置是', $res2);

        $pol->insert(new Node(3, 33), 2);
        dump('插入 new Node(3,33), 2 操作', $list);

        $pol->delete(3);
        dump('删除 3 操作', $list);
    }
}
