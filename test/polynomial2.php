<?php

namespace test;

use data\Node;
use data\Node2;
use structure\{
    singeLinkList
};

/**
 * 单向链表表示的一元多项式
 * Class polynomial
 * @package test
 */
class polynomial2
{
    public function index()
    {
        $pol = new singeLinkList();
        $node1 = new Node(9, 2);
        $node1->link = new Node(0, 1);
        $pol->init(new Node($node1, 12));
        dump('init', $pol);

        $node2 = new Node(15, 3);
        $node2->link = new Node(-1, 1);
        $pol->add(new Node($node2, 8));
        dump('add2', $pol);
    }

    public function index2()
    {
        $pol = new singeLinkList();
        $node1 = new Node2(2 ,2);
        $node2 = new Node2(3 ,3);
        $node1->link = $node2;
        $node2->prev = $node1;
        $pol->init($node1);
        dump('init' ,$pol);
    }
}
