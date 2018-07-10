<?php

namespace test;
use structure\QueueArray as QueueData;

class QueueArray
{
    public function index()
    {
        $queue = new QueueData(5);
        try{
            $queue->add(9);
            $queue->add(5);
            $queue->add(2);
            $queue->add(7);
            dump($queue->delete());
            $queue->add(9);
            dump($queue->delete());
            $queue->add(2);
            dump($queue->delete());
            $queue->add(3);
            dump($queue->delete());
            $queue->add(4);
            dump($queue->delete());
            dump($queue->delete());
            dump($queue->delete());
            dump($queue->delete());
            dump($queue->delete());
            dump($queue);
        }catch (\Exception $e){
            echo $e->getMessage() . ':' . $e->getFile() . ' line:'.$e->getLine();
            dump( $e->getTraceAsString());
        }
    }
}