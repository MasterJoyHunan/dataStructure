<?php
namespace abstruct;
/**
 * Class LinearList
 * 抽象的线性结构
 */
abstract class LinearList
{
    /**
     * 初始化一个线性表
     * @param $element
     * @return mixed
     */
    abstract public function init($element);

    /**
     * 根据位置信息,返回相对应的元素
     * @param $index
     * @return mixed
     */
    abstract public function findKth($index);

    /**
     * 插入到最后一个元素
     * @param $element
     * @return mixed
     */
    abstract public function add($element);
    /**
     * 根据对应的元素,返回对应的位置
     * @param $element
     * @return mixed
     */
    abstract public function findIndex($element);

    /**
     * 根据对应的位置,插入数据
     * @param $element
     * @param $index
     * @return mixed
     */
    abstract public function insert($element, $index);

    /**
     * 根据对应的位置,删除对应的数据
     * @param $index
     * @return mixed
     */
    abstract public function delete($index);

    /**
     * 返回对应线性表的长度
     * @return mixed
     */
    abstract public function length();
}