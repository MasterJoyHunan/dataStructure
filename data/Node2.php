<?php
namespace data;
/**
 * Class Node
 * 二元多项式
 */
class Node2
{
    public $prev; // 头指向
    public $coef; //系数
    public $expon; //指数
    public $link;//指针域

    /**
     * Node constructor.
     * @param $coef int
     * @param $expon int
     */
    public function __construct( $coef, $expon)
    {
        $this->coef = $coef;
        $this->expon = $expon;
    }


}