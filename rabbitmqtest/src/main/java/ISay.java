/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 17:59
 */
public interface ISay {
    void say();

    default void eat() {
        System.out.println("eating...");
    }

    static void sleep(){
        System.out.println("sleep");
    }
}
