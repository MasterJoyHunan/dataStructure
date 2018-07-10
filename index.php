<?php
include_once './lib/Autoload.php';
defined('APP_PATH') or define('APP_PATH', dirname($_SERVER['SCRIPT_FILENAME']) . DIRECTORY_SEPARATOR);

class App
{
    public static function run()
    {
        $Autoload = new lib\Autoload();
        $Autoload->register();
        self::exec();
    }


    private static function exec()
    {
        //获取控制器和方法
        $req = (isset($_SERVER['REDIRECT_PATH_INFO']) ? $_SERVER['REDIRECT_PATH_INFO'] : '');
        $arr = explode('/', $req);
        $action = !empty($arr[0]) ? $arr[0] : 'index';
        $method = !empty($arr[1]) ? $arr[1] : 'index';
        //找到控制器所在的类
        try {
            $res = new \ReflectionClass('test\\' . $action);
            $instance = $res->newInstance();
            $get_method = $res->getMethod($method);
            //调用控制器的方法
            $get_method->invoke($instance);
        } catch (Exception $e) {
            if (!is_file(APP_PATH.'test'.DIRECTORY_SEPARATOR.$action.'.php')){
                throw new Exception('文件不存在');
            }
        }
    }
}
/**
 * 打印输出
 * @param $str
 * @param $info
 */
function dump($str='', $info='')
{
    if (!$info){
        echo '<pre style="border: 1px solid #000; margin: 30px; padding: 30px;">';
        print_r($str);
        echo '</pre>';
    }else{
        echo '<pre style="border: 1px solid #000; margin: 30px; padding: 30px;">';
        echo '<h3>'.$str.': </h3><hr>';
        print_r($info);
        echo '</pre>';
    }
}
App::run();