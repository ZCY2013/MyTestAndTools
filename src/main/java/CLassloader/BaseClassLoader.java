package CLassloader;

/**
 *ClassLoader启动顺序：BootStrapCL=>ExtensionCl=>AppCL=>CustomCL ClassLoader启动前逆序检查类是否已经加载
 * AppCL默认加载器的父类是ExtensionCL，ExtensionCl的父类为null
 */
public class BaseClassLoader {
    public static void main(String[] args)
    {
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("System Class Loader:"+appClassLoader);
        ClassLoader extensionClassLoader = appClassLoader.getParent();
        System.out.println("System Class Loader Parent extensionClassLoader:"+extensionClassLoader);
        ClassLoader bootstrapClassLoader = extensionClassLoader.getParent();
        System.out.println("Extension Class Loader Parent BootStrapLoader: "+bootstrapClassLoader);
    }
}
