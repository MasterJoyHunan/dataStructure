<?php

namespace structure;

use abstruct\LinearList;

/**
 * Class singeLinkList
 * 单向链表
 */
class singeLinkList extends LinearList
{
    public $header;

    /**
     * 初始化单向链表
     * @param $element
     * @return $this
     */
    public function init($element)
    {
        $this->header = $element;
        return $this;
    }

    /**
     * @param $index
     * @return mixed
     */
    public function findKth($index)
    {
        $current = $this->header;
        $i = 1;
        while ($current->link != null && $i < $index) {
            $current = $current->link;
            $i++;
        }
        return $i == $index ? $current->link : null;
    }

    /**
     * @param $element
     * @return mixed
     */
    public function findIndex($element)
    {
        $current = $this->header;
        $i = 0;
        while ($current->link != null) {
            if ($element->coef == $current->coef && $element->expon == $current->expon) {
                return $i;
            }
            $i++;
            $current = $current->link;
        }
        return 0;
    }

    /**
     * @param $element
     * @param $index
     * @throws \Exception
     * @return mixed
     */
    public function insert($element, $index)
    {
        if ($index == 1) {// 插入到第一个
            $element->link = $this->header->link;
            $this->header->link = $element;
            return;
        }
        $find = $this->findKth($index - 1, $this);
        if ($find) {
            $element->link = $find->link;
            $find->link = $element;
        } else {
            throw new \Exception('非法参数');
        }
    }

    /**
     * @param $element
     * @return mixed
     */
    public function add($element)
    {
        $current = $this->header;
        while ($current->link != null) {
            $current = $current->link;
        }
        $current->link = $element;
    }

    /**
     * @param $index
     * @throws \Exception
     * @return mixed
     */
    public function delete($index)
    {
        if ($index == 1) {
            if ($this->header->link != null) {
                $this->header->link = $this->header->link->link;
                return;
            }
            throw new \Exception('非法参数');
        }
        $find = $this->findKth($index - 1, $this);
        if($find){
            $find->link = $find->link->link;
        }else{
            throw new \Exception('非法参数');
        }
    }

    /**
     * @return int
     */
    public function length() :int
    {
        $i = 0;
        $current = $this->header;
        while ($current->link) {
            $current = $current->link;
            $i++;
        }
        return $i;
    }

}