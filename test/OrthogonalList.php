<?php

namespace test;

use data\{
    OrthogonalList as Orthogonal
};
use structure\{
    singeLinkList
};

class OrthogonalList
{
    public function index()
    {
        $pol = new singeLinkList();
        $arr = [
            [0, 0, 0],
            [0, 0, 0],
            [0, 0, 1],
            [0, 0, 1],
        ];
        // row 行  4行  --
        // col 列  3列  |
//        public $row;    // 如果是入口节点 => 代表总行数         | 如果是头节点 => null             | 如果是数据节点 => 属于几行 从0开始
//        public $col;    // 如果是入口节点 => 代表总列数         | 如果是头节点 => null             | 如果是数据节点 => 属于几列 从0开始
//        public $value;  // 如果是入口节点 => 代表总节点个数      | 如果是头节点 => 指向下一个头节点  | 如果是数据节点 => 值是什么
//        public $right;  // 如果是入口节点 => 指向下一个头结点    | 如果是头节点 => 指向同行数据点    | 如果是数据节点 => 指向同行数据节点
//        public $down;   // 如果是入口节点 => null              | 如果是头节点 => 指向同列数据点    | 如果是数据节点 => 指向同行数据节点

        //  需要4行3列的数据结构 , 取最大的4
        $header = new Orthogonal(4, 3, 7);

        // 添加入口节点
        $pol->init($header);

        // 添加头结点
        $max = max($pol->header->col, $pol->header->row);
        for ($i = 0; $i < $max; $i++) {
            $current = $pol->header;
            if ($i == 0) {
                $current->right = new Orthogonal();
            } else {
                $current = $current->right;
                while (!empty($current->value)) {
                    $current = $current->value;
                }
                $current->value = new Orthogonal();
            }
        }
        //添加数据节点
        for ($i = 0; $i < $max; $i++) { //行 row
            for ($j = 0; $j < $max; $j++) { //列 col
                if (isset($arr[$i][$j]) && $arr[$i][$j] != 0) {
                    $new_data_node = new Orthogonal($i, $j, $arr[$i][$j]);
                    // 某个节点right = $new_data_node
                    // 1. 先从入口节点开始找, 找到头结点
                    // 2. 找到头结点 -> 找头节点下面的数据节点
                    $col_header = $pol->header->right;
                    $row_header = $pol->header->right;
                    // 找到第$j 列下面的 $i 个元素
                    $col_header = $this->findKth($j, $col_header, 'value');
//                    echo '<pre>';
//                    var_dump($row_header);exit;
                    while (!empty($col_header->down)) {
                        $col_header = $col_header->down;
                    }
                    $col_header->down = $new_data_node;

                    // 找到第$i 行右边的 $j 个元素
                    $row_header = $this->findKth($i, $row_header, 'value');
                    while (!empty($row_header->right)) {
                        $row_header = $row_header->right;
                    }
                    $row_header->right = $new_data_node;
                }
            }
        }
//        header('Content-type: application/json');
//        echo json_encode($pol->header->right);
        $this->pull($pol);
    }


    public function pull($list)
    {
        $header = $list->header->right;
        $i = 0;
        while($header->value){
            // 每个头结点
            while ($header->down){
                $have_node = $header->down;
                while ($header->right){

                }
            }
            // end
            $header = $header->value;
        }
        for ($i = 0; $i < $list->header->row; $i++) { //行 row
            for ($j = 0; $j < $list->header->col; $j++) { //列 col
                $right_node = $this->findKth($j, $list->header->right, 'value');
                $node = $this->findKth($i, $right_node->down, 'down');
                echo $node != null ? $node->value : 0;
                echo ' | ';
            }
            echo '<br>';
        }
    }

    public function findKth($index, $list, $var)
    {
        $current = $list;
        $i = 0;
        while ($i != $index && !empty($current->$var)) {
            $current = $current->$var;
            $i++;
        }
        return $i == $index ? $current : null;
    }


}