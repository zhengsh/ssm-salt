package cn.edu.cqvie.loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ClassLoaderTest extends ClassLoader {

    private static String rxRootPath;

    static {
        rxRootPath = "/temp/class/";
    }

    @Override
    public Class findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    /**
     * 读取 .class 文件为字节数组
     *
     * @param name 全路径类名
     * @return
     */
    private byte[] loadClassData(String name) {
        try {
            String filePath = fullClassName2FilePath(name);
            InputStream is = new FileInputStream(new File(filePath));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[2048];
            int r;
            while ((r = is.read(buf)) != -1) {
                bos.write(buf, 0, r);
            }
            return bos.toByteArray();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 全限定名转换为文件路径
     *
     * @param name
     * @return
     */
    private String fullClassName2FilePath(String name) {
        return rxRootPath + name.replace(".", "//") + ".class";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoaderTest classLoader = new ClassLoaderTest();
        String className = "com.test.TestAA";

        Class clazz = classLoader.loadClass(className);
        System.out.println(clazz.getClassLoader());
        // 输出结果
        //cn.xxx.xxx.loader.ClassLoaderTest@3764951d
    }
}
