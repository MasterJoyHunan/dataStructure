<?php
namespace data;
/**
 * Class Node
 * 一元多项式的节点数据
 */
class Node
{
    public $coef; //系数
    public $expon; //指数
    public $link;//指针域

    /**
     * Node constructor.
     * @param $coef
     * @param $expon
     */
    public function __construct($coef, $expon)
    {
        $this->coef = $coef;
        $this->expon = $expon;
    }


}