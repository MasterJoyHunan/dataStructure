<?php

namespace structure;

/**
 * Class singeLinkList
 * 单向链表
 */
class singeLinkList
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
    }

    /**
     * @param $element
     * @return mixed
     */
    public function add($element)
    {
        if ($this->header == null) {
            $this->header = $element;
        } else {
            $element->link = $this->header;
            $this->header = $element;
        }
    }


    /**
     * @return mixed
     */
    public function length()
    {
        $i = 0;
        if ($this->header) {
            $i++;
        } else {
            return 0;
        }
        $current = $this->header;
        while ($current->link) {
            $current = $current->link;
            $i++;
        }
        return $i;
    }


    public function deleteHeader()
    {
        if ($this->header != null) {
            $res = $this->header;
            if ($this->header->link != null) {
                $arr = $this->header->link;
                $this->header = $arr;
            } else {
                $this->header = null;
            }
            return $res->data;
        }
        throw new \Exception('is empty stack');
    }

}