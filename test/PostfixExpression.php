<?php

namespace test;

use data\Node2;
use structure\StackList;

/**
 * 普通表达式转换为后缀表达式
 * Class PostfixExpression
 * @package test
 */
class PostfixExpression
{
    private $first = ['+' => 1, '-' => 1, '*' => 2, '/' => 2];

    public function index()
    {
        $str = '1*(9+4)/8';
//        $str = '1+9+(8+6*3)+4-6/8';
//        $str = "9+(3-1)*3+10/2";
        $arr = str_split($str);
        $sta = new StackList();
        foreach ($arr as $key => $v) {
            $int = preg_match('/\d/', $v);
            if ($int) {
                echo $v;
                continue;
            }
            $exp = preg_match('/\+|\-|\*|\/|\(|\)/', $v);
            if ($exp) {
                $this->inOrOutStack($sta, $v);
            }
        }
        $this->free($sta);
    }


    /**
     * 按条件判断是入栈还是出栈
     * @param $sta StackList 堆栈
     * @param $v string 符号
     */
    public function inOrOutStack($sta, $v)
    {
        switch ($v) {
            case '(':
                //如果是左括号 , 直接入栈
                $sta->push(new Node2($v));
                break;
            case ')':
                //如果是右括号, 出栈到左括号
                $top = $sta->getTop();
                while ($top) {
                    if ($top == '(') {
                        $sta->pop();
                        break;
                    }
                    echo $sta->pop();
                    $top = $sta->getTop();
                }
                break;
            default:
                $top = $sta->getTop();
                if ($top == '(') {
                    $sta->push(new Node2($v));
                    break;
                }
                //如果栈顶的优先级 小于当前的话 , 直接抛出, 否则,出栈, 入栈当前
                while ($top && $this->first[$top] >= $this->first[$v]) {
                    echo $sta->pop();
                    $top = $sta->getTop();
                    if ($top == '(') {
//                        $top = $sta->getTop();
                        break;
                    }
                }
                $sta->push(new Node2($v));
                break;
        }
    }


    /**
     * 释放所有的堆栈
     * @param $sta
     */
    public function free($sta)
    {
        while ($sta->getTop()) {
            echo $sta->pop();
        }
    }
}