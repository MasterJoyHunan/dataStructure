<?php

namespace structure;

/**
 * 堆栈 -- 数组实现
 * Class Stack
 * @package structure
 */
class StackArray
{
    private $top;
    private $data;

    /**
     * 创建一个堆栈
     * @param $length int 堆栈长度
     * @return $this
     */
    public function __construct($length)
    {
        $this->top = -1;
        $this->data = new \SplFixedArray($length);
        return $this;
    }

    /**
     * 判断该堆栈是否满员
     * @return bool
     */
    public function isFull()
    {
        return $this->top + 1 == count($this->data);
    }

    /**
     * 判断该堆栈是否为空
     * @return bool
     */
    public function isEmpty()
    {
        return $this->top == -1;
    }

    /**
     * 插入数据
     * @param $element object
     * @throws \Exception
     */
    public function push($element)
    {
        if ($this->isFull()) {
            throw new \Exception('堆栈已满');
        }
        $this->data[$this->top + 1] = $element;
        $this->top++;
    }

    /**
     * 抛出数据
     * @return mixed
     * @throws \Exception
     */
    public function pop()
    {
        if ($this->isEmpty()) {
            throw new \Exception('堆栈为空');
        }
        $element = $this->data[$this->top];
        unset($this->data[$this->top]);
        $this->top--;
        return $element;
    }
}