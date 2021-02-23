package classLoader.test;

/**
 * 双亲委派模型即 loadClass --> findClass --> defineClass
 *
 * loadClass 定义了双亲委派模型的模板,如果要打破只需要重写loadClass即可
 * findClass 定义了寻找class的方式,默认使用的是UrlClassLoader的findClass
 * defineClass 定义了加载class的方式,进行校验等,属于底层方法和双亲委派模型无关
 */
public  class MyClassLoader extends ClassLoader {
    public Class<?> defineClass(String name, byte[] b) {
        // ClassLoader是个抽象类，而ClassLoader.defineClass 方法是protected的
        // 所以我们需要定义一个子类将这个方法暴露出来
        return super.defineClass(name, b, 0, b.length);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }
}
