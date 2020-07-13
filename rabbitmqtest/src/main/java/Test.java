import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 16:32
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String classPath = "D:/Ideaworkspace/geektime-spring-family/Chapter 13/rabbitmqtest/target/classes/Cat.class";
        MyClassLoader classLoader = new MyClassLoader(classPath);
        String className = "Cat";
        Class<?> catClazz = classLoader.loadClass(className);
        System.out.println("类加载器是：" + catClazz.getClassLoader());
        Method method = catClazz.getDeclaredMethod("say");
        method.invoke(catClazz.newInstance(),null);

    }

    public static void swap(String m, String n) {
        String temp = m;
        m = n;
        n = temp;
        System.out.println(m);
        System.out.println(n);
    }
}
