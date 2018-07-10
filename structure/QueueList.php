<?php

namespace structure;

/**
 * 队列链表方式
 * Class Queue
 * @package structure
 */
class QueueList
{
    private $rear; //指向要插入的位置 [队尾]
    private $front; //指向要抛出的位置 [队头]


    /**
     * 判断队列是否为空
     * @return bool
     */
    public function isEmpty()
    {
        return $this->rear == null && $this->front == null;
    }


    /**
     * 入队列->插入到队尾, rear指向最后一个, front 指向第一个
     * @param $element
     * @throws \Exception
     */
    public function add($element)
    {
        if ($this->isEmpty()) {
            $this->front = $element;
            $this->rear = $element; //队尾
        } else {
            $current = $this->rear;
            $current->link = $element;
            $this->rear = $current->link;
        }

    }

    /**
     * 出队->第一个出队, rear指向最后一个, front 指向第一个
     * @throws \Exception
     */
    public function delete()
    {
        if ($this->isEmpty()) {
            throw new \Exception('队列是空的');
        }
        $res = $this->front;
        if (empty($res->link)) {
            $this->rear = null;
        }
        $this->front = $res->link;
        return $res->data;
    }
}