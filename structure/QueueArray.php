<?php

namespace structure;

/**
 * 队列
 * 数组方式
 * Class Queue
 * @package structure
 */
class QueueArray
{
    private $data; //队列数据
    private $rear = 0; //队头
    private $front = 0; //队尾
    private $length;

    public function __construct($length)
    {
        $this->length = $length;
        $this->data = new \SplFixedArray($length);
    }

    /**
     * 判断队列是否满
     * @return bool
     */
    public function isFull()
    {
        return ($this->rear + 1) % $this->length == $this->front;
    }


    /**
     * 判断队列是否为空
     * @return bool
     */
    public function isEmpty()
    {
        return $this->rear == $this->front;
    }


    /**
     * 添加到队列
     * @param $element
     * @throws \Exception
     */
    public function add($element)
    {
        if ($this->isFull()) {
            throw new \Exception('队列已满');
        }
        $this->rear = ($this->rear + 1) % $this->length;
        $this->data[$this->rear] = $element;

    }


    public function delete()
    {
        if ($this->isEmpty()) {
            throw new \Exception('队列是空的');
        }
        $this->front = ($this->front + 1) % $this->length;
        $res =  $this->data[$this->front];
        unset($this->data[$this->front]);
        return $res;
    }
}