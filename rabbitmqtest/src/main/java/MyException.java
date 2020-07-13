/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/24 14:03
 */
public class MyException extends  Exception{

    public MyException(String message) {
        super(message);
    }

    @Override
    public String getLocalizedMessage() {
        return "你是不是猪";
    }
}
