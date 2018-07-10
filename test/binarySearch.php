<?php

namespace test;

/**
 * 二分查找
 * Class binarySearch
 * @package test
 */
class binarySearch
{
    public function index()
    {
        $data = [];
        for ($i = 0; $i < 200; $i += 2) {
            $data[] = $i;
        }
        $search = mt_rand(0, 200);
        dump($search);
        $max_index = count($data) - 1;
        $min_index = 0;
        $avg_index = ceil(($max_index + $min_index) / 2);
        dump(['min' => $min_index . ' => ' . $data[$min_index],
            'avg' => $avg_index . ' => ' . $data[$avg_index],
            'max' => $max_index . ' => ' . $data[$max_index],
        ]);
        while ($max_index >= $min_index) {
            dump($search);
            if ($search > $data[$avg_index]) {
                $min_index = $avg_index + 1;
            } else if ($search < $data[$avg_index]) {
                $max_index = $avg_index - 1;
            } else {
                echo '找到 ' . $avg_index . ' => ' . $data[$avg_index];
                exit;
            }
            $avg_index = ceil(($max_index + $min_index) / 2);
            dump(['min' => $min_index . ' => ' . $data[$min_index],
                'avg' => $avg_index . ' => ' . $data[$avg_index],
                'max' => $max_index . ' => ' . $data[$max_index],
            ]);
        }
        echo '没有找到';
    }
}