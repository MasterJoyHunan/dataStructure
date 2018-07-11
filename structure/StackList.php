<?php

namespace structure;

/**
 * 堆栈 --链表实现
 * Class StackList
 * @package structure
 */
class StackList
{
    private $data;

    public function __construct()
    {
        return $this->data = new singeLinkList();
    }


    public function isEmpty()
    {
        return $this->data->header == null;
    }


    public function push($element)
    {
        $this->data->add($element);
    }


    public function pop()
    {
        if ($this->isEmpty()){
            echo '已经没有元素';
            return;
        }
        return $this->data->deleteHeader();
    }

    public function getData()
    {
        return $this->data;
    }

    public function getTop()
    {
        if($this->data->header != null){
            return $this->data->header->data;
        }
        return false;
    }
}