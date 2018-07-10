<?php
namespace data;
/**
 * Class Node
 * 简单数据
 */
class Node1
{
    public $data; //数据
    public $link;//指针域

    /**
     * Node constructor.
     * @param $data
     * @param $link
     */
    public function __construct($data, $link = '')
    {
        $this->data = $data;
        $this->link = $link;
    }


}