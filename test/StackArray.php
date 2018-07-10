<?php

namespace test;

use data\Node1;
use structure\{StackArray as Stack, StackList};
class StackArray
{
    public function index()
    {
        $stack = new Stack(3);
        try{
            $stack->push(2);
            $stack->push(3);
            echo $stack->pop();
            echo $stack->pop();
            $stack->push(33);
            $stack->push(99);
            echo $stack->pop();
            echo $stack->pop();

//            $stack->push(53);
        }catch (\Exception $e){
            echo $e->getMessage();
        }
//        $stack->push(3);
        dump($stack);
    }

    public function index2()
    {
        $stack = new StackList();
        try{
            $stack->push(new Node1(2));
            $stack->push(new Node1(3));
            dump( $stack->pop());
            dump( $stack->pop());
            $stack->push(new Node1(33));
            $stack->push(new Node1(99));
            dump( $stack->pop());
            dump( $stack->pop());

//            $stack->push(53);
        }catch (\Exception $e){
            echo $e->getMessage();
        }
//        $stack->push(3);
        dump($stack);
    }
}