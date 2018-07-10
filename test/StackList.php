<?php

namespace test;
use structure\StackList as Stack;
use data\Node2;

class StackList
{
    public function index()
    {
        $sta = new Stack();
        $sta->push(new Node2(9));
        $sta->push(new Node2(5));
        $sta->push(new Node2(2));
        $sta->push(new Node2(7));
        dump($sta->pop());
        dump($sta->pop());
        dump($sta->pop());
        dump($sta->pop());
//        dump($sta->pop());

        dump($sta->getData());
    }
}