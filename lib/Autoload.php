<?php

namespace lib;


class AutoLoad
{
    /**
     * 维护一个命名空间前缀和具体路径对应的映射表
     * 一个命名空间前缀中可以有多个路径
     *
     * @var array
     */

    protected $prefixes = array();

    /**
     * 注册加载函数到自动加载函数栈中
     *
     * @return void
     */
    public function register()
    {
        spl_autoload_register(array($this, 'loadClass'));

        //系统默认添加
        $this->addNamespace([
            'test' => APP_PATH .'test' . DIRECTORY_SEPARATOR,
        ]);
    }

    /**
     * 给一个命名空间前缀中添加具体的路径.
     *
     * @param string|array $namespace 命名空间
     * @param string $base_dir 要添加到命名空间中的路径
     * @param bool $append 如果为true，则将该路径添加到命名空间对应数组的
     * 最前面，而不是添加到末尾；这个会影响自动加载的搜索文件
     *
     * @return void
     */
    public function addNamespace($namespace, $base_dir = '', $append = false)
    {
        if (is_array($namespace)) {
            if ($append) {
                $this->prefixes = array_merge($this->prefixes, $namespace);
            } else {
                $this->prefixes = array_merge($namespace, $this->prefixes);
            }
        } else {
            if ($append) {
                array_unshift($this->prefixes[$namespace], $base_dir);
            } else {
                array_push($this->prefixes[$namespace], $base_dir);
            }
        }
    }

    /**
     * 加载给定类的对应的类库文件
     *
     * @param string $class 完整的类库名称.
     * @return mixed 成功时返回类名对应的类库文件路径，失败时返回false.
     */
    public function loadClass($class)
    {
        //通过命名空间去查找对应的文件
        $pos = strrpos($class, '\\');
        // 可能存在的命名空间前缀
        $prefix = substr($class, 0, $pos);
        // 剩余部分是可能存在的类
        $relative_class = substr($class, $pos + 1);
        //试图加载prefix前缀和relitive class对应的文件
        $mapped_file = $this->loadMappedFile($prefix, $relative_class);
        if ($mapped_file) {
            return $mapped_file;
        }

        // 未找到试图加载的文件
        return false;
    }

    /**
     * 加载命名空间前缀和relative class映射的文件.
     *
     * @param string $prefix 命名空间前缀.
     * @param string $relative_class relative class名称.
     * @return mixed 成功返回映射的文件路径，失败返回false.
     */
    protected function loadMappedFile($prefix, $relative_class)
    {
        if (isset($this->prefixes[$prefix]) === false) {
            //不是默认
            $this->prefixes[$prefix] = APP_PATH. $prefix . DIRECTORY_SEPARATOR;
        }
        // 用具体路径替换掉命名空间前缀,
        // 替换relative class中的命名空间分隔符为目录分隔符
        // 添加.php后缀
        $file = $this->prefixes[$prefix].$relative_class.'.php';

        // 如果映射文件存在加载对应的文件
        if ($this->requireFile($file)) {
            // 返回成功加载的文件路径
            return $file;
        }

        // 未找到要映射的文件返回false
        return false;
    }

    /**
     * 如果文件存在，从文件系统中加载他到运行环境中.
     *
     * @param string $file 要加在的文件.
     * @return bool 文件存在返回true，否在返回false.
     */
    protected function requireFile($file)
    {
        if (file_exists($file)) {
            require $file;
            return true;
        }
        return false;
    }
}