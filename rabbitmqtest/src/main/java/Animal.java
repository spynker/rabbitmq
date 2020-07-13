/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 16:06
 */
public class Animal {

//    public Animal(){}

    public Animal(String name){
        this.name = name;
    }

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
