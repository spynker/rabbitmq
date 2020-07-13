/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 16:07
 */
public class Dog  extends Animal implements  ISay{
    public Dog(String name){
        super("狗");
//        super();
        this.name = name;

    }

    @Override
    public void say() {
        System.out.println("hello");
    }
}
