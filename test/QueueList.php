<?php

namespace test;
use structure\QueueList as Queue;
use data\Node2;
class QueueList
{
    public function index()
    {
        $queue = new Queue();
        $queue->add(new Node2(9));
        $queue->add(new Node2(5));
        $queue->add(new Node2(2));
        $queue->add(new Node2(7));
        dump($queue);
        dump( $queue->delete());
        dump($queue);
        dump( $queue->delete());
        dump($queue);
        dump( $queue->delete());
        dump($queue);
        dump( $queue->delete());
        dump($queue);
    }
}